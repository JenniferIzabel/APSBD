package produtor;

import Main.Conexao;

public class Produtor extends Thread {
	private Thread t;
	private int numeroItens;
	private int numeroTransacoes;
	private int numeroAcessos;
	private static GerenciadorTransacao gerenciador;
	private boolean flag = true;
	
	public Produtor(int numeroItens, int numeroTransacoes, int numeroAcessos, Conexao conexao) {
		this.numeroItens = numeroItens;
		this.numeroTransacoes = numeroTransacoes;
		this.numeroAcessos = numeroAcessos;
	}
	
	public void run() {
		int ultimoIndice = 0;
		//System.out.println( "Criando transacoes e gravando no banco..." );
		try {
			do {
				ultimoIndice = TransacaoDao.pegarUltimoIndice();
				gerenciador = new GerenciadorTransacao(numeroItens, numeroTransacoes, numeroAcessos, ultimoIndice);
				Schedule schedule = new Schedule(gerenciador.getListaTransacoes());
				TransacaoDao.gravarTransacoes(schedule);
				//System.out.println( "ok" );
				Thread.sleep( 3 * 1000 );
				//System.out.println( "ok" );
			} while(flag);
		}catch (InterruptedException e) {
			e.printStackTrace();
 		}
	}
	
	public void setFlag(boolean state) {
		this.flag = state;
	}
	
	public void start() {
	 if (t == null) {
         t = new Thread (this);
         t.start ();
      }
	}

}

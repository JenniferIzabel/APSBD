package produtor;

import java.util.LinkedList;

public class GerenciadorTransacao {
	private ListaDados dados;
	private LinkedList<Transacao> listaTransacoes;


	private int numeroAcessos;
	
	public GerenciadorTransacao(int numeroItens, int numeroTransacoes, int numeroAcessos, int ultimoIndice) {
		dados = new ListaDados(numeroItens);
		listaTransacoes = new LinkedList<>();
		this.numeroAcessos = numeroAcessos;
		createTransacoes(numeroTransacoes, ultimoIndice);
	}

	private void createTransacoes(int numeroTransacoes, int ultimoIndice) {
		
		while(numeroTransacoes > 0) {
			ultimoIndice++;
			Transacao novaTransacao = new Transacao(dados, numeroAcessos, ultimoIndice);
			printTransacao(novaTransacao);
			listaTransacoes.add(novaTransacao);
			numeroTransacoes--;
		}
	}
	
	private void printTransacao(Transacao novaTransacao) {
		
	}

	public LinkedList<Transacao> getListaTransacoes() {
		return listaTransacoes;
	}

}

package produtor;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.IntStream;


public class Transacao {
	private int meuIndice;
	private LinkedList<Operacao> filaOperacoes;
	private String rotuloTransacao;
	
	public Transacao(ListaDados dados, int numeroAcessos, int ultimoIndice) {
		meuIndice = ultimoIndice;
		filaOperacoes = new LinkedList<>();
		rotuloTransacao = "T" + ultimoIndice + ":";
		filaOperacoes.add(new Operacao(Acesso.START, ultimoIndice));
		ramdomizaOperacoes(dados.getDados(), numeroAcessos);
		filaOperacoes.add(new Operacao(Acesso.END, ultimoIndice));
	}

	private void ramdomizaOperacoes(LinkedList<Dado> dados, int numeroAcessos) {
		 int tamanhoConjunto = dados.size();
	        int[] vetorPosicoes;
	        int[] vetorAcessos;
	        int cursor = 0;
	        
	        Random posAleatorias = new Random();
	        IntStream streamPosicoes = posAleatorias.ints(numeroAcessos, 0, tamanhoConjunto);
	        vetorPosicoes = streamPosicoes.toArray();
	        
	        Random acessosaleatorios = new Random();
	        IntStream streamAcessos = acessosaleatorios.ints(numeroAcessos, 0, 2);
	        vetorAcessos = streamAcessos.toArray();
	        
	        while(cursor < numeroAcessos) {
	            int operacao = vetorAcessos[cursor];
	            int posDado = vetorPosicoes[cursor];
	            
	            if(operacao == 0) {
	                filaOperacoes.add(new Operacao(dados.get(posDado).getNome(), Acesso.READ, meuIndice ));
	            }
	            else if (operacao == 1) {
	            	filaOperacoes.add(new Operacao(dados.get(posDado).getNome(), Acesso.WRITE, meuIndice ));
	            }
	            cursor++;
	        }
	}
	
	public int getMeuIndice() {
		return meuIndice;
	}

	public void setMeuIndice(int meuIndice) {
		this.meuIndice = meuIndice;
	}

	public LinkedList<Operacao> getFilaOperacoes() {
		return filaOperacoes;
	}

	public void setFilaOperacoes(LinkedList<Operacao> filaOperacoes) {
		this.filaOperacoes = filaOperacoes;
	}

	public String getRotuloTransacao() {
		return rotuloTransacao;
	}

	public void setRotuloTransacao(String rotuloTransacao) {
		this.rotuloTransacao = rotuloTransacao;
	}

	public boolean transIsEmpty() {
		return filaOperacoes.isEmpty();
	}

	public Operacao getFirstOp() {
		return filaOperacoes.getFirst();
	}

	public void removeOp() {
		filaOperacoes.removeFirst();
	}
	

}

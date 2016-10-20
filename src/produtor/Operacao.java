package produtor;

import produtor.Acesso;
import produtor.Dado;

public class Operacao {
	private int indice;
	private Acesso operacao;
	private Dado dado;
	
	
	public Operacao(String nome, Acesso acesso, int meuIndice) {
		this.setOperacao(acesso);
		this.setIndice(meuIndice);
		this.setDado(new Dado(nome));
	}
	
	public Operacao(Acesso acesso, int ultimoIndice) {
		this.setOperacao(acesso);
		this.setIndice(ultimoIndice);
		this.setDado(new Dado(null));
	}

	public Dado getDado() {
		return dado;
	}

	public void setDado(Dado dado) {
		this.dado = dado;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Acesso getOperacao() {
		return operacao;
	}

	public void setOperacao(Acesso operacao) {
		this.operacao = operacao;
	}

}

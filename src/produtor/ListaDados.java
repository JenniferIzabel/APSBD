package produtor;

import produtor.Dado;
import java.util.LinkedList;

public class ListaDados {
	private LinkedList<Dado> dados;
	public ListaDados(int numeroItens) {
		dados = new LinkedList<>();
		gerarDados(numeroItens);
	}

	private void gerarDados(int numeroItens) {
		while(numeroItens > 0) {
			String nomeDado = "ID" + numeroItens;
			dados.add(new Dado(nomeDado));
			numeroItens--;
		}
	}

	public LinkedList<Dado> getDados() {
		return dados;
	}

}

package Main;

import Escalonador.Escalonador;
import java.util.Scanner;
import produtor.Produtor;

public class Main {

    private static int numeroItens = 3;
    private static int numeroTransacoes = 2;
    private static int numeroAcessos = 6;
    private static int numeroConsumo = 10;
    private static Scanner scanner;
    private static Conexao conexao;

    public static void main(String[] args) {
        conexao = new Conexao();
        Conexao.getCabecalho();
        //PRODUTOR
        System.out.println("Criando transacoes e gravando no banco...");
        Produtor produtor = new Produtor(numeroItens, numeroTransacoes, numeroAcessos, conexao);
        produtor.start();

        //CONSUMIDOR
        System.out.println("Escalonando as transações...");
        Escalonador escalonador = new Escalonador(numeroConsumo, conexao);

        //PRODUTOR
        scanner = new Scanner(System.in);
        System.out.println("Pressione Enter para encerrar a producao");
        if (scanner.hasNextLine()) {
            System.out.println("Producao encerrada");
            produtor.setFlag(false);
        }
        //CONSUMIDOR
        System.out.println("Escalonando as transações...");

        System.out.println("Escalonamento terminado!!!!");

    }

}

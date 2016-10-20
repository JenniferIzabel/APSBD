/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

import Main.Conexao;

/**
 *
 * @author jennifer
 */
public class Escalonador extends Thread {

    private Thread t2;
    private int numeroConsumo;
    private Conexao con;
    private int inicio;
    private int fim;
    private boolean flag = true;

    public Escalonador(int numeroConsumo, Conexao con) {
        this.numeroConsumo = numeroConsumo;
        this.con = con;
        this.inicio = 0;
        this.fim = this.inicio + this.numeroConsumo;
    }

    public void run() {
        int ultimoIndice = 0;
        //System.out.println( "Criando transacoes e gravando no banco..." );
        try {
            do {
                ListaTuplasDao listaTuplasDao = new ListaTuplasDao(con, inicio, fim, numeroConsumo);

                Thread.sleep(5 * 1000);
            } while (flag);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFlag(boolean state) {
        this.flag = state;
    }

    public void start() {
        if (t2 == null) {
            t2 = new Thread(this);
            t2.start();
        }
    }

}

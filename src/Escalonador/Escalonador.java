/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

import Main.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 */
public class Escalonador extends Thread {

    private Thread t2;
    private int numeroConsumo;
    private Conexao conexao;
    private int inicio;
    private int fim;
    private boolean flag = true;

    public Escalonador(int numeroConsumo, Conexao con) {
        this.numeroConsumo = numeroConsumo;
        this.conexao = con;
        encontraInicio();
        this.fim = this.inicio + this.numeroConsumo;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    private void encontraInicio() {
        Connection con = conexao.getConnection();
        String sql = "SELECT MIN(idoperacao) FROM schedule;";
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            this.inicio = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ListaTuplas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {

        try {
            do {
                ListaTuplas listaTuplas = new ListaTuplas(conexao, inicio, fim, numeroConsumo);
                listaTuplas.selectBlocoTuplas();

                this.inicio = this.fim;
                this.fim += this.numeroConsumo;
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

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
import java.util.LinkedList;

/**
 *
 * @author jennifer
 */
public class ListaTuplasDao {

    private static Conexao conexao;
    private int inicio;
    private int fim;
    private int numeroConsumo;
    private LinkedList<Tupla> listaTuplas;

    public ListaTuplasDao(Conexao conexao, int inicio, int fim, int numeroConsumo) {
        this.conexao = conexao;
        Conexao.getCabecalho();
        this.inicio = inicio;
        this.fim = fim;
        this.numeroConsumo = numeroConsumo;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFim() {
        return fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    public LinkedList<Tupla> getVetorTuplas() {
        return listaTuplas;
    }

    public LinkedList<Tupla> selectBlocoTuplas() {

        Connection con = conexao.getConnection();
        String sql = "SELECT indiceTransacao, operacao, itemDado, timestampj FROM schedule WHERE ? >= idOperacao AND idOperacao < ?;";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, this.inicio);
            ps.setInt(2, this.fim);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tupla tupla = new Tupla(rs.getInt("indiceTransacao"), rs.getString("operacao"), rs.getString("itemDado"), rs.getString("timestampj"));
                listaTuplas.add(tupla);
                System.out.println(tupla.toString());
            }

            this.inicio = this.fim;
            this.fim += this.numeroConsumo;

        } catch (SQLException e) {
            System.err.println("Erro no select");
            e.printStackTrace();
        }
        return this.listaTuplas;
    }
    
    

}

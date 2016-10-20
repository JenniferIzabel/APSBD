/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

import java.sql.Date;
import produtor.Operacao;
import java.util.LinkedList;
import produtor.Acesso;
import produtor.Dado;

/**
 *
 * @author jennifer
 */
public class Tupla {
    private int idTransacao;
    private String operacao;
    private String dado;
    private String timeStamp;

    public Tupla(int idTransacao, String operacao, String dado, String timeStamp) {
        this.idTransacao = idTransacao;
        this.operacao = operacao;
        this.dado = dado;
        this.timeStamp = timeStamp;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getDado() {
        return dado;
    }

    public void setDado(String dado) {
        this.dado = dado;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Tupla{" + "indice=" + idTransacao + ", operacao=" + operacao + ", dado=" + dado + ", timeStamp=" + timeStamp + '}';
    }
    
    
    
    
}

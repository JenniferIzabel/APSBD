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
    private Operacao operacao;
    private Dado dado;
    private Date timeStamp;

    private String temp_operacao;
    private String temp_dado;
    private String temp_timeStamp;

    public Tupla(int idTransacao, String operacao, String dado, String timeStamp) {
        this.idTransacao = idTransacao;
        this.temp_operacao = operacao;
        this.temp_dado = dado;
        this.temp_timeStamp = timeStamp;
    }

    public Tupla(int idTransacao, Operacao operacao, Dado dado, Date timeStamp) {
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

    public Operacao getOperacao() {
        return operacao;
    }

    public void setTemp_operacao(String temp_operacao) {
        this.temp_operacao = temp_operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Dado getDado() {
        return dado;
    }

    public void setTemp_dado(String temp_dado) {
        this.temp_dado = temp_dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTemp_timeStamp(String temp_timeStamp) {
        this.temp_timeStamp = temp_timeStamp;
    }

    @Override
    public String toString() {
        return "Tupla{" + "indice=" + idTransacao + ", operacao=" + temp_operacao + ", dado=" + temp_dado + ", timeStamp=" + temp_timeStamp + '}';
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

import java.util.LinkedList;
import produtor.Dado;

/**
 *
 * @author jennifer
 */
public class Tratamento {

    private Dado dado;
    private int idTransacao;
    private LinkedList<Integer> filaEspera = new LinkedList<>();
    private LinkedList<Integer> filaLeitura = new LinkedList<>();
    private Status status;

    public Tratamento(Dado dado, int idTransacao, char statusDado) {
        this.dado = dado;
        this.idTransacao = idTransacao;
    }

    public void lock_s() {
        if (dado.getStatusDado().equals(status.UNLOCKED)) {
            this.filaLeitura.add(idTransacao);
            dado.setStatusDado(String.valueOf(status.SHARED));
        } else if (dado.getStatusDado().equals(status.SHARED)) {
            this.filaLeitura.add(idTransacao);
        } else { //statusDado.texto.equals(status.EXCLUSIVE)
            this.filaEspera.add(idTransacao);
        }
    }

    public void lock_x() {
        if (dado.getStatusDado().equals(status.UNLOCKED)) {
            dado.setStatusDado(String.valueOf(status.EXCLUSIVE));
        } else {
            this.filaEspera.add(idTransacao);
        }
    }

    public void unlock() {
        if (dado.getStatusDado().equals(status.EXCLUSIVE)) {
            dado.setStatusDado(String.valueOf(status.UNLOCKED));
            this.idTransacao = this.filaEspera.getFirst();
            this.filaEspera.removeFirst();
        } else if (dado.getStatusDado().equals(status.SHARED)) {
            this.filaEspera.removeFirst();
            if (this.filaEspera.equals(null)) {
                dado.setStatusDado(String.valueOf(status.UNLOCKED));
                this.idTransacao = this.filaEspera.getFirst();
                this.filaEspera.removeFirst();
            }
        }
    }

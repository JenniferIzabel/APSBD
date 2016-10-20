/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

import java.util.LinkedList;

/**
 *
 * @author jennifer
 */
public class ListaTuplas {

    private LinkedList<Tupla> listaTuplas;

    public ListaTuplas() {
    }

    private void pegarBanco(){
        
        
    }
    
    

    public void adicionarTupla(Tupla tupla) {
        listaTuplas.add(tupla);
    }

    public void adicionarTupla(LinkedList<Tupla> listaTuplas) {
        listaTuplas.addAll(listaTuplas);
    }

}

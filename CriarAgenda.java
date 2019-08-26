package com.company;

import java.util.ArrayList;

public class CriarAgenda implements Comparable{
    String Nome;
    String numero;
    ArrayList<String> array_numero = new ArrayList<String>();

    public CriarAgenda(String Nome, String Numero){
        this.Nome = Nome;
        //array_numero.add(numero);
        this.numero = Numero;
    }

    public String getNome(){
        return Nome;
    }

    public String getNumero() {
        return numero;
    }



    @Override
    public int compareTo(Object o) {
        return getNome().compareTo(((CriarAgenda) o).getNome());
    }
}

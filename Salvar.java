package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Salvar {
    FileWriter out = null;
    public Salvar(ArrayList<CriarAgenda> agenda) throws IOException{

        try {
            out = new FileWriter("contatos.txt");
            for(CriarAgenda caa :agenda){
                out.append(caa.getNome() + ", "+ caa.getNumero()+"\n");
            }

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}

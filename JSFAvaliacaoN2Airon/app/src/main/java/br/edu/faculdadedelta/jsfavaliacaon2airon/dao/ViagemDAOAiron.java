package br.edu.faculdadedelta.jsfavaliacaon2airon.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.jsfavaliacaon2airon.modelo.ViagemAiron;

public class ViagemDAOAiron {

    private static List<ViagemAiron> listaViagem = new ArrayList<>();
    private static Long idGerador = 1L;

    public void incluir(ViagemAiron viagem){
        viagem.setId(idGerador++);
        listaViagem.add(viagem);
    }

    public void excluir(ViagemAiron viagem){
        listaViagem.remove(viagem);
    }

    public List<ViagemAiron> listar(){
        return listaViagem;
    }

    public void alterar(ViagemAiron viagem){
        for (ViagemAiron viagemAux: listaViagem){
            long idViagem = viagem.getId();
            long idViagemAux = viagemAux.getId();
            if(idViagem == idViagemAux){
                listaViagem.remove(viagemAux);
                listaViagem.add(viagem);
                break;
            }
        }
    }


}

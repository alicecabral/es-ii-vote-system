package com.es;

import java.util.Date;

public class Voto {
    
    private Cidadao cidadao;
    private String coordenadaGeografica;
    private String justificativa;
    private Date data;
    private VotoEnum voto;

    public Voto(Cidadao cidadao, String coordenadaGeografica, String justificativa, Date data, VotoEnum voto) {
        this.cidadao = cidadao;
        this.coordenadaGeografica = coordenadaGeografica;
        this.justificativa = justificativa;
        this.data = data;
        this.voto = voto;
    }

    public VotoEnum getVoto() {
        return voto;
    }

    public void setVoto(VotoEnum voto) {
        this.voto = voto;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public String getCoordenadaGeografica() {
        return coordenadaGeografica;
    }

    public void setCoordenadaGeografica(String coordenadaGeografica) {
        this.coordenadaGeografica = coordenadaGeografica;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    private boolean CidadaoJaVotou(String CPF){
        //codigo para testar se o cidadao ja consta no BD
        return false;
    }
    private boolean isVotoValido(Voto voto){
        if(CidadaoJaVotou(voto.cidadao.getCpf())){
            return false;
        }
        return voto.cidadao.getIdade() >= 16;

    }
    public boolean RegistraVoto(Voto voto){

        if(isVotoValido(voto)){
            //registra Voto no BD
            return true;
        }
        return false;


    }
}

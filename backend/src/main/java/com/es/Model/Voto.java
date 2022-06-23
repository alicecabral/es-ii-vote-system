package com.es.model;

import com.es.model.Enum.VotoEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="VOTO")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @OneToOne
    @JoinColumn(name = "cidadao_id")
    private Cidadao cidadao;

    @Column(name = "coordenadaGeografica",nullable = false)
    private String coordenadaGeografica;

    @Column(name = "justificativa",nullable = false)
    private String justificativa;

    @Column(name = "data",nullable = false)
    private Date data;

    @Column(name = "voto",nullable = false)
    private VotoEnum voto;


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

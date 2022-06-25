package com.es.model;

import com.es.model.Enum.VotoEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public VotoEnum getVoto() {
        return voto;
    }

    public void setVoto(VotoEnum voto) {
        this.voto = voto;
    }
}

package com.es.model;

import com.es.model.Enum.SexoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="CIDADAO")
public class Cidadao{
    @Id
    @Size(max=11,min=11)
    @Column(name = "cpf",nullable = false)
    private String  cpf;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "sexo",nullable = false)
    private SexoEnum sexo;

    @Column(name = "idade",nullable = false)
    private int idade;

    @OneToOne(mappedBy = "cidadao")
    @JsonIgnore
    private Voto voto;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
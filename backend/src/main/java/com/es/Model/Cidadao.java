package com.es.model;

import com.es.model.Enum.SexoEnum;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name="CIDADAO")
public class Cidadao{
    @Id
    @Size(max=11,min=11)
    @Column(name = "cpf",nullable = false)
    private String  cpf;

    @Column(name = "sexo",nullable = false)
    private SexoEnum sexo;

    @Column(name = "idade",nullable = false)
    private int idade;

    @OneToOne(mappedBy = "cidadao")
    private Voto voto;

}
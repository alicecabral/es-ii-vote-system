package com.es.rest.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class VotoForm {//completar form de aceitação voto
    @NotBlank
    private String coordenadaGeografica;
    private String justificativa;
    private String cpf;
    private String
}

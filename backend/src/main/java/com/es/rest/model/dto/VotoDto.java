package com.es.rest.model.dto;

import com.es.Model.Enum.VotoEnum;
import com.es.Model.Voto;
import lombok.Data;
import com.es.Model.Cidadao;
import java.util.Date;

@Data
public class VotoDto {
    private Cidadao cidadao;
    private String coordenadaGeografica;
    private String justificativa;
    private Date data;
    private VotoEnum voto;

    public VotoDto(Voto voto){
        this.cidadao = voto.getCidadao();
        this.voto = voto.getVoto();
        this.coordenadaGeografica = voto.getCoordenadaGeografica();
        this.justificativa = voto.getJustificativa();
        this.data = voto.getData();
    }

}

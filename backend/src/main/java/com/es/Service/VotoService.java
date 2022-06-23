package com.es.service;

import com.es.model.Voto;
import com.es.rest.model.dto.VotoDto;
import com.es.rest.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VotoService {

    @Autowired
    VotoRepository votoRepository;
     public VotoDto criaVoto(Voto voto){
        return null;
     }
    public List<VotoDto> findAllVotos(){
         List<Voto> votos = votoRepository.findAll();
         return convertListToDto(votos);

    }
    public VotoDto findVotoById(int id){
         Optional<Voto> opcional = votoRepository.findById(id);
         return opcional.map(this::convertToDto).orElse(null);
    }
    public VotoDto findVotoByCpf(String cpf){
        Optional<List<Voto>> opcional = Optional.ofNullable(votoRepository.findVotoByCpf(cpf));
        return opcional.map(votos -> (VotoDto) convertListToDto(votos)).orElse(null);
    }

    private List<VotoDto> convertListToDto(List<Voto> votos){
         return votos.stream().map(VotoDto::new).collect(Collectors.toList());
    }
    private VotoDto convertToDto(Voto voto){
         return new VotoDto(voto);

    }


}

package com.es.Service;

import com.es.model.Cidadao;
import com.es.model.Enum.SexoEnum;
import com.es.model.Enum.VotoEnum;
import com.es.model.Voto;
import com.es.rest.model.dto.VotoDto;
import com.es.rest.repository.CidadaoRepository;
import com.es.rest.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VotoService {

    @Autowired
    VotoRepository votoRepository;

    @Autowired
    CidadaoRepository cidadaoRepository;


    public VotoDto criaVoto(Voto voto) {
        return null;
    }

    public List<VotoDto> findAllVotos() {
        List<Voto> votos = votoRepository.findAll();
        return convertListToDto(votos);

    }

    public VotoDto findVotoById(int id) {
        Optional<Voto> opcional = votoRepository.findById(id);
        return opcional.map(this::convertToDto).orElse(null);
    }

    public Voto findVotoByCpf(String cpf) {
        Optional<List<Voto>> opcional = Optional.ofNullable(votoRepository.findVotoByCpf(cpf));
        if (opcional.get().size() > 0)
            return opcional.get().get(0);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse cidadão não tem votos");
    }

    private List<VotoDto> convertListToDto(List<Voto> votos) {
        return votos.stream().map(VotoDto::new).collect(Collectors.toList());
    }

    private VotoDto convertToDto(Voto voto) {
        return new VotoDto(voto);

    }

    private boolean CidadaoJaVotou(String CPF) {
        //codigo para testar se o cidadao ja consta no BD
        return false;
    }

    private boolean isVotoValido(Voto voto) {
        if (CidadaoJaVotou(voto.getCidadao().getCpf())) {
            return false;
        }
        return voto.getCidadao().getIdade() >= 16;
    }

    public ResponseEntity<Voto> registraVoto(Voto voto) {
        try {
            if (isVotoValido(voto)) {
                String teste = voto.getCidadao().getCpf();

                Cidadao cidadao = cidadaoRepository.getByCpf(voto.getCidadao().getCpf());
                if (cidadao != null) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Você deve respeitar as condições de voto : deve ter mais de 16 anos para votar e não pode votar duas vezes!");
                }
                cidadaoRepository.save(voto.getCidadao());
                votoRepository.save(voto);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Você deve respeitar as condições de voto : deve ter mais de 16 anos para votar e não pode votar duas vezes!");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public List<Voto> findVotoBySexo(SexoEnum sexo) {
        return votoRepository.findByCidadaoSexo(sexo);
    }

    public List<Voto> findVotoByCandidato(VotoEnum candidato) {
        return votoRepository.findVotoByVoto(candidato);
    }

    public Object findVotoByFaixaEtaria(int idadeInicial, int idadeFinal) {
        return votoRepository.getVotoByFaixaEtaria(idadeInicial, idadeFinal);
    }
}

package com.es.Controller;


import com.es.model.Enum.SexoEnum;
import com.es.model.Enum.VotoEnum;
import com.es.model.Voto;
import com.es.rest.model.dto.VotoDto;
import com.es.Service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    public List<VotoDto> list() {
        return votoService.findAllVotos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id) {

        try {
            return new ResponseEntity<>(votoService.findVotoById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/candidato/{candidato}")
    public ResponseEntity<Object> findByCandidato(@PathVariable("candidato") VotoEnum candidato) {

        try {
            return new ResponseEntity<>(votoService.findVotoByCandidato(candidato), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/faixaEtaria")
    public ResponseEntity<Object> findByFaixaEtaria(@RequestParam int idadeInicial, @RequestParam int idadeFinal) {

        try {
            return new ResponseEntity<>(votoService.findVotoByFaixaEtaria(idadeInicial, idadeFinal), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/cidadao/{cpf}")
    public ResponseEntity<Object> findByCpf(@PathVariable("cpf") String cpf) {
        try {

            return new ResponseEntity<>(votoService.findVotoByCpf(cpf), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sexo/{sexo}")
    public ResponseEntity<Object> findByCpf(@PathVariable("sexo")SexoEnum sexo) {
        try {
            return new ResponseEntity<>(votoService.findVotoBySexo(sexo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Object> registraVoto(@RequestBody @Valid Voto voto) {
        try {
            votoService.registraVoto(voto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

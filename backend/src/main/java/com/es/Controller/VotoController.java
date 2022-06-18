package com.es.Controller;

import com.es.Service.VotoService;
import com.es.rest.model.dto.VotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/voto")
public class VotoController {
    @Autowired
    private VotoService votoService;
    public List<VotoDto> list(){
        return votoService.findAllVotos();
    }
    @GetMapping("/{id}")
    public VotoDto findById(@PathVariable("id") int id){
        return votoService.findVotoById(id);

    }
    @GetMapping("/{cpf}")
    public VotoDto findByCpf(@PathVariable("cpf") String cpf){
        return votoService.findVotoByCpf(cpf);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public VotoDto registraVoto(@RequestBody @Valid){

    }
}

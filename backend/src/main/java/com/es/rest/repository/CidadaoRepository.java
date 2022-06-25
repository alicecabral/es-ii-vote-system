package com.es.rest.repository;

import com.es.model.Cidadao;
import com.es.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadaoRepository extends JpaRepository<Cidadao, String> {
    Cidadao getByCpf(String cpf);
}

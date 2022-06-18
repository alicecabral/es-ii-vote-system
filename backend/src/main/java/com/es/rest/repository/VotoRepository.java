package com.es.rest.repository;

import com.es.Model.Voto;
import com.es.rest.model.dto.VotoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface VotoRepository extends JpaRepository<Voto,Integer> {
    @Query("SELECT * FROM VOTO v WHERE v.cpf LIKE cpf ")
    List<Voto> findVotoByCpf(@Param("cpf") String cpf);



}

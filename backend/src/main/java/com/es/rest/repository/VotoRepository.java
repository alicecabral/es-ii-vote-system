package com.es.rest.repository;

import com.es.model.Enum.SexoEnum;
import com.es.model.Enum.VotoEnum;
import com.es.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VotoRepository extends JpaRepository<Voto,Integer> {
    @Query("SELECT v FROM Voto v WHERE v.cidadao.cpf = :cpf ")
    List<Voto> findVotoByCpf(@Param("cpf") String cpf);
    List<Voto> findVotoByVoto(@Param("voto") VotoEnum voto);
    List<Voto> findByCidadaoSexo(@Param("sexo")SexoEnum sexo);


    @Query("SELECT v FROM Voto v WHERE v.cidadao.idade BETWEEN :idadeInicial AND :idadeFinal")
    List<Voto> getVotoByFaixaEtaria(@Param("idadeInicial") int idadeInicial, @Param("idadeFinal") int idadeFinal);
}

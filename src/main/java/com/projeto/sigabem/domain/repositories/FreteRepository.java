package com.projeto.sigabem.domain.repositories;


import com.projeto.sigabem.domain.entities.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {

}

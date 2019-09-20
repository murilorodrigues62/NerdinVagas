package br.com.nerdin.vagas.repository;

import br.com.nerdin.vagas.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

}

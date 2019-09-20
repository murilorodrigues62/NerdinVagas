package br.com.nerdin.vagas.repository;

import br.com.nerdin.vagas.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    // Pode usar @Query para escrever manualmente a query se não for usar automaticamente
    List<Vaga> findByEmpresaNome(String empresaNome);
}

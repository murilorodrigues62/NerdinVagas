package br.com.nerdin.vagas.repository;


import br.com.nerdin.vagas.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findByNome(String nome);
}

package br.com.nerdin.vagas.controller;

import br.com.nerdin.vagas.dto.VagaDto;
import br.com.nerdin.vagas.model.Vaga;
import br.com.nerdin.vagas.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class VagasController {

    @Autowired // injeção de dependencia
    private VagaRepository vagaRepository;

    @RequestMapping("/vagas")
    public List<VagaDto> lista(){

        // Metodo findAll importado da interface da JpaRepository
        List<Vaga> vagas = vagaRepository.findAll();
        return VagaDto.convert(vagas);
    }
}

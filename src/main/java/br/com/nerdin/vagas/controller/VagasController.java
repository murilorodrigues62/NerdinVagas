package br.com.nerdin.vagas.controller;

import br.com.nerdin.vagas.controller.form.VagaForm;
import br.com.nerdin.vagas.dto.VagaDto;
import br.com.nerdin.vagas.dto.VagasDetalhesDto;
import br.com.nerdin.vagas.model.Vaga;
import br.com.nerdin.vagas.repository.EmpresaRepository;
import br.com.nerdin.vagas.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagasController {

    @Autowired // injeção de dependencia
    private VagaRepository vagaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public List<VagaDto> lista(String empresaNome){

        if (empresaNome == null){
            // Metodo findAll importado da interface da JpaRepository
            List<Vaga> vagas = vagaRepository.findAll();
            return VagaDto.convert(vagas);
        } else  {
            // Spring suporta o findBy<Atributo>, desta forma ele monta query automaticamente
            // inclusive por atributos de outras classes relacionadas findBy<Entidade><Atributo>
            List<Vaga> vagas = vagaRepository.findByEmpresaNome(empresaNome);
            return VagaDto.convert(vagas);
        }
    }

    // @RequestBody para pegar os dados do corpo da requisição, não da url
    // @Valid avisa o Spring para executa validações das anotações feitas na classe
    @PostMapping
    public ResponseEntity<VagaDto> cadastrar(@RequestBody @Valid VagaForm form, UriComponentsBuilder uriBuilder){
        Vaga vaga = form.convert(empresaRepository);
        vagaRepository.save(vaga);

        // return inserted code
        URI uri = uriBuilder.path("/vagas/{id}").buildAndExpand(vaga.getId()).toUri();

        // "Created" return http code 201
        return ResponseEntity.created(uri).body(new VagaDto(vaga));

    }

    @GetMapping("/{id}") // PathVariable identifica que o parâmetro vem da url
    public VagasDetalhesDto detalhar(@PathVariable Long id){
        Vaga vaga = vagaRepository.getOne(id);
        return new VagasDetalhesDto(vaga);
    }
}

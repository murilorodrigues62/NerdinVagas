package br.com.nerdin.vagas.dto;
import br.com.nerdin.vagas.model.Vaga;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

// Usando Dto para não expor diretamente no End-Point a Model com todos os campos e relacionamentos
public class VagaDto {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String empresaNome;

    public VagaDto(Vaga vaga){
        this.titulo = vaga.getTitulo();
        this.descricao = vaga.getDescricao();
        this.dataCriacao = vaga.getDataCriacao();
        this.empresaNome = vaga.getEmpresa().getNome();
        this.id = vaga.getId();
    }

    public static List<VagaDto> convert(List<Vaga> vagas) {
        // convert list of Vaga to VagaDto
        return vagas.stream().map(VagaDto::new).collect(Collectors.toList());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getEmpresaNome() { return empresaNome; }

    public Long getId() { return id; }
}

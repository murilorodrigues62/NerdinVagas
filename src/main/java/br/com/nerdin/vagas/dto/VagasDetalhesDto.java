package br.com.nerdin.vagas.dto;

import br.com.nerdin.vagas.model.Candidatura;
import br.com.nerdin.vagas.model.StatusVaga;
import br.com.nerdin.vagas.model.Vaga;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VagasDetalhesDto {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String empresaNome;
    private StatusVaga status;
    private List<CandidaturaDto> candidaturas;
    public VagasDetalhesDto(Vaga vaga) {

        this.id = vaga.getId();
        this.titulo = vaga.getTitulo();
        this.descricao = vaga.getDescricao();
        this.dataCriacao = vaga.getDataCriacao();
        this.empresaNome = vaga.getEmpresa().getNome();
        this.status = vaga.getStatus();
        this.candidaturas = new ArrayList<>();

        this.candidaturas.addAll(vaga.getCandidaturas().stream().map(CandidaturaDto::new).collect(Collectors.toList()));

    }

    public Long getId() {
        return id;
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

    public String getEmpresaNome() {
        return empresaNome;
    }

    public StatusVaga getStatus() {
        return status;
    }

    public List<CandidaturaDto> getCandidaturas() {
        return candidaturas;
    }
}

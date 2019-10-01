package br.com.nerdin.vagas.dto;

import br.com.nerdin.vagas.model.Candidatura;

import java.time.LocalDateTime;

public class CandidaturaDto {
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeCandidato;

    public CandidaturaDto(Candidatura candidatura) {
        this.id = candidatura.getId();
        this.mensagem = candidatura.getMensagem();
        this.dataCriacao = candidatura.getDataCriacao();
        this.nomeCandidato = candidatura.getCandidato().getNome();
    }
}

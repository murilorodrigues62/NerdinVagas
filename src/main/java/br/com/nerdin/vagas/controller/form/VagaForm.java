package br.com.nerdin.vagas.controller.form;

import br.com.nerdin.vagas.model.Empresa;
import br.com.nerdin.vagas.model.Vaga;
import br.com.nerdin.vagas.repository.EmpresaRepository;

// Form nada mais é que um DTO mas usado para receber dados via endpoint
public class VagaForm {

    private String titulo;
    private String descricao;
    private String nomeEmpresa;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Vaga convert(EmpresaRepository empresaRepository) {
        Empresa empresa = empresaRepository.findByNome(nomeEmpresa);
        return new Vaga(titulo, descricao, empresa);
    }
}

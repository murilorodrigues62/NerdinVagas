package br.com.nerdin.vagas.controller.form;

import br.com.nerdin.vagas.model.Empresa;
import br.com.nerdin.vagas.model.Vaga;
import br.com.nerdin.vagas.repository.EmpresaRepository;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Form nada mais é que um DTO mas usado para receber dados via endpoint
public class VagaForm {
    @NotNull @NotEmpty @Length(min = 5) // Bean Validation, no controler deve ser usado o @Valid para aplicar as validações
    private String titulo;
    @NotNull @NotEmpty @Length(min = 5)
    private String descricao;
    @NotNull @NotEmpty @Length(min = 2)
    private String EmpresaNome;

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

    public String getEmpresaNome() {
        return EmpresaNome;
    }

    public void setEmpresaNome(String empresaNome) {
        this.EmpresaNome = empresaNome;
    }

    public Vaga convert(EmpresaRepository empresaRepository) {
        Empresa empresa = empresaRepository.findByNome(EmpresaNome);
        return new Vaga(titulo, descricao, empresa);
    }
}

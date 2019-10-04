package br.com.nerdin.vagas.controller.form;

import br.com.nerdin.vagas.model.Vaga;
import br.com.nerdin.vagas.repository.VagaRepository;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Usado caso necessite controlar quais campos podem ser atualizados, não todos
public class AtualizacaoVagaForm {
    @NotNull @NotEmpty @Length(min = 5) // Bean Validation, no controler deve ser usado o @Valid para aplicar as validações
    private String titulo;
    @NotNull @NotEmpty @Length(min = 5)
    private String descricao;

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

    // Encapsulando regra de atualização
    public Vaga atualizar(Long id, VagaRepository vagaRepository) {
        Vaga vaga = vagaRepository.getOne(id);
        vaga.setTitulo(this.titulo);
        vaga.setDescricao(this.descricao);

        return vaga;
    }
}

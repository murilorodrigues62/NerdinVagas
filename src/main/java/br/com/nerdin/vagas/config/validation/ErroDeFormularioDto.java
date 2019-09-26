package br.com.nerdin.vagas.config.validation;

// Classe que será retornada no erro
public class ErroDeFormularioDto {
    private String campo;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}

package br.com.nerdin.vagas.config.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;


@RestControllerAdvice // Spring identifica que é uma classe de controle de exceptions, será chamada por qualquer Controller
public class ErroDeValidacaoHandler {
    @Autowired
    private MessageSource messageSource; // Ajuda pegar mensagens de erro de acordo com idioma Accept-Language no cabeçalho do consumo da API

    @ExceptionHandler(MethodArgumentNotValidException.class) // Quando o erro anotado ocorre, o spring intercepa o erro e executa o metodo
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) // Necessário para continuar retornando 400 e não 200
    public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception){

        List<ErroDeFormularioDto> dto = new ArrayList<>();

        // contém todos os erros de campos
        List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();

        fieldErros.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
            dto.add(erro);
        });

        return dto;
    }
}

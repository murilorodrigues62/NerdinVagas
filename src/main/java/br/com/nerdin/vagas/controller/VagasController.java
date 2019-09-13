package br.com.nerdin.vagas.controller;

import br.com.nerdin.vagas.dto.VagaDto;
import br.com.nerdin.vagas.model.Empresa;
import br.com.nerdin.vagas.model.Vaga;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class VagasController {

    @RequestMapping("/vagas")
    public List<VagaDto> lista(){
        Vaga vaga = new Vaga("DBA Oracle", "Vaga DBA Oracle Senior", new Empresa("ABCD", "TI"));

        return VagaDto.convert(Arrays.asList(vaga, vaga, vaga));
    }
}

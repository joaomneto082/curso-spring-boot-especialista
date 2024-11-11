package io.github.cursodsousa.arquiteturaspring.montadora.api;

import io.github.cursodsousa.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // pega a requisição
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired //pegar uma instancia de motor - Injetar o Bean
    // @Qualifier("motorTurbo")
    @Eletrico  // puxa pela annotation
    private Motor motor; //precisa dizer o motor para injeção

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){ //receber via JSON no corpo
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
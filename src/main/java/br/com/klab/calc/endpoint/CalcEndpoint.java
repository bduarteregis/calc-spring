package br.com.klab.calc.endpoint;

import br.com.klab.calc.model.Operacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculadora/")
public class CalcEndpoint {

    private Operacoes operacoes;

    @Autowired
    public CalcEndpoint(Operacoes operacoes) {
        this.operacoes = operacoes;
    }

    //////////////////////////////////////
    ///////// OPERAÇÕES BÁSICAS  /////////
    //////////////////////////////////////

    @GetMapping("/somar/{valor1}/{valor2}")
    public int soma(@PathVariable("valor1") int v1, @PathVariable("valor2") int v2) {
        return operacoes.soma(v1, v2);
    }


    @GetMapping("/subtrair/{valor1}/{valor2}")
    public int subtrai(@PathVariable("valor1") int v1, @PathVariable("valor2") int v2) {
        return operacoes.subtrai(v1, v2);
    }

    @GetMapping("/multiplicar/{valor1}/{valor2}")
    public int multiplica(@PathVariable("valor1") int v1, @PathVariable("valor2") int v2) {
        return operacoes.multiplica(v1, v2);
    }

    @GetMapping("/dividir/{valor1}/{valor2}")
    public ResponseEntity<String> divide(@PathVariable("valor1") double v1, @PathVariable("valor2") double v2) {
        try {
            return new ResponseEntity(String.valueOf(operacoes.divide(v1, v2)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Impossível dividir por 0.",HttpStatus.BAD_REQUEST);
        }
    }

    //////////////////////////////////////
    ///// OPERAÇÕES BÁSICAS EM LISTA /////
    //////////////////////////////////////

    @GetMapping("/somaLista")
    public double somaLista(@RequestParam("valor") List<Double> valor) {
        return operacoes.somaLista(valor);
    }

    @GetMapping("/subtraiLista")
    public double subtraiLista(@RequestParam("valor") List<Double> valor) {
        return operacoes.subtraiLista(valor);
    }

    @GetMapping("/multiplicaLista")
    public double multiplicaLista(@RequestParam List<Double> valor) {
        return operacoes.multiplicaLista(valor);
    }

    @GetMapping("/divideLista")
    public double divideLista(@RequestParam List<Double> valor) {
        return operacoes.divideLista(valor);
    }
}
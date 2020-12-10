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

    @Autowired
    private Operacoes operacoes;

    ///////// OPERAÇÕES BÁSICAS  /////////

    @GetMapping("/somar/{valor1}/{valor2}")
    public ResponseEntity soma(@PathVariable("valor1") Float valor1, @PathVariable("valor2") Float valor2) {
        return new ResponseEntity(operacoes.soma(valor1,valor2), HttpStatus.OK);
    }


    @GetMapping("/subtrair/{valor1}/{valor2}")
    public ResponseEntity subtrai(@PathVariable("valor1") Float valor1, @PathVariable("valor2") Float valor2) {
        return new ResponseEntity(operacoes.subtrai(valor1, valor2), HttpStatus.OK);
    }

    @GetMapping("/multiplicar/{valor1}/{valor2}")
    public ResponseEntity multiplica(@PathVariable("valor1") Float valor1, @PathVariable("valor2") Float valor2) {
        return new ResponseEntity(operacoes.multiplica(valor1, valor2), HttpStatus.OK);
    }

    @GetMapping("/dividir/{valor1}/{valor2}")
    public ResponseEntity divide(@PathVariable("valor1") Float valor1, @PathVariable("valor2") Float valor2) {
        return new ResponseEntity(operacoes.divide(valor1, valor2), HttpStatus.OK);
    }

    ///// OPERAÇÕES BÁSICAS EM LISTA /////

    @GetMapping("/somarLista")
    public ResponseEntity somaLista(@RequestParam("valores") List<Float> valores) {
        return new ResponseEntity(operacoes.somaLista(valores), HttpStatus.OK);
    }

    @GetMapping("/subtrairLista")
    public ResponseEntity subtraiLista(@RequestParam("valores") List<Float> valores) {
        return new ResponseEntity(operacoes.subtraiLista(valores), HttpStatus.OK);
    }

    @GetMapping("/multiplicarLista")
    public ResponseEntity multiplicaLista(@RequestParam("valores") List<Float> valores) {
        return new ResponseEntity(operacoes.multiplicaLista(valores), HttpStatus.OK);
    }

    @GetMapping("/dividirLista")
    public ResponseEntity divideLista(@RequestParam("valores") List<Float> valores) {
        return new ResponseEntity(operacoes.divideLista(valores), HttpStatus.OK);
    }
}
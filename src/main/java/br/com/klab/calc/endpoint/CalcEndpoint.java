package br.com.klab.calc.endpoint;

import br.com.klab.calc.model.Operacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calculadora/")
public class CalcEndpoint {

    @Autowired
    private Operacoes operacoes;

    ///////// OPERAÇÕES BÁSICAS  /////////

    @GetMapping("/{valor1}/{valor2}")
    public ResponseEntity soma(@RequestHeader Map<String, String> headers,
                               @PathVariable("valor1") Float valor1,
                               @PathVariable("valor2") Float valor2) {
        if (headers.containsKey("password") && headers.containsValue("calc-pass")) {
            return new ResponseEntity(operacoes.calcula(headers,valor1,valor2), HttpStatus.OK);
        } else {
            return new ResponseEntity("Please verify your password", HttpStatus.BAD_REQUEST);
        }
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
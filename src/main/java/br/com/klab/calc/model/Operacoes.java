package br.com.klab.calc.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Operacoes {

    public Map<String, String> headers;
    public String operacao;
    public Float valor1;
    public Float valor2;
    public List<Float> lista;
    public Float resultado;

    public void valores(String operacao, Float valor1, Float valor2) {
        this.operacao = operacao;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public void listaValores(String operacao, List<Float> lista) {
        this.operacao = operacao;
        this.lista = lista;
    }

    ///////// OPERAÇÕES BÁSICAS  /////////

    public Operacoes calcula(Map<String, String> headers, Float valor1, Float valor2) {
        this.headers = new HashMap<>();
        this.headers.put("password", headers.get("password"));
        this.headers.put("operacao", headers.get("operacao"));

        switch (headers.get("operacao")){

            case "somar":
                valores(headers.get("operacao"),valor1, valor2);
                this.resultado = valor1 + valor2;
                return this;

            case "subtrair":
                valores(headers.get("operacao"), valor1, valor2);
                this.resultado = valor1 - valor2;
                return this;

            case "multiplicar":
                valores(headers.get("operacao"), valor1, valor2);
                this.resultado = valor1 * valor2;
                return this;

            case "dividir":
                valores(headers.get("operacao"), valor1, valor2);
                this.resultado = valor1 / valor2;
                return this;
        }
        return null;
    }

    ///// OPERAÇÕES BÁSICAS EM LISTA /////

    public Operacoes somaLista(List<Float> valores) {
        listaValores("somarLista", valores);
        this.resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++) {
            this.resultado += valores.get(i);
        }
        return this;
    }

    public Operacoes subtraiLista(List<Float> valores) {
        listaValores("subtrairLista", valores);
        this.resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++) {
            this.resultado -= valores.get(i);
        }
        return this;
    }

    public Operacoes multiplicaLista(List<Float> valores) {
        listaValores("multiplicarLista", valores);
        this.resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++) {
            this.resultado *= valores.get(i);
        }
        return this;
    }

    public Operacoes divideLista(List<Float> valores) {
        listaValores("dividirLista", valores);
        this.resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++) {
            this.resultado /= valores.get(i);
        }
        return this;
    }
}
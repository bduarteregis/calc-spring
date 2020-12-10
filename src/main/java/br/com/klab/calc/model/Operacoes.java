package br.com.klab.calc.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Operacoes {

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

    public void valoresLista(String operacao, List<Float> lista) {
        this.operacao = operacao;
        this.lista = lista;
    }

    ///////// OPERAÇÕES BÁSICAS  /////////

    public Operacoes soma(Float valor1, Float valor2) {
        valores("somar", valor1, valor2);
        this.resultado = valor1 + valor2;
        return this;
    }

    public Operacoes subtrai(Float valor1, Float valor2) {
        valores("subtrair", valor1, valor2);
        this.resultado = valor1 - valor2;
        return this;
    }

    public Operacoes multiplica(Float valor1, Float valor2) {
        valores("multiplicar", valor1, valor2);
        this.resultado = valor1 * valor2;
        return this;
    }

    public Operacoes divide(Float valor1, Float valor2) {
        valores("dividir", valor1, valor2);
        this.resultado = valor1 / valor2;
        return this;
    }

    ///// OPERAÇÕES BÁSICAS EM LISTA /////

    public Operacoes somaLista(List<Float> valores) {
        valoresLista("somarLista", valores);
        this.resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++) {
            this.resultado += valores.get(i);
        }
        return this;
    }

    public Operacoes subtraiLista(List<Float> valores) {
        valoresLista("subtrairLista", valores);
        this.resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++) {
            this.resultado -= valores.get(i);
        }
        return this;
    }

    public Operacoes multiplicaLista(List<Float> valores) {
        valoresLista("multiplicarLista", valores);
        this.resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++) {
            this.resultado *= valores.get(i);
        }
        return this;
    }

    public Operacoes divideLista(List<Float> valores) {
        valoresLista("dividirLista", valores);
        this.resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++) {
            this.resultado /= valores.get(i);
        }
        return this;
    }
}
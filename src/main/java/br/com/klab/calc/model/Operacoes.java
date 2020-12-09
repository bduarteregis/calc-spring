package br.com.klab.calc.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class Operacoes {

    //////////////////////////////////////
    ///////// OPERAÇÕES BÁSICAS  /////////
    //////////////////////////////////////

    public int soma(int valor1, int valor2) {
        return valor1 + valor2;
    }

    public int subtrai(int valor1, int valor2) {
        return valor1 - valor2;
    }

    public int multiplica(int valor1, int valor2) {
        return valor1 * valor2;
    }

    public double divide(double valor1, double valor2) {
//        if(valor2 == 0) {
//            throw new IllegalArgumentException("Impossível dividir por 0.");
//        }
        return valor1 / valor2;
    }

    //////////////////////////////////////
    ///// OPERAÇÕES BÁSICAS EM LISTA /////
    //////////////////////////////////////

    public double somaLista(List<Double> valor) {
        double n = 0;
        for(int i = 0; i < valor.size(); i++) {
            n += valor.get(i);
        }
        return n;
    }

    public double subtraiLista(List<Double> valor) {
        double n = valor.get(0);
        for(int i = 1; i < valor.size(); i++) {
                n -= valor.get(i);
        }
        return n;
    }

    public double multiplicaLista(List<Double> valor) {
        double n = 1;
        for(int i = 0; i < valor.size(); i++) {
            n *= valor.get(i);
        }
        return n;
    }

    public double divideLista(List<Double> valor) {
        double n = valor.get(0);
        for(int i = 1; i < valor.size(); i++) {
            n = divide(n,valor.get(i));
        }
        return n;
    }
}
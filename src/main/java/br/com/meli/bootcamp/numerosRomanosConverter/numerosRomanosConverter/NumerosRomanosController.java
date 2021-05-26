package br.com.meli.bootcamp.numerosRomanosConverter.numerosRomanosConverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NumerosRomanosController {

    @GetMapping("/{numeroDecimal}")
    public String conversor(@PathVariable Integer numeroDecimal) {

        StringBuilder numeroRomano = new StringBuilder();

        Integer[] numeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerosString = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int numero = numeroDecimal;

        int i = 0;
        while (numero > 0) {
            if (numero >= numeros[i]) {
                numeroRomano.append(numerosString[i]);
                numero -= numeros[i];
            } else {
                i++;
            }
        }

        return numeroRomano.toString();
    }
}

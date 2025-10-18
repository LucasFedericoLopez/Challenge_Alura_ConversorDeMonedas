package com.alura.calculos;

import com.alura.monedas.TipoMoneda;
import com.alura.requests.ConsultaMoneda;

public class Convertir {
    public void convertirMoneda(ConsultaMoneda tipoMoneda, String desde, String hacia, Double cantidad) {
        try {
            TipoMoneda moneda = tipoMoneda.buscarMoneda(desde);
            double tasa = moneda.conversion_rates().get(hacia);
            double resultado = cantidad * tasa;
            System.out.printf("El valor de %.2f %s es %.2f %s%n", cantidad, desde,resultado, hacia);
        } catch (RuntimeException e) {
            System.out.println("No se pudo obtener la tasa de la moneda deseada");
            System.out.println(e.getMessage());
        }

    }
}

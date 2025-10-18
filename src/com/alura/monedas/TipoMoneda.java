package com.alura.monedas;

import java.util.Map;

public record TipoMoneda(String result,String base_code, Map<String, Double> conversion_rates) {
}

package com.alura.requests;

import com.alura.monedas.TipoMoneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public TipoMoneda buscarMoneda(String moneda) {
        try {
            var busqueda = URI.create("https://v6.exchangerate-api.com/v6/775647fdfd17b712e7ccc1b5/latest/"+moneda);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(busqueda)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            TipoMoneda tipoMoneda = new Gson().fromJson(response.body(), TipoMoneda.class);
            if (!tipoMoneda.result().equalsIgnoreCase("success")) {
                throw new RuntimeException("Error en la respuesta de la API");
            }
            return tipoMoneda;
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa moneda");
        }
    }
}

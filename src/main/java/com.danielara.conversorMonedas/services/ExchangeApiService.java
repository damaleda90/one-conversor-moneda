package com.danielara.conversorMonedas.services;

import com.danielara.conversorMonedas.config.AppConfig;
import com.danielara.conversorMonedas.models.ConversoConsultaResponse;
import com.danielara.conversorMonedas.models.ExchanGerateResponse;
import com.danielara.conversorMonedas.utils.ConvertJson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeApiService {
    private String url_base;
    private String monedaBase;
    private String monedaDestino;
    private String apiKey;
    private Double cantidadMonedas;

    public String getMonedaBase() {
        return monedaBase;
    }
    public String getMonedaDestino() {
        return monedaDestino;
    }

    public Double getCantidadMonedas() {
        return cantidadMonedas;
    }
    public void setCantidadMonedas(Double cantidad) {
        this.cantidadMonedas = cantidad;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public  ExchanGerateResponse consultarCambio() {
        url_base = AppConfig.getProperty("URL_EXCHANGE_API");
        apiKey = AppConfig.getProperty("TOKEN_EXCHANGE");
        ExchanGerateResponse  conversionJson = null;

        try{
            HttpClient client = HttpClient.newHttpClient();
            String urlConsult = url_base + apiKey+"/pair/"+monedaBase+"/"+monedaDestino+"/"+cantidadMonedas;

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlConsult)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            conversionJson  = ConvertJson.convertJson(response.body());

        }catch (IOException | InterruptedException e){
            System.out.println("Error al consultar la API de cambio de moneda: " + e.getMessage());
        }

        return conversionJson;
    }

}
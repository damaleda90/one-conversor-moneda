package com.danielara.conversorMonedas;

import com.danielara.conversorMonedas.models.ConversorMonedasRequest;
import com.danielara.conversorMonedas.models.ExchanGerateResponse;
import com.danielara.conversorMonedas.services.ExchangeApiService;
import com.danielara.conversorMonedas.utils.ConvertJson;
import com.danielara.conversorMonedas.utils.MenuFunctions;

import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
        MenuFunctions.showMenu();
        System.out.println("Selecciona el tipo de moneda que tienes: ");
        Scanner sc = new Scanner(System.in);

        ConversorMonedasRequest selected = new ConversorMonedasRequest();
        int monedaBase = sc.nextInt();

        selected.setMonedaBase(MenuFunctions.monedaSelect(monedaBase));
        System.out.println("Selecciona la moneda que deseas obtener:");

        int monedaDestino = sc.nextInt();
        selected.setMonedaDestino(MenuFunctions.monedaSelect(monedaDestino));

        System.out.println("Ingrese la cantidad que desea convertir:");
        double cantidad = sc.nextDouble();
        selected.setCantidad(cantidad);

        ExchangeApiService exchangeApiService = new ExchangeApiService();
        exchangeApiService.setMonedaBase(selected.getMonedaBase());
        exchangeApiService.setMonedaDestino(selected.getMonedaDestino());
        exchangeApiService.setCantidadMonedas(selected.getCantidad());

        ExchanGerateResponse responseJson = exchangeApiService.consultarCambio();
        if(responseJson != null){
            System.out.println("*********************");
            System.out.println("Tu cambio fue generado correctamente");
            System.out.println("Moneda que desea cambiar de: " + selected.getCantidad() + " " + selected.getMonedaBase() + " a " + selected.getMonedaDestino());
            System.out.println("Usted adquirio:  "+ responseJson.conversion_result() +" "+ exchangeApiService.getMonedaDestino() );
            System.out.println("Tasa de Cambio: " + " 1 " + selected.getMonedaBase() + " Equivale a: " + responseJson.conversion_rate()+ " " +exchangeApiService.getMonedaDestino());
        }else{
            System.out.println("No se pudo obtener la información de la API. Por favor, inténtelo de nuevo más tarde.");
            System.exit(0);
        }

        System.out.println("¿Desea realizar otra conversión? (Si/No)");
        String respuesta = sc.next();

        if(respuesta.equalsIgnoreCase("si")){
            main(args);
        } else {
            MenuFunctions.closeMenu();
        }
    }
}

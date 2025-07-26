package com.danielara.conversorMonedas.utils;

public class MenuFunctions {

    public static void showMenu() {
        System.out.println("***********************************************");
        System.out.println("Casa de Cambio - Conversor de Monedas");
        System.out.println("***********************************************");
        System.out.println("""
                        1) USD - Dólar estadounidense
                        2) EUR - Euro
                        3) GBP - Libra esterlina
                        4) JPY - Yen japonés
                        5) CHF - Franco suizo
                        6) CAD - Dólar canadiense
                        7) AUD - Dólar australiano
                        8) NZD - Dólar neozelandés
                        9) CNY - Yuan chino
                        10) MXN - Peso mexicano
                        11) BRL - Real brasileño
                        12) ARS - Peso argentino
                        13) Salir del programa
                """);
    }

    public static String monedaSelect(int numero){
        int numeroMoneda = numero;
        String option = null;
        switch (numeroMoneda){
            case 1:
                option = "USD";
                break;
            case 2:
                option = "EUR";
                break;
            case 3:
                option = "GBP";
                break;
            case 4:
                option = "JPY";
                break;
            case 5:
                option = "CHF";
                break;
            case 6:
                option = "CAD";
                break;
            case 7:
                option = "AUD";
                break;
            case 8:
                option = "NZD";
                break;
            case 9:
                option = "CNY";
                break;
            case 10:
                option = "MXN";
                break;
            case 11:
                option = "BRL";
                break;
            case 12:
                option = "ARS";
                break;
            case 13:
                System.out.println("Saliendo del programa...");
                closeMenu();
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida, ingrese un numero entre 1 y 13.");
                option = null;
        }
        return option;
    }

    public static void closeMenu() {
        System.out.println("***********************************************");
        System.out.println("Gracias por usar nuestro servicio.");
        System.out.println("***********************************************");
        System.exit(0);
    }
}

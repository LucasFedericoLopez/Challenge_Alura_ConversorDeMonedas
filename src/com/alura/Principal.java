package com.alura;

import com.alura.calculos.Convertir;
import com.alura.requests.ConsultaMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Convertir convertir = new Convertir();
        while (true) {
            System.out.println("Bienvenidos al Conversor de Moneda!");
            System.out.println("Por favor, elija una opcion para continuar: ");

            System.out.println("1) Dólar(USD) --> Peso Argentino(ARS)");
            System.out.println("2) Peso Argentino(ARS) --> Dólar(USD)");
            System.out.println("3) Dólar(USD) --> Real Brasileño(BRL)");
            System.out.println("4) Real Brasileño(BRL) --> Dólar(USD)");
            System.out.println("5) Dólar(USD) --> Peso Chileno(CLP)");
            System.out.println("6) Peso Chileno(CLP) --> Dólar(USD)");
            System.out.println("7) Salir");

            var opcion = lectura.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por utilizar el conversor!");
                break;
            }

            System.out.println("Ingrese la cantidad a convertir: ");
            var cantidad = lectura.nextDouble();
            switch (opcion) {
                case 1 -> convertir.convertirMoneda(consultaMoneda,"USD","ARS",cantidad);
                case 2 -> convertir.convertirMoneda(consultaMoneda,"ARS","USD",cantidad);
                case 3 -> convertir.convertirMoneda(consultaMoneda,"USD","BRL",cantidad);
                case 4 -> convertir.convertirMoneda(consultaMoneda,"BRL","USD",cantidad);
                case 5 -> convertir.convertirMoneda(consultaMoneda,"USD","CLP",cantidad);
                case 6 -> convertir.convertirMoneda(consultaMoneda,"CLP","USD",cantidad);
                default -> {
                    System.out.println("Operacion no válida");
                }
            }
            System.out.println("---------------------------------------");
        }
    }
}

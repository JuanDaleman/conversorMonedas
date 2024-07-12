package services;

import java.util.Scanner;

public class DisplayMenu {

    private final String[] monedas = {"ARS", "BOB", "BRL", "COP", "USD"};
    private Scanner scanner = new Scanner(System.in);

    public String[] getMonedas() {
        return monedas;
    }

    public String welcomeMessage(){
        return "Bienvenido Usuario. Puede seleccionar entre las siguientes monedas para convertir un monto específico.";
    }


    public int mostrarMenuMonedas(String prompt) {
        System.out.println(prompt);
        for (int i = 0; i < monedas.length; i++) {
            System.out.println((i + 1) + ". " + monedas[i]);
        }
        System.out.println((6) + ". Salir");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        return opcion - 1; // Ajustar para índice del array
    }

    public double obtenerMonto() {
        System.out.println("Ingresa el monto a convertir:");
        return scanner.nextDouble();
    }
}

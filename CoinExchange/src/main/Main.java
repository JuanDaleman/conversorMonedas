package main;

import com.google.gson.Gson;
import modelos.APIAnswer;
import modelos.APIAnswerOmdb;
import services.APICliente;
import services.DisplayMenu;
import java.io.IOException;

public class Main {

    private static final String API_URL_BASE = "https://v6.exchangerate-api.com/v6/144dd9fba8052f98a9cc0954/pair/";

    public static void main(String[] args)  {

        boolean flag = true;
        DisplayMenu displayMenu = new DisplayMenu();
        System.out.println(displayMenu.welcomeMessage());
        String[] monedas = displayMenu.getMonedas();



        while (flag){
            // Selección de moneda base
            int baseIndex = displayMenu.mostrarMenuMonedas("Selecciona la moneda base:");
            if (baseIndex == 5) {
                System.out.println("Saliendo de la aplicación.");
                break;
            }
            if (baseIndex < 0 || baseIndex >= monedas.length) {
                System.out.println("Opción inválida");
                return;
            }

            String baseCurrency = monedas[baseIndex];

            // Selección de moneda destino
            int targetIndex = displayMenu.mostrarMenuMonedas("Selecciona la moneda destino:");
            if (targetIndex == 5) {
                System.out.println("Saliendo de la aplicación.");
                break;
            }
            if (targetIndex < 0 || targetIndex >= monedas.length) {
                System.out.println("Opción inválida");
                return;
            }
            String targetCurrency = monedas[targetIndex];

            // Validar que la moneda destino no sea la misma que la moneda base
            if (baseCurrency.equals(targetCurrency)) {
                System.out.println("La moneda destino no puede ser la misma que la moneda base");
                return;
            }

            // Obtener el monto a convertir
            double amount = displayMenu.obtenerMonto();

            // Construir la URL para la solicitud
            String apiUrl = API_URL_BASE + baseCurrency + "/" + targetCurrency + "/" + amount;

            APICliente apiCliente = new APICliente();
            Gson gson = new Gson();

            try {
                String json = apiCliente.makeRequest(apiUrl);
                APIAnswerOmdb apiAnswerOmdb = gson.fromJson(json, APIAnswerOmdb.class);
                APIAnswer apiAnswer = new APIAnswer(apiAnswerOmdb);
                System.out.println(apiAnswer);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
package view;

import controller.ControlRegalo;
import model.Regalo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ControlRegalo controlRegalo = new ControlRegalo();
        ArrayList<Regalo> regalos = controlRegalo.leerArchivos();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equals("q")) {
            System.out.println("Ingrese la edad:");
            int edad = scanner.nextInt();
            System.out.println("Ingrese el precio máximo:");
            double precioMaximo = scanner.nextDouble();
            ArrayList<Regalo> regalosFiltrados = controlRegalo.filtrarRegalos(edad, precioMaximo, regalos);
            System.out.println(controlRegalo.mostrarRegalos(regalosFiltrados));
            System.out.println("Presione 'q' para salir o cualquier otra tecla para continuar");
            input = scanner.next();
        }

    }
}

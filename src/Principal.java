import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        // Configuración de la Lista (Base de Datos en memoria)
        List<ParMoneda> opciones = new ArrayList<>();
        opciones.add(new ParMoneda("Dólar (USD) => Peso Colombiano (COP)", "USD", "COP"));
        opciones.add(new ParMoneda("Peso Colombiano (COP) => Dólar (USD)", "COP", "USD"));
        opciones.add(new ParMoneda("Euro (EUR) => Peso Colombiano (COP)", "EUR", "COP"));
        opciones.add(new ParMoneda("Peso Colombiano (COP) => Euro (EUR)", "COP", "EUR"));
        opciones.add(new ParMoneda("Dólar (USD) => Real Brasileño (BRL)", "USD", "BRL"));
        opciones.add(new ParMoneda("Real Brasileño (BRL) => Dólar, (USD)", "BRL", "USD"));
        opciones.add(new ParMoneda("Dólar (USD) => Peso Argentino (ARS)", "USD", "ARS"));
        opciones.add(new ParMoneda("Peso Argentino (ARS) => Dólar (USD)", "ARS", "USD"));
        opciones.add(new ParMoneda("Dólar (USD) => Euro (EUR)", "USD", "EUR"));
        opciones.add(new ParMoneda("Euro (EUR) => Dólar (USD)", "EUR", "USD"));


        while (true) {
            System.out.println("*************************************************");
            System.out.println("      CONVERSOR DE MONEDA (Versión Dinámica) 🪙");
            System.out.println("*************************************************");


            for (int i = 0; i < opciones.size(); i++) {

                System.out.println((i + 1) + ") " + opciones.get(i).descripcion());
            }
            System.out.println((opciones.size() + 1) + ") Entrada personalizada");
            System.out.println((opciones.size() + 2) + ") Salir");
            System.out.println("*************************************************");
            System.out.print("Elija una opción: ");

            try {
                int eleccion = Integer.parseInt(lectura.nextLine());


                if (eleccion == opciones.size() + 2) {
                    System.out.println("Cerrando programa...");
                    break;
                }

                String base = "";
                String target = "";


                if (eleccion >= 1 && eleccion <= opciones.size()) {

                    ParMoneda seleccionada = opciones.get(eleccion - 1);
                    base = seleccionada.base();
                    target = seleccionada.target();

                } else if (eleccion == opciones.size() + 1) {
                    // Opción Personalizada
                    System.out.println("Ingrese código base:");
                    base = lectura.nextLine().toUpperCase();
                    System.out.println("Ingrese código destino:");
                    target = lectura.nextLine().toUpperCase();
                } else {
                    System.out.println("Opción inválida");
                    continue;
                }


                System.out.println("Ingrese cantidad:");
                double cantidad = Double.parseDouble(lectura.nextLine());
                Moneda moneda = consulta.buscarMoneda(base, target);
                double resultado = moneda.calcularResultado(cantidad);

                System.out.printf("RESULTADO: %.2f %s = %.2f %s%n%n", cantidad, base, resultado, target);

                System.out.println("Presione Enter para continuar...");
                lectura.nextLine();

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
/*



package controller;

import service.VentaService;

import java.util.Scanner;

public class VentaController {

    private final VentaService ventaService = new VentaService();
    Scanner read = new Scanner(System.in);

    public void iniciar() {
        int opc;
        do{
            System.out.println("--MENU DE VENTA--");
            System.out.print("1) Registrar venta");
            System.out.print("0) Salir\n");

            opc = read.nextInt();

            switch (read) {
                case 1:
                    registrarVenta();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }

        }while(opc != 0);
    }

    private  void registrarVenta() {
        
    }
    
}

*/
package UT5.StreamingTV;

import java.util.Scanner;

public class AppStreaming {

    private static GestorSuscripciones gestor = new GestorSuscripciones(10);
    private static Suscripcion sesionActual = null;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        String usuario;
        Suscripcion s = null;

        do {
            System.out.println("\n--- STREAMING TV ---");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Suscribirse");
            System.out.println("3. Pasar el tiempo (nuevo mes)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Introduce usuario: ");
                    usuario = sc.nextLine();

                    s = gestor.buscarPorUsuario(usuario);

                    if (s != null) {
                        sesionActual = s;
                        menuUsuario(sc);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("Introduce usuario: ");
                    usuario = sc.nextLine();
                    System.out.print("Duración en meses: ");
                    int duracion = sc.nextInt();
                    System.out.println("Elige el tipo de suscripción");
                    System.out.println("1. BÁSICA");
                    System.out.println("2. ESTÁNDAR");
                    System.out.println("3. PREMIUM");
                    int tipoSuscripcion;
                    
                    do {
                        tipoSuscripcion = sc.nextInt();
                        switch (tipoSuscripcion) {
                            case 1:
                                s = SuscripcionFactory.getSuscripcion("basica", usuario, duracion);
                                break;
                            case 2:
                                s = SuscripcionFactory.getSuscripcion("estandar", usuario, duracion);
                                break;
                            case 3:
                                s = SuscripcionFactory.getSuscripcion("premium", usuario, duracion);
                                break;
                            default:
                                break;
                        }
                    } while (tipoSuscripcion<=0 || tipoSuscripcion>3);
                    gestor.agregarSuscripcion(s);
                    sesionActual = s;
                    System.out.println("Suscripción activada.");
                    menuUsuario(sc);
                    opcion=0;
                    break;
                case 3:
                    gestor.pasarMes();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void menuUsuario(Scanner sc) {
        int opcion;

        do {
            System.out.println("\n--- MENÚ USUARIO ---");
            System.out.println("1. Desuscribirse");
            System.out.println("2. Pausar");
            System.out.println("3. Cancelar pausa");
            System.out.println("4. Ver historial");
            System.out.println("5. Agregar dispositivo");
            System.out.println("6. Eliminar dispositivo");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (gestor.eliminarSuscripcion(sesionActual)){
                        System.out.println("Suscripción cancelada.");
                    } else {
                        System.out.println("No se ha podido cancelar la suscripción.");
                    }
                    break;

                case 2:
                    if (sesionActual.pausar()) {
                        System.out.println("Suscripción en pausa.");
                    } else {
                        System.out.println("No se puede pausar.");
                    }
                    break;

                case 3:
                    sesionActual.cancelarPausa();
                    System.out.println("Pausa cancelada.");
                    break;

                case 4:
                    System.out.println(sesionActual.verHistorial());
                    break;

                case 5:
                    sesionActual.agregarDispositivo();
                    break;

                case 6:
                    sesionActual.eliminarDispositivo();
                    break;

                case 0:
                    sesionActual = null;
                    System.out.println("Sesión cerrada.");
                    break;
            }

        } while (opcion != 0);
    }
}

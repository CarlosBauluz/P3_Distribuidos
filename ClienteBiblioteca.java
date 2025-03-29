import Biblioteca.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

import java.util.Scanner;

import org.omg.CORBA.*;

public class ClienteBiblioteca {
    public static void main(String args[]) {
        try {
            // Inicializar el ORB (Object Request Broker)
            ORB orb = ORB.init(args, null);

            // Obtener referencia al servicio de nombres
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Buscar la referencia del objeto (servidor) en el servicio de nombres
            String name = "GestionBiblioteca";
            GestionBiblioteca gestionBiblioteca = GestionBibliotecaHelper.narrow(ncRef.resolve_str(name));

            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("\n--- Menú Biblioteca ---");
                System.out.println("1. Listar libros");
                System.out.println("2. Buscar libro por título");
                System.out.println("3. Prestar libro");
                System.out.println("4. Devolver libro");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                switch (opcion) {
                    case 1:
                        ListaLibrosHolder librosAlmacen = new ListaLibrosHolder();
                        gestionBiblioteca.buscarLibros(librosAlmacen);
                        System.out.println("Lista de libros:");
                        for (Libro libro : librosAlmacen.value) {
                            System.out.println(" - " + libro.titulo + " por " + libro.autor + ", ISBN: " + libro.ISBN);
                        }
                        break;
                    case 2:
                        System.out.print("Ingrese el título del libro: ");
                        String titulo = scanner.nextLine();
                        Libro libro = gestionBiblioteca.buscarLibro(titulo);
                        if (libro != null) {
                            System.out.println("Libro encontrado: " + libro.titulo + " por " + libro.autor + ", ISBN: " + libro.ISBN);
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el ISBN del libro a prestar: ");
                        String isbnPrestar = scanner.nextLine();
                        boolean prestado = gestionBiblioteca.prestarLibro(isbnPrestar);
                        if (prestado) {
                            System.out.println("Libro prestado con éxito.");
                        } else {
                            System.out.println("No se pudo prestar el libro. Puede que no esté disponible.");
                        }
                        break;
                    case 4:
                        System.out.print("Ingrese el ISBN del libro a devolver: ");
                        String isbnDevolver = scanner.nextLine();
                        boolean devuelto = gestionBiblioteca.devolverLibro(isbnDevolver);
                        if (devuelto) {
                            System.out.println("Libro devuelto con éxito.");
                        } else {
                            System.out.println("No se pudo devolver el libro. Verifique el ISBN.");
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 5);

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}


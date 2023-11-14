import java.util.Scanner;
import java.util.ArrayList;

// Clase Película
class Pelicula {
    private int numeroID;
    private String titulo;
    private String director;
    private String genero;

    public Pelicula(int numeroID, String titulo, String director, String genero) {
        this.numeroID = numeroID;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
    }

    public int getNumeroID() {
        return numeroID;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getGenero() {
        return genero;
    }
}

// Sistema de Gestión
class SistemaGestion {
    private ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

    // Constructor que agrega automáticamente la primera película con el ID 811140
    public SistemaGestion() {
        // Agregar automáticamente la primera película con el ID 811140
        Pelicula peliculaInicial = new Pelicula(811140, "Inception", "Christopher Nolan", "Ciencia ficción");
        listaPeliculas.add(peliculaInicial);
    }

    public void agregarPelicula(Pelicula pelicula) {
        listaPeliculas.add(pelicula);
    }

    public void eliminarPelicula(int numeroID) {
        listaPeliculas.removeIf(pelicula -> pelicula.getNumeroID() == numeroID);
    }

    public Pelicula buscarPorNumeroID(int numeroID) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getNumeroID() == numeroID) {
                return pelicula;
            }
        }
        return null;
    }

    public Pelicula buscarPorTitulo(String titulo) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null;
    }

    public void listarPeliculas() {
        if (listaPeliculas.isEmpty()) {
            System.out.println("La lista de películas está vacía.");
        } else {
            System.out.println("Películas en el sistema:");
            for (Pelicula pelicula : listaPeliculas) {
                System.out.println("ID: " + pelicula.getNumeroID() +
                        ", Título: " + pelicula.getTitulo() +
                        ", Director: " + pelicula.getDirector() +
                        ", Género: " + pelicula.getGenero());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\nMenú de Navegación:");
            System.out.println("1. Agregar nueva película");
            System.out.println("2. Eliminar película");
            System.out.println("3. Buscar por número de ID");
            System.out.println("4. Buscar por título");
            System.out.println("5. Listar todas las películas");
            System.out.println("0. Salir");

            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt

            switch (opcion) {
                case 1:
                    agregarPelicula(sistema, scanner);
                    break;
                case 2:
                    eliminarPelicula(sistema, scanner);
                    break;
                case 3:
                    buscarPorNumeroID(sistema, scanner);
                    break;
                case 4:
                    buscarPorTitulo(sistema, scanner);
                    break;
                case 5:
                    sistema.listarPeliculas();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void agregarPelicula(SistemaGestion sistema, Scanner scanner) {
        System.out.println("Ingrese los detalles de la nueva película:");
        System.out.print("Número de ID: ");
        int numeroID = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de nextInt

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Director: ");
        String director = scanner.nextLine();

        System.out.print("Género: ");
        String genero = scanner.nextLine();

        Pelicula nuevaPelicula = new Pelicula(numeroID, titulo, director, genero);
        sistema.agregarPelicula(nuevaPelicula);

        System.out.println("Película agregada con éxito.");
    }

    private static void eliminarPelicula(SistemaGestion sistema, Scanner scanner) {
        System.out.print("Ingrese el número de ID de la película a eliminar: ");
        int numeroID = scanner.nextInt();
        sistema.eliminarPelicula(numeroID);
        System.out.println("Película eliminada con éxito.");
    }

    private static void buscarPorNumeroID(SistemaGestion sistema, Scanner scanner) {
        System.out.print("Ingrese el número de ID de la película a buscar: ");
        int numeroID = scanner.nextInt();
        Pelicula peliculaEncontrada = sistema.buscarPorNumeroID(numeroID);

        if (peliculaEncontrada != null) {
            System.out.println("Película encontrada:");
            mostrarDetallesPelicula(peliculaEncontrada);
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    private static void buscarPorTitulo(SistemaGestion sistema, Scanner scanner) {
        System.out.print("Ingrese el título de la película a buscar: ");
        String titulo = scanner.nextLine();
        Pelicula peliculaEncontrada = sistema.buscarPorTitulo(titulo);

        if (peliculaEncontrada != null) {
            System.out.println("Película encontrada:");
            mostrarDetallesPelicula(peliculaEncontrada);
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    private static void mostrarDetallesPelicula(Pelicula pelicula) {
        System.out.println("ID: " + pelicula.getNumeroID() +
                ", Título: " + pelicula.getTitulo() +
                ", Director: " + pelicula.getDirector() +
                ", Género: " + pelicula.getGenero());
    }
}

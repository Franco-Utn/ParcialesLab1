package examen;
import java.util.Arrays;

// Llamar a la función para obtener la matriz de ADN completa
//
//        MATRIZ PARA MUTANTE:
//         "A,C,T,A,G,G"
//         "C,A,T,G,A,T"
//         "T,G,A,C,C,C"
//         "C,A,A,A,A,G"
//         "A,C,T,A,G,G"
//         "G,T,A,C,C,C"
//
//        MATRIZ PARA "no" MUTANTE:
//         "A,C,T,A,G,G"
//         "C,T,G,G,A,T"
//         "T,G,A,C,C,C"
//         "C,T,A,A,A,G"
//         "A,C,T,A,G,G"
//         "G,T,A,C,C,C"


public class Global {

    public static void main(String[] args) {

        // Llamar a la función para obtener la matriz de ADN completa
        char[][] matrixDna = Funciones.fillMatrix();

        // Imprimir la matriz de dna completa
        System.out.println("Matriz de ADN completada:");
        for (char[] row : matrixDna) {
            System.out.println(Arrays.toString(row));
        }

        // Llamar a la función isMutant para verificar si es un mutante
        boolean result = Funciones.isMutant(matrixDna);

        // Imprimir el resultado
        if (result) {
            System.out.println("Es un mutante.");
        } else {
            System.out.println("No es un mutante.");
        }

    }

}
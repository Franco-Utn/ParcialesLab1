package examen;
import java.util.Arrays;
import java.util.Scanner;

public class Funciones {

    public static char[][] fillMatrix() {
        // Crear una matriz de 6x6 inicializada con null
        char[][] dna = new char[6][6];

        System.out.println("Por favor, complete la matriz de ADN con letras A, T, C o G.");
        System.out.println("Ingrese una secuencia de caracteres separados por comas (,).");

        Scanner scanner = new Scanner(System.in);
        for (int r = 0; r < 6; r++) {
            System.out.print("Ingrese la fila " + (r+1) + " (separada por comas): ");
            String[] rowInput = scanner.nextLine().split(",");
            if (rowInput.length != 6) {
                System.out.println("Debe ingresar exactamente 6 caracteres separados por comas. Intente de nuevo.");
                return fillMatrix();
            }

            for (int c = 0; c < 6; c++) {
                char character = rowInput[c].trim().toUpperCase().charAt(0);
                if (character == 'A' || character == 'T' || character == 'C' || character == 'G') {
                    dna[r][c] = character;
                } else {
                    System.out.println("Caracter no válido en la posición (" + (r+1) + ", " + (c+1) + "). Solo se permiten A, T, C o G. Intente de nuevo.");
                    return fillMatrix();
                }
            }
        }

        return dna;
    }

    public static int countRowsWithConsecutiveEquals(char[][] matrix) {
        int countRows = 0;

        for (char[] row : matrix) {
            int consecutiveCount = 1;
            for (int i = 1; i < row.length; i++) {
                if (row[i] == row[i - 1]) {
                    consecutiveCount++;
                    if (consecutiveCount == 4) {
                        countRows++;
                        break;
                    }
                } else {
                    consecutiveCount = 1;
                }
            }
        }

        return countRows;
    }

    public static int countColumnsWithConsecutiveEquals(char[][] matrix) {
        int countColumns = 0;

        for (int colIdx = 0; colIdx < matrix[0].length; colIdx++) {
            int consecutiveCount = 1;
            for (int rowIdx = 1; rowIdx < matrix.length; rowIdx++) {
                if (matrix[rowIdx][colIdx] == matrix[rowIdx - 1][colIdx]) {
                    consecutiveCount++;
                    if (consecutiveCount == 4) {
                        countColumns++;
                        break;
                    }
                } else {
                    consecutiveCount = 1;
                }
            }
        }

        return countColumns;
    }

    public static int countDiagonalsLeftToRight(char[][] matrix) {
        int countDiagonals = 0;

        for (int i = 0; i < matrix.length - 3; i++) {
            for (int j = 0; j < matrix[i].length - 3; j++) {
                if (matrix[i][j] == matrix[i+1][j+1] &&
                        matrix[i+1][j+1] == matrix[i+2][j+2] &&
                        matrix[i+2][j+2] == matrix[i+3][j+3]) {
                    countDiagonals++;
                }
            }
        }

        return Math.min(countDiagonals, 5);
    }

    public static int countDiagonalsRightToLeft(char[][] matrix) {
        int countDiagonals = 0;

        for (int i = 0; i < matrix.length - 3; i++) {
            for (int j = 3; j < matrix[i].length; j++) {
                if (matrix[i][j] == matrix[i+1][j-1] &&
                        matrix[i+1][j-1] == matrix[i+2][j-2] &&
                        matrix[i+2][j-2] == matrix[i+3][j-3]) {
                    countDiagonals++;
                }
            }
        }

        return Math.min(countDiagonals, 5);
    }

    public static boolean isMutant(char[][] dna) {
        int count = 0;

        // Contar filas con 4 elementos consecutivos iguales
        count += countRowsWithConsecutiveEquals(dna);

        // Contar columnas con 4 elementos consecutivos iguales
        count += countColumnsWithConsecutiveEquals(dna);

        // Contar diagonales de izquierda a derecha con 4 elementos consecutivos iguales
        count += countDiagonalsLeftToRight(dna);

        // Contar diagonales de derecha a izquierda con 4 elementos consecutivos iguales
        count += countDiagonalsRightToLeft(dna);

        // Si el contador es mayor o igual a 2, entonces es un mutante
        return count >= 2;
    }

}
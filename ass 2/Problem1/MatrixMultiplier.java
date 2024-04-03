import java.io.*;
import java.util.*;

public class MatrixMultiplier {

    private static int[][] MatrixMultiplication(int[][] a, int[][] b, int n) {
        int[][] resultMatrix = new int[n][n];
        Thread[] threads = new Thread[n * n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                final int finalRow = row;
                final int finalCol = col;

                threads[row * n + col] = new Thread(() -> {
                    for (int k = 0; k < n; k++) {
                        resultMatrix[finalRow][finalCol] += a[finalRow][k] * b[k][finalCol];
                    }
                });

                threads[row * n + col].start();
            }
        }

        for (Thread thread : threads) {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("java.lang.InterruptedException: Thread interrupted");
            }
        }

        return resultMatrix;
    }

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            Scanner input = new Scanner(file);
            int n = input.nextInt();

            int[][] a = new int[n][n];
            int[][] b = new int[n][n];
            int[][] c = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = input.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = input.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = input.nextInt();
                }
            }

            input.close();

            int[][] resultant = MatrixMultiplication(MatrixMultiplication(a, b, n), c, n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(resultant[i][j]);
                    if (!(i == n - 1 && j == n - 1))
                        System.out.print(" ");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("java.io.FileNotFoundException: Error opening the specified file");
        } catch (NumberFormatException e) {
            System.out.println("java.lang.NumberFormatException: Error in string to number conversion");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("java.lang.ArrayIndexOutOfBoundsException: Invalid array index");
        }
    }
}
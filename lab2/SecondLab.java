import java.util.Scanner;
import java.util.Random;

public class SecondLab {
    /*C5 = 2, C7 = 4, C11 =  3
     * C=A+B, long, Обчислити суму найбільших елементів кожного рядка матриці */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();
        System.out.print("Enter number of rows in matrix A: ");
        int mA = scn.nextInt(); // Введення кількості рядків для матриці А
        System.out.print("Enter the number of columns in matrix A: ");
        int nA = scn.nextInt(); // Введення кількості стовпців для матриці А
        System.out.print("Enter number of rows in matrix B: ");
        int mB = scn.nextInt(); // Введення кількості рядків для матриці В
        System.out.print("Enter the number of columns in matrix B: ");
        int nB = scn.nextInt(); // Введення кількості стовпців для матриці В
        long largest, sum = 0L; // Зміні максимум та суми
        if(mA != mB || nA != nB) {
            System.out.println("Unable to add matrices!"); // Перевірка розмірності двох матриць
        } else {
            long[][] matrixA = new long[mA][nA];
            long[][] matrixB = new long[mB][nB]; // Створення двовимірних масивів (матриць) заданої розмірності
            long[][] matrixC = new long[mA][nA];

            System.out.println("Matrix A: ");
            for(int i = 0; i < mA; i++) {
                for(int j = 0; j < nA; j++) {
                    matrixA[i][j] = rnd.nextLong(10, 50) + 10;
                    System.out.printf("|%d", matrixA[i][j]);          // Заповнення та друк матриці А
                }
                System.out.println("|");
            }
            System.out.println("Matrix B: ");
            for(int i = 0; i < nA; i++) {
                for(int j = 0; j < nB; j++) {
                    matrixB[i][j] = rnd.nextLong(10, 50) + 10;
                    System.out.printf("|%d", matrixB[i][j]);          // Заповнення та друк матриці В
                }
                System.out.println("|");
            }
            System.out.println("Matrix C: ");
            for(int i = 0; i < mA; i++) {
                for(int j = 0; j < nA; j++) {
                    matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                    System.out.printf("|%d", matrixC[i][j]);          // Заповнення та друк матриці С
                }
                System.out.println("|");
            }
            for(long[] row: matrixC) {
                largest = row[0];
                for(long elem : row) {
                    if(elem > largest) {
                        largest = elem;          // Визначення максимального елементу у кожному рядку
                    }
                }
                sum += largest;         // Обчислення суми
            }
            System.out.printf("Sum = %d", sum); // Друк суми
        }
        scn.close();
    }
    
}

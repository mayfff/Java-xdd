import java.util.Scanner;

public class FirstLab {
    /* C2 = 0, C3 = 0, C5 = 2, C7 = 4 
        O1 = +, O2 = %, index = char*/ 
 
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        final int C = 0; // Константа C
        double S = 0.0; // Зміна дійсного типу для визначення суми
        System.out.print("Enter a: "); 
        int a = scn.nextInt(); // Введення значення а з клавіатури
        System.out.print("Enter b: ");
        int b = scn.nextInt(); // Введення значення b з клавіатури
        System.out.print("Enter n: ");
        int n = scn.nextInt(); // Введення значення n з клавіатури
        System.out.print("Enter m: ");
        int m = scn.nextInt(); // Введення значення m з клавіатури
        if ((a <= 0 & n >= 0) | (b <= 0 & m >= 0)){
            System.out.println("Division by 0!"); // Перевірка ділення на 0
        } else {
            for (char i = (char) a; i <= n; i++) {
                for(char j = (char) b; j <= m; j++) {
                        S += (double) (i % j) / (i + C); // Підрахунок суми
                }
            }
            System.out.printf("Result - %.3f", S); // Друк суми
        }

        scn.close();
    }
}


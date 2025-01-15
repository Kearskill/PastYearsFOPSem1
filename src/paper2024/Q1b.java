package paper2024;
import java.util.Scanner;

public class Q1b {
    public static void main(String[] args) {
        // Write a program to calculate the sum of the following series
        // where n is input by the user

        // 1 + 1/2 + 1/3 + 1/4 + 1/5 +... 1/n
        Scanner sc = new Scanner(System.in);

        double res = 0;
        System.out.print("Input n: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            res += 1.0 / i;
        }
        System.out.printf("The answer is %.2f", res);
    }
}

package Lab7;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int n, total = 1;
        Scanner input = new Scanner(System.in);

        System.out.print("n? ");
        n = input.nextInt();

        for (int i = n; i >= 1; i--) {
            total *= i;
        }

        System.out.println(n + "! = " + total);
    }
}
package Lab07;

import java.util.Scanner;

public class Factorial2 {
    public static void main(String[] args) {
        int n, total = 1;
        Scanner input = new Scanner(System.in);

        System.out.print("n? ");
        n = input.nextInt();

        for (int i = n; i > 1; i--) {
            System.out.print(i + " x ");
            total *= i;
        }

        System.out.println("1 = " + total);
    }
}
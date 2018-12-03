package Lab10;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");

        int num1 = input.nextInt();
        int num2 = input.nextInt();

        System.out.println("GCD of " + num1 + " and " + num2 + " is " + gcd(num1, num2));
    }

    public static int gcd(int x, int y) {
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }
}
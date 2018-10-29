package Lab9;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("? ");
        int num = input.nextInt();

        if (isPrime(num))
            System.out.println(num + " is a prime number");
        else
            System.out.println(num + " is not a prime number");
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
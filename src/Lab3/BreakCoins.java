package Lab3;

import java.util.*;

public class BreakCoins {
    public static void main(String[] args) {
        int amount, coins;
        Scanner input = new Scanner(System.in);

        System.out.print("Input an amount: ");
        amount = input.nextInt();

        System.out.println("The minimum numbers of coins for " + amount + " dollars are:");
        coins = amount / 10;
        amount %= 10;
        System.out.println("10-dollar coin(s): " + coins);
        coins = amount / 5;
        amount %= 5;
        System.out.println("5-dollar coin(s): " + coins);
        coins = amount / 2;
        amount %= 2;
        System.out.println("2-dollar coin(s): " + coins);
        System.out.println("1-dollar coin(s): " + amount);
    }
}
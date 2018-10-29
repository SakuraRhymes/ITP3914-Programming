package Lab7;

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        int value, odd = 0, even = 0;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Value? ");
            value = input.nextInt();
            if (value % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.print("Number of odd values = " + odd + "\nNumber of even values = " + even);
    }
}
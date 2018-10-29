package Lab7;

import java.util.Scanner;

public class AvgValues {
    public static void main(String[] args) {
        int v, num;
        double total = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("How many value to enter? ");
        num = input.nextInt();

        for (int i = num; i > 0; i--) {
            System.out.print("Value? ");
            v = input.nextInt();
            total += v;
        }

        System.out.println("Average = " + (total / num));
    }
}
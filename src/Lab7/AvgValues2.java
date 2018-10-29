package Lab7;

import java.util.Scanner;

public class AvgValues2 {
    public static void main(String[] args) {
        int v, num = 0;
        double total = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Value? ");
            v = input.nextInt();
            if (v <= 0)
                break;
            else {
                total += v;
                num++;
            }
        }

        System.out.println("Average = " + (total / num));
    }
}
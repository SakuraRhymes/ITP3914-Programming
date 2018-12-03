package Lab08;

import java.util.*;

public class ArrayCalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;
        double n;
        double[] num = new double[10];
        double sum = 0, mean, max, min, sd = 0;

        //user input
        for (int i = 0; i < 10; i++) {
            System.out.print("Input your numbers(Max 10 numbers)");
            n = input.nextDouble();
            if (n >= 0) {
                num[i] = n;
                total++;
            } else
                break;
        }

        //Sum
        for (int i = 0; i < total; i++)
            sum += num[i];
        System.out.printf("\nThe Sum is %.2f", sum);

        //Mean
        mean = sum / total;
        System.out.printf("\nThe Mean is %.2f", mean);

        //Max
        max = num[0];
        for (int i = 1; i < total; i++)
            if (num[i] > max)
                max = num[i];
        System.out.println("\nThe Maximum is " + max);

        //Min
        min = num[0];
        for (int i = 1; i < total; i++)
            if (num[i] < min)
                min = num[i];
        System.out.println("The Minimum is " + min);

        //Standard Deviation
        for (int i = 0; i < total; i++)
            sd += Math.pow((num[i] - mean), 2);
        sd = Math.sqrt(sd / (total - 1));
        System.out.printf("The Stand Deviation is %.2f", sd);
    }
}
package Lab05;

import java.util.*;

public class RandomList {
    public static void main(String[] args) {
        int sum = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Number of random numbers: ");
        int num = input.nextInt();
        int[] rand = new int[num];

        for (int i = 0; i < rand.length; i++) {
            rand[i] = (int) (Math.random() * 100);
            System.out.println(rand[i]);
            sum += rand[i];
        }

        System.out.println("Sum = " + sum);
    }
}
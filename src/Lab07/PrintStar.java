package Lab07;

import java.util.Scanner;

public class PrintStar {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);

        System.out.print("Number of stars? ");
        num = input.nextInt();

        for (int i = 0; i < num; i++)
            System.out.print("*");
    }
}
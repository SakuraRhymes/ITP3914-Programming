package Lab08;

import java.util.*;

public class Pattern2 {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Number? ");
        n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n - i; k++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }
    }
}
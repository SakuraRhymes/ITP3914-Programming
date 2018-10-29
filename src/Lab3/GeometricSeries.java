package Lab3;

import java.util.*;

public class GeometricSeries {
    public static void main(String[] args) {
        double a, R, n, S;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a : ");
        a = input.nextDouble();
        System.out.print("Enter R : ");
        R = input.nextDouble();
        System.out.print("Enter n : ");
        n = input.nextDouble();

        S = a * ((Math.pow(R, n)) - 1) / (R - 1);

        System.out.println("S = " + S);
    }
}
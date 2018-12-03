package Lab06;

import java.util.*;

public class QuadraticEquation {
    public static void main(String[] args) {
        double a, b, c, x1, x2, disc;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a: ");
        a = input.nextDouble();
        System.out.print("Enter b: ");
        b = input.nextDouble();
        System.out.print("Enter c: ");
        c = input.nextDouble();

        disc = (b * b - 4 * a * c);

        if (a == 0) {
            System.out.println("This is not a quadratic equation.");
        } else if (disc > 0) {
            x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            System.out.println("2 roots, x1 = " + x1 + ", x2 = " + x2);
        } else if (disc == 0) {
            x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            System.out.println("1 root, x = " + x1);
        } else if (disc < 0)
            System.out.println("No real solution");
    }
}
package Lab4;

import java.util.*;

public class Quadratic {
    public static void main(String[] args) {
        double a, b, c, x1, x2;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a: ");
        a = input.nextDouble();
        System.out.print("Enter b: ");
        b = input.nextDouble();
        System.out.print("Enter c: ");
        c = input.nextDouble();

        x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

        System.out.printf("x1 = %.2f" + ", x2 = %.2f", x1, x2);
    }
}
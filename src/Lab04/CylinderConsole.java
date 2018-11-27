package Lab04;

import java.util.*;

public class CylinderConsole {
    public static void main(String[] args) {
        double r, l, v;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        r = input.nextDouble();
        System.out.print("Enter the length: ");
        l = input.nextDouble();

        v = r * r * (Math.PI) * l;

        System.out.print("The volume of the cylinder with radius = " + r + " and length = " + l + " is " + v + ".");
    }
}
package Lab09;

import java.util.Scanner;

public class RightAngleTriangle {
    public static void main(String[] args) {
        int a, b, c;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the three sides of a triangle:");
        System.out.print("Side a: ");
        a = input.nextInt();
        System.out.print("Side b: ");
        b = input.nextInt();
        System.out.print("Side c: ");
        c = input.nextInt();

        if (checkRAT(a, b, c))
            System.out.println("The triangle is a right-angle triangle.");
        else
            System.out.println("The triangle is not a right-angle triangle.");
    }

    //Return true if the triangle is right-angled.
    public static boolean checkRAT(int a, int b, int c) {

        //Turn a,b,c into a^2,b^2,c^2 for easier coding.
        a *= a;
        b *= b;
        c *= c;

        return (a == b + c || b == a + c) || (c == a + b);
    }
}
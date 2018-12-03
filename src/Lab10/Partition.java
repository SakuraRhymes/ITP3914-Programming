package Lab10;

import java.util.*;

public class Partition {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number : ");
        num = input.nextInt();

        partition(num, "");
    }

    public static void partition(int num, String prefix) {
        if (num == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = num; i >= 1; i--) {
            partition(num - i, prefix + " " + i);
        }
    }
}
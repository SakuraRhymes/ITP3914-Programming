import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("? ");
        int num = kb.nextInt();

        if (isDivisibleBy7(num))
            System.out.println(num + " is divisible by 7");
        else
            System.out.println(num + " is not divisible by 7");
    }

    public static boolean isDivisibleBy7(int num) {
        return num % 7 == 0;
    }
}
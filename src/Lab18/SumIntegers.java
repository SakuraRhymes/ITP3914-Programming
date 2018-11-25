package Lab18;

public class SumIntegers {
    public static void main(String[] args) {
        if (args.length > 0) {
            int total = Integer.parseInt(args[0]);
            System.out.print(args[0]);
            if (args.length > 1) {
                for (int i = 1; i < args.length; i++) {
                    System.out.print(" + " + args[i]);
                    total += Integer.parseInt(args[i]);
                }
            }
            System.out.print(" = " + total);
        } else
            System.out.println("No input!");
    }
}
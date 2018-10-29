package Lab8;

public class FindPrime2 {
    public static void main(String[] args) {
        int count = 1, total = 0;

        System.out.print(2);

        int num = 2;
        while (count < 20) {
            num++;
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                total += 1;
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
                System.out.print(", " + num);
            }
        }

        System.out.println("\nDone");
        System.out.println("Total calculation = " + total);
    }
}
package Lab08;

public class MultiplicationTable {
    public static void main(String[] args) {

        //First line, print 0 ~ 9
        System.out.print("  ");
        for (int i = 0; i < 10; i++)
            System.out.printf("%3d", i);

        //Second line
        System.out.print("\n +------------------------------");

        //Table
        for (int i = 0; i < 10; i++) {
            System.out.print("\n" + i + "|");
            for (int j = 0; j < 10; j++)
                System.out.printf("%3d", i * j);
        }
    }
}
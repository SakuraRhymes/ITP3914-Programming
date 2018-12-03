package Lab02;

import java.util.*;

public class LDLC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTC, numHDLC, numTG;
        double numLDLC;

        System.out.print("Enter TC: ");
        numTC = input.nextInt();
        System.out.print("Enter HDLC: ");
        numHDLC = input.nextInt();
        System.out.print("Enter TG: ");
        numTG = input.nextInt();

        numLDLC = numTC - numHDLC - (double) numTG / 5;

        System.out.println("Lab02.LDLC = " + numLDLC);
    }
}
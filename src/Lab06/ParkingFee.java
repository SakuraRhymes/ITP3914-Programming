package Lab06;

import java.util.*;

public class ParkingFee {
    public static void main(String[] args) {
        int vType, pHours, pFee;
        Scanner input = new Scanner(System.in);

        System.out.print("Vehicle Type [1=private, 2=bus, 3=truck]? ");
        vType = input.nextInt();
        System.out.print("Number of hours? ");
        pHours = input.nextInt();

        if (vType == 1)
            pFee = 15 * pHours;
        else if (vType == 2)
            pFee = 35 * pHours;
        else
            pFee = 50 * pHours;

        System.out.print("Parking fee = " + pFee);
    }
}
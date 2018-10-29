package Lab6;

import java.util.*;

public class NYC {
    public static void main(String[] args) {
        int streetNum;
        String bound;
        Scanner input = new Scanner(System.in);

        System.out.print("Street Number? ");
        streetNum = input.nextInt();

        if ((streetNum % 2) == 1)
            bound = "West-bound";
        else
            bound = "East-bound";

        System.out.print(bound);
    }
}
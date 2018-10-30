/*
A Reversi Game in Java

Source File: Reversi.java
BY: Wong Hiu Hong  IT114105  180104583
*/

package Assignment;

import java.util.Scanner;

public class Reversi {
    public static void main(String[] args) {
        int player = 1;
        Scanner input = new Scanner(System.in);

        GameBoard GameBoard = new GameBoard();

        GameBoard.drawGameBoard();
    }

    //player variable indicate which player is ask to move next.
    //valid variable display a error message depend on its value.
    public static void askInput(int valid) {
        if (valid == 1)
            System.out.println("Error - input numbers should be 0 to 5!");
        if (valid == 2)
            System.out.println("Error - input cell is not empty.");
        if (valid == 3)
            System.out.println("Error - invalid move.");
//        if (player == 1)
//            System.out.print("\nPlease enter the position of '1':");
//        else
//            System.out.print("\nPlease enter the position of '2':");
    }

}
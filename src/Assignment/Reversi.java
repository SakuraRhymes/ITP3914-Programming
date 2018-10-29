/*
A Reversi Game in Java

Source File: Reversi.java
BY: Wong Hiu Hong  IT114105  180104583
*/

package Assignment;

import java.util.Scanner;

public class Reversi {
    public static int[][] board;
    public static int player = 1;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        InitializeGame();
        drawGameBoard();
        askInput(0);
        while (true) {
            int row = input.nextInt(), column = input.nextInt();
            if (!checkWithinBorder(row, column)) {
                askInput(1);
                continue;
            } else if (!checkIsEmpty(row, column)) {
                askInput(2);
                continue;
            }
            getValidMoveList();

        }
    }

    //Fill in the middle 4 pieces on the game board.
    public static void InitializeGame() {
        board = new int[6][6];
        board[2][2] = 1;
        board[2][3] = 2;
        board[3][2] = 2;
        board[3][3] = 1;
    }

    //Display the game board.
    public static void drawGameBoard() {

        //Print the first two lines
        System.out.print("   ");
        for (int i = 0; i < 6; i++)
            //Print column index
            System.out.print(" " + i);
        System.out.print("\n    -----------");

        //Display the game board array
        for (int row = 0; row < board.length; row++) {
            System.out.println();
            //Print row index
            System.out.print(row + " |");
            for (int column = 0; column < board[0].length; column++)
                System.out.print(" " + board[row][column]);
        }
        System.out.println("\n");
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
        if (player == 1)
            System.out.print("\nPlease enter the position of '1':");
        else
            System.out.print("\nPlease enter the position of '2':");
    }

    public static void getValidMoveList() {
        int opponent = player * -1;

        //Check though the 6x6 array
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                int numEmpty = 0;

                //Check in all 8 direction
                if (checkWithinBorder(i, j))
                    if (board[i][j] == 0)
                        numEmpty++;

            }
    }

    //Return true if the input is within border (6x6).
    public static boolean checkWithinBorder(int row, int column) {
        return ((row >= 0) && (row <= 5)) && ((column >= 0) && (column <= 5));
    }

    //Return true if the input is an empty cell.
    public static boolean checkIsEmpty(int row, int column) {
        return (board[row][column] == 0);
    }
}
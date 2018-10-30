/*
A Reversi Game in Java

Source File: Reversi.java
BY: Wong Hiu Hong  IT114105  180104583
*/

package Assignment;

import java.util.Scanner;

public class Reversi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        GameBoard GameBoard = new GameBoard();

        GameBoard.drawGameBoard();
        while (true) {
            GameBoard.askInput();
            int row = input.nextInt();
            int column = input.nextInt();
            if (GameBoard.checkWrongInput(row, column))
                GameBoard.setPiece(row, column);
        }
    }
}
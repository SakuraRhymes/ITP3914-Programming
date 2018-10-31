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

        //Display the game board
        GameBoard.drawGameBoard();

        //Main game loop
        while (true) {

            //Ask the player to enter a move
            GameBoard.askInput();

            //If place the piece successfully, continue and ask for the next input
            //If it is not a valid move, display a error message and ask the player to input again
            if (GameBoard.setPiece(input.nextInt(), input.nextInt())) {
                GameBoard.drawGameBoard();

                //Check if the game should end, drawn or skip turn etc.
                if (GameBoard.checkGameStatus())
                    break;
            }
        }
    }
}
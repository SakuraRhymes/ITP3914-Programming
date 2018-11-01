/*
The main game body for a Java Reversi game

Source File: GameBoard.java
BY: Wong Hiu Hong  IT114105  180104583
*/

package Assignment;

public class GameBoard {
    private int[][] board;  //The main game board array
    private int[][] validList;  //Store the valid moves that the current player can make
    private int player;     //Can be 1 or 2 to represent the current player, switch alternatively after a valid move
    private int opponent;   //Represent the opponent, opposite to the current player
    private int player1Pieces;  //How many pieces player one have on the board
    private int player2Pieces;  //How many pieces player two have on the board
    private int skippedTurn;    //How many turn is skipped consecutively

    //List that apply to a 2d array coordinate to achieve 8 directional movement
    private int[][] moveDirList = {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};

    //Constructor
    public GameBoard() {
        player = 1;
        opponent = 2;
        skippedTurn = 0;
        player1Pieces = 0;
        player2Pieces = 0;

        //Game board size can vary, up to 100x100
        board = new int[6][6];

        //Fill in the middle 4 pieces on the game board.
        board[2][2] = 1;
        board[2][3] = 2;
        board[3][2] = 2;
        board[3][3] = 1;

        //Generate a list of valid moves the current player can make
        validList = getValidMoveList();
    }

    //Return true if the input is within border.
    private boolean checkWithinBorder(int row, int column) {
        return ((row >= 0 && row < board.length) && (column >= 0 && column < board.length));
    }

    //Return true if the input is an empty cell.
    private boolean checkIsEmpty(int row, int column) {
        return (board[row][column] == 0);
    }

    //Display the game board.
    public void drawGameBoard() {

        //Print the first two lines
        System.out.print("\n    ");
        for (int i = 0; i < board.length; i++)
            //Print column index
            System.out.printf("%2d", i);

        //print the "-----" line according to board size
        System.out.print("\n     -");
        for (int i = 1; i < board.length; i++) {
            System.out.print("--");
        }

        //Display the game board array
        for (int row = 0; row < board.length; row++) {
            System.out.println();
            //Print row index
            System.out.printf("%2d |", row);
            for (int column = 0; column < board[row].length; column++)
                System.out.print(" " + board[row][column]);
        }
        System.out.println("\n");
    }

    //First check if the input is valid, then place and flip pieces accordingly
    //After a successful move, change to next player's turn, return true
    //Display a error message if a move is not valid, return false
    public boolean setPiece(int row, int column) {
        if (!checkWithinBorder(row, column)) {
            System.out.println("Error - input numbers should be 0 to " + (board.length - 1) + "!");
            return false;
        }
        if (!checkIsEmpty(row, column)) {
            System.out.println("Error - input cell is not empty.");
            return false;
        }
        if (!(validList[row][column] == 1)) {
            System.out.println("Error - invalid move.");
            return false;
        }

        //Place the inputted piece
        board[row][column] = player;
        flipPiece(row, column);
        changePlayer();
        return true;
    }

    //Check if the game should continue, end, skip turn etc.
    public boolean checkGameStatus() {
        player1Pieces = 0;
        player2Pieces = 0;
        validList = getValidMoveList();

        //Count how many pieces each player have on the board
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 1)
                    player1Pieces++;
                else if (board[row][column] == 2)
                    player2Pieces++;
            }
        }

        //Check if turn need to be skip
        while (checkSkipTurn()) {
            changePlayer();
            validList = getValidMoveList();

            //If two consecutive turn is skipped, meaning no player can make a move, the game end
            if (skippedTurn == 2) {
                endGame();
                return true;
            }
        }
        skippedTurn = 0;

        //If the game board is full, the game is over
        if (player1Pieces + player2Pieces == (board.length * board[0].length)) {
            endGame();
            return true;
        }
        return false;
    }

    //Display how many pieces each player have, and who is the winner
    //If both player have the same number of pieces, the game is drawn
    private void endGame() {
        System.out.println("Game Finishes.");
        System.out.println("\t'1' - " + player1Pieces);
        System.out.println("\t'2' - " + player2Pieces);
        if (player1Pieces > player2Pieces)
            System.out.println("Black wins.");
        if (player1Pieces < player2Pieces)
            System.out.println("White wins.");
        else
            System.out.println("Drawn game.");
    }

    //Return true if no valid move can be made by the current player
    private boolean checkSkipTurn() {

        //Count the number of valid moves
        int validMoves = 0;

        //Check through the valid move list and count the number of valid moves
        for (int row = 0; row < validList.length; row++)
            for (int column = 0; column < validList[row].length; column++)
                if (validList[row][column] == 1)
                    validMoves++;

        //If no valid can be found, the skippedTurn counter goes up by 1
        if (validMoves == 0) {
            skippedTurn++;
            return true;
        } else
            return false;
    }

    //Your every day System.out.print for asking player input
    public void askInput() {
        System.out.print("Please enter the position of '" + player + "':");
    }

    //Check which pieces need to be flip, and pass the list to the overload method
    private void flipPiece(int row, int column) {

        //A list to store what need to be flip
        int[][] flipList = new int[6][6];

        //Check in all 8 direction
        //dir is use to represent direction 0 - 7
        for (int dir = 0; dir < 8; dir++) {

            //How far to move in a direction, max is board size - 1
            //i is use to count the number of steps
            for (int i = 1; i < board.length; i++) {

                //Check if the next piece is still within border
                //moveDirList = {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}}
                //row + "Number of steps(i=1)" * "Which direction to move([dir=0][0]=1)" mean move down one row
                //column + "Number of steps(i=1)" * "Which direction to move([dir=0][1]=0)" mean column stay the same
                if (checkWithinBorder(row + (i * moveDirList[dir][0]), column + (i * moveDirList[dir][1]))) {

                    //Check if it is a opponent pieces
                    if (board[row + (i * moveDirList[dir][0])][column + (i * moveDirList[dir][1])] == opponent) {

                        //Store it to a list of pieces needed to be flip
                        flipList[row + (i * moveDirList[dir][0])][column + (i * moveDirList[dir][1])] = 1;

                        //Check if the next piece is one of current player's piece
                        if (checkWithinBorder(row + ((i + 1) * moveDirList[dir][0]), column + ((i + 1) * moveDirList[dir][1]))) {
                            if (board[row + ((i + 1) * moveDirList[dir][0])][column + ((i + 1) * moveDirList[dir][1])] == player) {

                                //If it is a valid move, Send the list to flip method
                                flipPiece(flipList);
                                break;
                            }
                        } else
                            break;
                    } else {
                        break;
                    }
                } else
                    break;
            }
            //Reset the list for next uses
            flipList = new int[6][6];
        }
    }

    //Flip pieces according to the list
    private void flipPiece(int[][] flipList) {

        //Loop through the list array
        for (int row = 0; row < flipList.length; row++)
            for (int column = 0; column < flipList[row].length; column++)

                //Turn any piece marked in the list to current player's piece
                if (flipList[row][column] == 1)
                    board[row][column] = player;
    }

    //Return how many valid move the current player have, if none, this turn will be skipped
    private int[][] getValidMoveList() {

        //A array to store the valid move
        int[][] validList = new int[board.length][board[0].length];

        //Check through the game board array
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {

                //Check if a piece can be place here
                if (checkIsEmpty(row, column)) {

                    //Check in all 8 direction
                    //dir is use to represent direction 0 - 7
                    for (int dir = 0; dir < 8; dir++) {

                        //How far to move in a direction, max is board size - 1
                        //i is use to count the number of steps
                        for (int i = 1; i < board.length; i++) {

                            //Check if the next piece is still within border
                            //moveDirList = {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}}
                            //row + "Number of steps(i=1)" * "Which direction to move([dir=0][0]=1)" mean move down one row
                            //column + "Number of steps(i=1)" * "Which direction to move([dir=0][1]=0)" mean column stay the same
                            if (checkWithinBorder(row + (i * moveDirList[dir][0]), column + (i * moveDirList[dir][1]))) {

                                //Check if it is a opponent pieces
                                if (board[row + (i * moveDirList[dir][0])][column + (i * moveDirList[dir][1])] == opponent) {

                                    //Check if the next piece is one of current player's piece
                                    if (checkWithinBorder(row + ((i + 1) * moveDirList[dir][0]), column + ((i + 1) * moveDirList[dir][1]))) {
                                        if (board[row + ((i + 1) * moveDirList[dir][0])][column + ((i + 1) * moveDirList[dir][1])] == player) {

                                            //Store it to the valid moves list
                                            validList[row][column] = 1;
                                            break;
                                        }
                                    } else
                                        break;
                                } else {
                                    break;
                                }
                            } else
                                break;
                        }
                    }
                }
            }
        }
        return validList;
    }

    //Switch player and opponent
    private void changePlayer() {
        if (player == 1) {
            player = 2;
            opponent = 1;
        } else {
            player = 1;
            opponent = 2;
        }
    }
}
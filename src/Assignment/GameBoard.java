package Assignment;

public class GameBoard {
    private int[][] board;
    private int[][] validList;
    private int player;
    private int opponent;
    private int player1Pieces;
    private int player2Pieces;
    private int skippedTurn;

    public GameBoard() {
        player = 1;
        opponent = 2;
        skippedTurn = 0;
        player1Pieces = 0;
        player2Pieces = 0;
        board = new int[6][6];

        //Fill in the middle 4 pieces on the game board.
        board[2][2] = 1;
        board[2][3] = 2;
        board[3][2] = 2;
        board[3][3] = 1;

        validList = getValidMoveList();
    }

    //Return true if the input is within border (6x6).
    private boolean checkWithinBorder(int row, int column) {
        return ((row >= 0 && row <= 5) && (column >= 0 && column <= 5));
    }

    //Return true if the input is an empty cell.
    private boolean checkIsEmpty(int row, int column) {
        return (board[row][column] == 0);
    }

    //Display the game board.
    public void drawGameBoard() {

        //Print the first two lines
        System.out.print("\n   ");
        for (int i = 0; i < board.length; i++)
            //Print column index
            System.out.print(" " + i);
        System.out.print("\n    -----------");

        //Display the game board array
        for (int row = 0; row < board.length; row++) {
            System.out.println();
            //Print row index
            System.out.print(row + " |");
            for (int column = 0; column < board[row].length; column++)
                System.out.print(" " + board[row][column]);
        }
        System.out.println("\n");
    }

    //First check if the input is valid, then place and flip pieces accordingly
    //Display a error message if a move is not valid or a turn is skipped
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
        board[row][column] = player;
        flipPiece(row, column);
        changePlayer();
        return true;
    }

    public boolean checkGameStatus() {
        player1Pieces = 0;
        player2Pieces = 0;
        validList = getValidMoveList();

        for (int row = 0; row < board.length; row++)
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 1)
                    player1Pieces++;
                else if (board[row][column] == 2)
                    player2Pieces++;
            }

        while (checkSkipTurn()) {
            changePlayer();
            validList = getValidMoveList();
            if (skippedTurn == 2) {
                endGame();
                return true;
            }
        }
        skippedTurn = 0;

        if (player1Pieces + player2Pieces == (board.length * board[0].length)) {
            endGame();
            return true;
        }
        return false;
    }

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

    private boolean checkSkipTurn() {
        int validMoves = 0;

        for (int row = 0; row < validList.length; row++)
            for (int column = 0; column < validList[row].length; column++)
                if (validList[row][column] == 1)
                    validMoves++;

        if (validMoves == 0) {
            skippedTurn++;
            return true;
        } else
            return false;
    }

    public void askInput() {
        System.out.print("Please enter the position of '" + player + "':");
    }

    private void flipPiece(int row, int column) {
        int dir = 0;
        int[][] moveDirList = {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};
        int[][] flipList = new int[6][6];

        for (dir = 0; dir < 8; dir++) {
            for (int i = 1; i < 6; i++) {
                if (checkWithinBorder(row + (i * moveDirList[dir][0]), column + (i * moveDirList[dir][1]))) {
                    if (board[row + (i * moveDirList[dir][0])][column + (i * moveDirList[dir][1])] == opponent) {
                        flipList[row + (i * moveDirList[dir][0])][column + (i * moveDirList[dir][1])] = 1;
                        if (checkWithinBorder(row + (i * moveDirList[dir][0]) + moveDirList[dir][0], column + (i * moveDirList[dir][1]) + moveDirList[dir][1])) {
                            if (board[row + (i * moveDirList[dir][0]) + moveDirList[dir][0]][column + (i * moveDirList[dir][1]) + moveDirList[dir][1]] == player) {
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
            flipList = new int[6][6];
        }
    }

    private int[][] getValidMoveList() {
        int[][] moveDirList = {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};
        int[][] validList = new int[6][6];

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (checkIsEmpty(row, column)) {
                    for (int dir = 0; dir < 8; dir++) {
                        for (int i = 1; i < 6; i++) {
                            if (checkWithinBorder(row + (i * moveDirList[dir][0]), column + (i * moveDirList[dir][1]))) {
                                if (board[row + (i * moveDirList[dir][0])][column + (i * moveDirList[dir][1])] == opponent) {
                                    if (checkWithinBorder(row + (i * moveDirList[dir][0]) + moveDirList[dir][0], column + (i * moveDirList[dir][1]) + moveDirList[dir][1])) {
                                        if (board[row + (i * moveDirList[dir][0]) + moveDirList[dir][0]][column + (i * moveDirList[dir][1]) + moveDirList[dir][1]] == player) {
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

    private void flipPiece(int[][] flipList) {
        for (int row = 0; row < flipList.length; row++)
            for (int column = 0; column < flipList[row].length; column++)
                if (flipList[row][column] == 1)
                    board[row][column] = player;
    }

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
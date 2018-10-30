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
            for (int column = 0; column < board[row].length; column++)
                System.out.print(" " + board[row][column]);
        }
        System.out.println("\n");
    }

    //First check if the input is valid, then place and flip pieces accordingly
    //Display a error message if a move is not valid or a turn is skipped
    public boolean setPiece(int row, int column) {
        if (!checkWithinBorder(row, column)) {
            System.out.println("Error - input numbers should be 0 to 5!");
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
        checkGameStatus();
        changePlayer();
        validList = getValidMoveList();

        while (checkSkipTurn(validList)) {
            changePlayer();
            validList = getValidMoveList();
            skippedTurn++;
            if (skippedTurn == 2)
                endGame();
        }
        skippedTurn = 0;
        return true;
    }

    private void checkGameStatus() {
        player1Pieces = 0;
        player2Pieces = 0;

        for (int row = 0; row < board.length; row++)
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 1)
                    player1Pieces++;
                else if (board[row][column] == 2)
                    player2Pieces++;
            }
        if (player1Pieces + player2Pieces == 36)
            endGame();
    }

    private void endGame() {
        System.out.println("Game Finishes.");
        System.out.println("\t'1' - " + player1Pieces);
        System.out.println("\t'2' - " + player2Pieces);
        if (player1Pieces > player2Pieces)
            System.out.println("White wins.");
        if (player1Pieces < player2Pieces)
            System.out.println("Black wins.");
        else
            System.out.println("Drawn game.");
    }

    private boolean checkSkipTurn(int[][] validList) {
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
        int[][] flipList;

        for (int i = 1; i < 6; i++) {
            flipList = new int[6][6];
            if (checkWithinBorder(row - i, column)) {
                if (board[row - i][column] == opponent) {
                    flipList[row - i][column] = 1;
                    if (checkWithinBorder(row - i - 1, column)) {
                        if (board[row - i - 1][column] == player) {
                            flipPiece(flipList);
                            break;
                        }
                    } else
                        break;
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < 6; i++) {
            flipList = new int[6][6];
            if (checkWithinBorder(row - i, column - i)) {
                if (board[row - i][column - i] == opponent) {
                    flipList[row - i][column - i] = 1;
                    if (checkWithinBorder(row - i - 1, column - i - 1)) {
                        if (board[row - i - 1][column - i - 1] == player) {
                            flipPiece(flipList);
                            break;
                        }
                    } else
                        break;
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < 6; i++) {
            flipList = new int[6][6];
            if (checkWithinBorder(row - i, column + i)) {
                if (board[row - i][column + i] == opponent) {
                    flipList[row - i][column + i] = 1;
                    if (checkWithinBorder(row - i - 1, column + i + 1)) {
                        if (board[row - i - 1][column + i + 1] == player) {
                            flipPiece(flipList);
                            break;
                        }
                    } else
                        break;
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < 6; i++) {
            flipList = new int[6][6];
            if (checkWithinBorder(row + i, column)) {
                if (board[row + i][column] == opponent) {
                    flipList[row + i][column] = 1;
                    if (checkWithinBorder(row + i + 1, column)) {
                        if (board[row + i + 1][column] == player) {
                            flipPiece(flipList);
                            break;
                        }
                    } else
                        break;
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < 6; i++) {
            flipList = new int[6][6];
            if (checkWithinBorder(row + i, column - i)) {
                if (board[row + i][column - i] == opponent) {
                    flipList[row + i][column - i] = 1;
                    if (checkWithinBorder(row + i + 1, column - i - 1)) {
                        if (board[row + i + 1][column - i - 1] == player) {
                            flipPiece(flipList);
                            break;
                        }
                    } else
                        break;
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < 6; i++) {
            flipList = new int[6][6];
            if (checkWithinBorder(row + i, column + i)) {
                if (board[row + i][column + i] == opponent) {
                    flipList[row + i][column + i] = 1;
                    if (checkWithinBorder(row + i + 1, column + i + 1)) {
                        if (board[row + i + 1][column + i + 1] == player) {
                            flipPiece(flipList);
                            break;
                        }
                    } else
                        break;
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < 6; i++) {
            flipList = new int[6][6];
            if (checkWithinBorder(row, column - i)) {
                if (board[row][column - i] == opponent) {
                    flipList[row][column - i] = 1;
                    if (checkWithinBorder(row, column - i - 1)) {
                        if (board[row][column - i - 1] == player) {
                            flipPiece(flipList);
                            break;
                        }
                    } else
                        break;
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < 6; i++) {
            flipList = new int[6][6];
            if (checkWithinBorder(row, column + i)) {
                if (board[row][column + i] == opponent) {
                    flipList[row][column + i] = 1;
                    if (checkWithinBorder(row, column + i + 1)) {
                        if (board[row][column + i + 1] == player) {
                            flipPiece(flipList);
                            break;
                        }
                    } else
                        break;
                } else
                    break;
            } else
                break;
        }

    }

    private void flipPiece(int[][] flipList) {
        for (int row = 0; row < flipList.length; row++)
            for (int column = 0; column < flipList[row].length; column++)
                if (flipList[row][column] == 1)
                    board[row][column] = player;
    }

    public void changePlayer() {
        if (player == 1) {
            player = 2;
            opponent = 1;
        } else {
            player = 1;
            opponent = 2;
        }
    }

    public int[][] getValidMoveList() {

        //A 2d array to store the valid move
        int[][] validList = new int[6][6];

        //Loop through the board array
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {

                //Move in a direction, up to 5 blocks away (board size 6x6)
                for (int i = 1; i < 6; i++) {

                    //Move Up "i" number of blocks, check if still inside game board
                    if (checkWithinBorder(row - i, column)) {

                        //Check if there are opponent pieces follow by one of your piece at the end
                        if (board[row - i][column] == opponent) {
                            if (checkWithinBorder(row - i - 1, column)) {
                                if (board[row - i - 1][column] == player && checkIsEmpty(row, column)) {

                                    //Save this as a valid move to the list
                                    validList[row][column] = 1;
                                    break;
                                }
                            } else
                                break;
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row - i, column - i)) {
                        if (board[row - i][column - i] == opponent) {
                            if (checkWithinBorder(row - i - 1, column - i - 1)) {
                                if (board[row - i - 1][column - i - 1] == player && checkIsEmpty(row, column)) {
                                    validList[row][column] = 1;
                                    break;
                                }
                            } else
                                break;
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row - i, column + i)) {
                        if (board[row - i][column + i] == opponent) {
                            if (checkWithinBorder(row - i - 1, column + i + 1)) {
                                if (board[row - i - 1][column + i + 1] == player && checkIsEmpty(row, column)) {
                                    validList[row][column] = 1;
                                    break;
                                }
                            } else
                                break;
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row + i, column)) {
                        if (board[row + i][column] == opponent) {
                            if (checkWithinBorder(row + i + 1, column)) {
                                if (board[row + i + 1][column] == player && checkIsEmpty(row, column)) {
                                    validList[row][column] = 1;
                                    break;
                                }
                            } else
                                break;
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row + i, column - i)) {
                        if (board[row + i][column - i] == opponent) {
                            if (checkWithinBorder(row + i + 1, column - i - 1)) {
                                if (board[row + i + 1][column - i - 1] == player && checkIsEmpty(row, column)) {
                                    validList[row][column] = 1;
                                    break;
                                }
                            } else
                                break;
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row + i, column + i)) {
                        if (board[row + i][column + i] == opponent) {
                            if (checkWithinBorder(row + i + 1, column + i + 1)) {
                                if (board[row + i + 1][column + i + 1] == player && checkIsEmpty(row, column)) {
                                    validList[row][column] = 1;
                                    break;
                                }
                            } else
                                break;
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row, column - i)) {
                        if (board[row][column - i] == opponent) {
                            if (checkWithinBorder(row, column - i - 1)) {
                                if (board[row][column - i - 1] == player && checkIsEmpty(row, column)) {
                                    validList[row][column] = 1;
                                    break;
                                }
                            } else
                                break;
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row, column + i)) {
                        if (board[row][column + i] == opponent) {
                            if (checkWithinBorder(row, column + i + 1)) {
                                if (board[row][column + i + 1] == player && checkIsEmpty(row, column)) {
                                    validList[row][column] = 1;
                                    break;
                                }
                            } else
                                break;
                        } else
                            break;
                    } else
                        break;
                }

            }
        }
        return validList;
    }
}
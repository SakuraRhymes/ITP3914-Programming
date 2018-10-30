package Assignment;

public class GameBoard {
    private int[][] board;
    private int player = 1;
    private int opponent = 2;
    private int[][] validList;

    public GameBoard() {
        board = new int[6][6];

        //Fill in the middle 4 pieces on the game board.
        board[2][2] = 1;
        board[2][3] = 2;
        board[3][2] = 2;
        board[3][3] = 1;
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

        validList = getValidMoveList();

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

    public int getPiece(int row, int column) {
        if (checkWithinBorder(row, column))
            return board[row][column];
        else
            return 0;
    }

    public void setPiece(int row, int column) {
        board[row][column] = player;
        changePlayer();
        drawGameBoard();
    }

    public void askInput() {
        System.out.print("Please enter the position of '" + player + "':");
    }

    public boolean checkWrongInput(int row, int column) {
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
        return true;
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

    public int[][] getValidMoveList() {
        int[][] validList = new int[6][6];

        //Loop though the board array
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {

                //Move in all direction, up to 5 blocks away
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row - i, column)) {
                        if (board[row - i][column] == opponent) {
                            if (board[row - i - 1][column] == player && checkIsEmpty(row, column)) {
                                validList[row][column] = 1;
                                break;
                            }
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row - i, column - i)) {
                        if (board[row - i][column - i] == opponent) {
                            if (board[row - i - 1][column - i - 1] == player && checkIsEmpty(row, column)) {
                                validList[row][column] = 1;
                                break;
                            }
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row - i, column + i)) {
                        if (board[row - i][column + i] == opponent) {
                            if (board[row - i - 1][column + i + 1] == player && checkIsEmpty(row, column)) {
                                validList[row][column] = 1;
                                break;
                            }
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row + i, column)) {
                        if (board[row + i][column] == opponent) {
                            if (board[row + i + 1][column] == player && checkIsEmpty(row, column)) {
                                validList[row][column] = 1;
                                break;
                            }
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row + i, column - i)) {
                        if (board[row + i][column - i] == opponent) {
                            if (board[row + i + 1][column - i - 1] == player && checkIsEmpty(row, column)) {
                                validList[row][column] = 1;
                                break;
                            }
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row + i, column + i)) {
                        if (board[row + i][column + i] == opponent) {
                            if (board[row + i + 1][column + i + 1] == player && checkIsEmpty(row, column)) {
                                validList[row][column] = 1;
                                break;
                            }
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row, column - i)) {
                        if (board[row][column - i] == opponent) {
                            if (board[row][column - i - 1] == player && checkIsEmpty(row, column)) {
                                validList[row][column] = 1;
                                break;
                            }
                        } else
                            break;
                    } else
                        break;
                }
                for (int i = 1; i < 6; i++) {
                    if (checkWithinBorder(row, column + i)) {
                        if (board[row][column + i] == opponent) {
                            if (board[row][column + i + 1] == player && checkIsEmpty(row, column)) {
                                validList[row][column] = 1;
                                break;
                            }
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
package Assignment;

public class GameBoard {
    private int[][] board;

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

//    private boolean checkValidMove(int row, int column){
//
//    }

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

    public int getPiece(int row, int column) {
        if (checkWithinBorder(row, column))
            return board[row][column];
        else
            return 0;
    }

//    public void setPiece(int row,int column){
//        if (checkWithinBorder(row,column) && checkIsEmpty(row,column))
//
//    }
}

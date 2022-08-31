package arrays.TicTacToe;

public class Board {
    private static final int player = 1;
    private static final int computer = 2;
    private static final char[] marks = {'O', 'X'};
    private boolean playerTurn = true;
    private String[][] board = {
        {"   ", "|   |", "   "},
        {"---", "|---|", "---"},
        {"   ", "|   |", "   "},
        {"---", "|---|", "---"},
        {"   ", "|   |", "   "},
    };
    private int[][] internalBoard;
    
    public Board() {
        internalBoard = new int[3][3];
        printBoard();
    }

    public boolean enterMove(int x, int y) {
        if (internalBoard[x][y] == 0) {
            internalBoard[x][y] =
                playerTurn ? player : computer;
    
            playerTurn = !playerTurn;
            updateBoard();
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }
    
    public int[][] getBoard() {
        return internalBoard;
    }

    private void updateBoard() {
        for (int i = 0, g = 0; g < 3; i+=2, g++) {
            for (int j = 0; j < 3; j++) {
                int status = internalBoard[g][j];
                
                if (status > 0) {
                    char mark = marks[status - 1];
                    board[i][j] = Util.changeCenter(board[i][j], mark);
                }
            }
        }
    }
}

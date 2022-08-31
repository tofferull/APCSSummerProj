package arrays.TicTacToe;

public class Checker {
    public static int hLine(int[] row) {
        int side = row[0];
        if (side == 0) return -1;

        for (int i = 1; i < row.length; i++)
            if (row[i] != side) return -1;

        return side;
    }

    public static int vLine(int[][] board, int i) {
        int side = board[0][i];
        if (side == 0) return -1;

        for (int j = 1; j < board.length; j++)
            if (board[j][i] != side) return -1;
        
        return side;
    }

    public static int dLeftLine(int[][] board) {
        int side = board[0][0];
        if (side == 0) return -1;

        for (int i = 1; i < board.length; i++)
            if (board[i][i] != side) return -1;

        return side;
    }

    public static int dRightLine(int[][] board) {
        int len = board.length - 1;
        int side = board[0][len];
        if (side == 0) return -1;

        for (int i = 0; i < len; i++)
            if (board[len-i][i] != side) return -1;

        return side;
    }
}

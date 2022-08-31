package arrays.TicTacToe;

public class Computer {
    private Board board;
    private int movesDone;
    public Computer(Board board) {
        this.board = board;
        movesDone = 0;
    }

    public void move(int x, int y) {
        if (movesDone == 4) return;
        if (board.enterMove(x, y)) {
            board.printBoard();
            movesDone++;
            return;
        }
        move(Util.randomNum(0, 3), Util.randomNum(0, 3));
    }
}

package work.microhand.model.game;

public class Chess {
    public static final int CELL_SIZE = 30;
    private final int rows;
    private final int cols;

    private char[][] board;

    public Chess(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        reset();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public char getPiece(int row, int col) {
        return board[row][col];
    }

    public void reset() {
        board = new char[rows][cols];
        initializeBoard();
    }

    /**
     * 初始化棋盘
     */
    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }
}

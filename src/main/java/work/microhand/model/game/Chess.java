package work.microhand.model.game;

import javax.swing.*;

/**
 * @author SanseYooyea
 */
public class Chess {
    public static final int CELL_SIZE = 30;
    private final int rows;
    private final int cols;

    private char[][] board;
    public Player currentPlayer;

    public Chess(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        board = new char[rows][cols];
        initializeBoard();

        currentPlayer = Player.WHITE;
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

    public Player getCurrentPlayer() {
        return currentPlayer;
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

    /**
     * 落子
     * @param row 行
     * @param col 列
     */
    public void placePiece(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer.getPieceSymbol();
            if (checkWin(row, col)) {
                JOptionPane.showMessageDialog(null, "玩家 " + currentPlayer + " 获胜！");
                initializeBoard();
            } else {
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == Player.WHITE ? Player.BLACK : Player.WHITE;
    }

    /**
     * 检查是否有玩家获胜
     * @param row 行
     * @param col 列
     * @return 是否有玩家获胜
     */
    private boolean checkWin(int row, int col) {
        char player = board[row][col];

        // 检查水平方向
        for (int i = col - 4; i <= col; i++) {
            if (i >= 0 && i + 4 < cols && board[row][i] == player && board[row][i + 1] == player &&
                    board[row][i + 2] == player && board[row][i + 3] == player && board[row][i + 4] == player) {
                return true;
            }
        }

        // 检查垂直方向
        for (int i = row - 4; i <= row; i++) {
            if (i >= 0 && i + 4 < rows && board[i][col] == player && board[i + 1][col] == player &&
                    board[i + 2][col] == player && board[i + 3][col] == player && board[i + 4][col] == player) {
                return true;
            }
        }

        // 检查正斜线方向
        for (int i = row - 4, j = col - 4; i <= row && j <= col; i++, j++) {
            if (i >= 0 && j >= 0 && i + 4 < rows && j + 4 < cols &&
                    board[i][j] == player && board[i + 1][j + 1] == player &&
                    board[i + 2][j + 2] == player && board[i + 3][j + 3] == player &&
                    board[i + 4][j + 4] == player) {
                return true;
            }
        }

        // 检查反斜线方向
        for (int i = row - 4, j = col + 4; i <= row && j >= col; i++, j--) {
            if (i >= 0 && j < cols && i + 4 < rows && j - 4 >= 0 &&
                    board[i][j] == player && board[i + 1][j - 1] == player &&
                    board[i + 2][j - 2] == player && board[i + 3][j - 3] == player &&
                    board[i + 4][j - 4] == player) {
                return true;
            }
        }

        return false;
    }
}

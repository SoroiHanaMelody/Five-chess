package work.microhand.model.game;

import javax.swing.*;

public class Game {
    protected Chess chess;
    protected Player currentPlayer;

    public Game() {
        reset();
    }

    public void reset() {
        chess = new Chess(15, 15);
        currentPlayer = Player.WHITE;
    }

    public Chess getChess() {
        return chess;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * 落子
     *
     * @param row 行
     * @param col 列
     */
    public void placePiece(int row, int col) {
        char[][] board = chess.getBoard();
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer.getPieceSymbol();
            if (checkWin(row, col)) {
                JOptionPane.showMessageDialog(null, "玩家 " + currentPlayer + " 获胜！");
                chess.reset();
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
     *
     * @param row 行
     * @param col 列
     * @return 是否有玩家获胜
     */
    private boolean checkWin(int row, int col) {
        char player = chess.getPiece(row, col);

        char[][] board = chess.getBoard();
        int rows = chess.getRows();
        int cols = chess.getCols();

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

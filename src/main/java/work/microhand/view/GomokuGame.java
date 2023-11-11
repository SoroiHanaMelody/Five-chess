package work.microhand.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author SanseYooyea
 */
public class GomokuGame extends JFrame {
    private static final int ROWS = 15;
    private static final int COLS = 15;
    private static final int CELL_SIZE = 30;

    private char[][] board = new char[ROWS][COLS];
    private char currentPlayer = 'X';

    public GomokuGame() {
        setTitle("五子棋");
        setSize(ROWS * CELL_SIZE, COLS * CELL_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ChessBoard chessBoard = new ChessBoard();
        add(chessBoard);

        chessBoard.addMouseListener(new ChessMouseListener());

        initializeBoard();

        setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private boolean makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWin(int row, int col) {
        // TODO: 实现判断胜利的逻辑
        return false;
    }

    private class ChessBoard extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    int x = j * CELL_SIZE;
                    int y = i * CELL_SIZE;

                    g.drawRect(x, y, CELL_SIZE, CELL_SIZE);

                    if (board[i][j] == 'X') {
                        g.setColor(Color.BLACK);
                        g.drawOval(x, y, CELL_SIZE, CELL_SIZE);
                    } else if (board[i][j] == 'O') {
                        g.setColor(Color.WHITE);
                        g.fillOval(x, y, CELL_SIZE, CELL_SIZE);
                    }
                }
            }
        }
    }

    private class ChessMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = e.getY() / CELL_SIZE;
            int col = e.getX() / CELL_SIZE;

            if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                if (makeMove(row, col)) {
                    if (checkWin(row, col)) {
                        JOptionPane.showMessageDialog(null, "玩家 " + currentPlayer + " 获胜！");
                        initializeBoard();
                    } else {
                        switchPlayer();
                    }

                    repaint();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GomokuGame::new);
    }
}

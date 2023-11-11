package work.microhand.view;

import work.microhand.model.game.Chess;
import work.microhand.service.ChessBoardService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static work.microhand.model.game.Chess.CELL_SIZE;

/**
 * @author SanseYooyea
 */
public class GomokuGame extends JFrame {
    private Chess chess;

    public GomokuGame() {
        setTitle("五子棋");
        chess = new Chess(15, 15);
        setSize(chess.getRows() * CELL_SIZE + 100, chess.getCols() * CELL_SIZE + 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ChessBoard chessBoard = new ChessBoard(chess);
        add(chessBoard);

        chessBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (ChessBoardService.onMouseClickChessBoard(e, chess)) {
                    repaint();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GomokuGame::new);
    }
}

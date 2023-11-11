package work.microhand.view;

import work.microhand.model.game.Chess;
import work.microhand.model.game.Player;

import javax.swing.*;
import java.awt.*;

import static work.microhand.model.game.Chess.CELL_SIZE;

/**
 * @author SanseYooyea
 */
public class ChessBoard extends JPanel {
    private Chess chess;

    public ChessBoard(Chess chess) {
        this.chess = chess;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < chess.getRows(); i++) {
            for (int j = 0; j < chess.getCols(); j++) {
                g.setColor(Color.BLACK);
                int x = j * CELL_SIZE;
                int y = i * CELL_SIZE;

                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);

                if (chess.getPiece(i, j) == Player.BLACK.getPieceSymbol()) {
                    g.setColor(Color.BLACK);
                    g.fillOval(x, y, CELL_SIZE, CELL_SIZE);
                } else if (chess.getPiece(i, j) == Player.WHITE.getPieceSymbol()) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x, y, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }
}

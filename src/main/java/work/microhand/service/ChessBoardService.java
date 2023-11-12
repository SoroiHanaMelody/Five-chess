package work.microhand.service;

import work.microhand.manager.GameManager;
import work.microhand.model.game.Chess;
import work.microhand.view.game.GomokuGame;

import java.awt.event.MouseEvent;

import static work.microhand.model.game.Chess.CELL_SIZE;

public class ChessBoardService {
    /**
     * 处理鼠标点击棋盘事件
     *
     * @param event 鼠标事件
     * @return 是否需要 repaint
     */
    public static void onMouseClickChessBoard(MouseEvent event) {
        int row = event.getY() / CELL_SIZE;
        int col = event.getX() / CELL_SIZE;

        Chess chess = GameManager.INSTANCE.getGame().getChess();
        if (row >= 0 && row < chess.getRows() && col >= 0 && col < chess.getCols()) {
            GameManager.INSTANCE.getGame().placePiece(row, col);
            GomokuGame.staticRepaint();
        }
    }
}

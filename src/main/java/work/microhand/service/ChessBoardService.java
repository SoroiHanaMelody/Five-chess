package work.microhand.service;

import work.microhand.model.game.Chess;

import java.awt.event.MouseEvent;

import static work.microhand.model.game.Chess.CELL_SIZE;

/**
 * @author SanseYooyea
 */
public class ChessBoardService {
    /**
     * 处理鼠标点击棋盘事件
     *
     * @param event 鼠标事件
     * @param chess 点击棋盘
     * @return 是否需要 repaint
     */
    public static boolean onMouseClickChessBoard(MouseEvent event, Chess chess) {
        int row = event.getY() / CELL_SIZE;
        int col = event.getX() / CELL_SIZE;

        if (row >= 0 && row < chess.getRows() && col >= 0 && col < chess.getCols()) {
            chess.placePiece(row, col);
            return true;
        }

        return false;
    }
}

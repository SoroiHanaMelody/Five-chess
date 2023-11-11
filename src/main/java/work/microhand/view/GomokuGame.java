package work.microhand.view;

import work.microhand.manager.GameManager;
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

    public GomokuGame() {
        setTitle("Gomoku Game");
        Chess chess = GameManager.INSTANCE.getGame().getChess();
        setSize(chess.getRows() * CELL_SIZE + 100, chess.getCols() * CELL_SIZE + 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newGameItem = new JMenuItem("New Game");
        JMenuItem saveGameItem = new JMenuItem("Save Game");
        JMenuItem loadGameItem = new JMenuItem("Load Game");
        fileMenu.add(newGameItem);
        fileMenu.add(loadGameItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

//        newGameItem.addActionListener(e -> {
//            MenuService.onClickNewGameMenuItem(chess);
//            repaint();
//        });
//
//        saveGameItem.addActionListener(e -> {
//            saveGame();
//        });
//
//        loadGameItem.addActionListener(e -> {
//            loadGame();
//            repaint();
//        });

        ChessBoard chessBoard = new ChessBoard(chess);
        add(chessBoard);

        chessBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (ChessBoardService.onMouseClickChessBoard(e)) {
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

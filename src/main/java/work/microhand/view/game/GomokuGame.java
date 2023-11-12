package work.microhand.view.game;

import work.microhand.io.DataSource;
import work.microhand.manager.GameManager;
import work.microhand.model.config.DatabaseConfig;
import work.microhand.model.game.Chess;
import work.microhand.service.ChessBoardService;
import work.microhand.service.MenuService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static work.microhand.model.game.Chess.CELL_SIZE;

public class GomokuGame extends JFrame {
    private static GomokuGame INSTANCE;

    public GomokuGame() {
        setTitle("Gomoku Game");
        Chess chess = GameManager.INSTANCE.getGame().getChess();
        setSize(chess.getRows() * CELL_SIZE + 80, chess.getCols() * CELL_SIZE + 65);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newGameItem = new JMenuItem("New Game");
        JMenuItem saveGameItem = new JMenuItem("Save Game");
        JMenuItem loadGameItem = new JMenuItem("Load Game");
        fileMenu.add(newGameItem);
        fileMenu.add(saveGameItem);
        fileMenu.add(loadGameItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        newGameItem.addActionListener(e -> {
            MenuService.onClickNewGameMenuItem();
            repaint();
        });

        saveGameItem.addActionListener(e -> {
            MenuService.onClickSaveGameMenuItem();
        });

        loadGameItem.addActionListener(e -> {
            MenuService.onClickLoadGameMenuItem();
        });

        ChessBoard chessBoard = new ChessBoard();
        add(chessBoard);

        chessBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChessBoardService.onMouseClickChessBoard(e);
            }
        });

        setVisible(true);
    }

    public static void staticRepaint() {
        INSTANCE.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> INSTANCE = new GomokuGame());
        DatabaseConfig.init();
        new DataSource(DatabaseConfig.getProperties());
    }
}

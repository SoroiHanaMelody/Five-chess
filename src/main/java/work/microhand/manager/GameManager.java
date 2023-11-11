package work.microhand.manager;

import work.microhand.model.game.Game;
import work.microhand.model.game.Player;

import javax.swing.*;

/**
 * @author SanseYooyea
 */
public enum GameManager {
    /**
     * 单例
     */
    INSTANCE;

    private Game game;

    GameManager() {
        game = new Game();
    }

    public Game getGame() {
        return game;
    }

    public void newGame() {
        game = new Game();
    }

    public void loadGame(Game game) {
        this.game = game;
    }

    public void saveGame() {

    }

    public void onPlacePiece(int row, int col) {
        game.placePiece(row, col);
    }
}

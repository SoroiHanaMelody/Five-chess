package work.microhand.manager;

import work.microhand.io.DataSource;
import work.microhand.model.game.SavedGame;

import java.util.List;

/**
 * @author SanseYooyea
 */
public enum GameSaveManager {
    /**
     * 单例
     */
    INSTANCE;

    private static final DataSource DATA_SOURCE = DataSource.getInstance();
    private List<SavedGame> savedGames;

    GameSaveManager() {

    }

    public void load() {

    }


}

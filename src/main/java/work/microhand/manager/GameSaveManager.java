package work.microhand.manager;

import work.microhand.dao.SavedGameDAO;
import work.microhand.model.game.SavedGame;

import java.util.Date;
import java.util.List;

public enum GameSaveManager {
    /**
     * 单例
     */
    INSTANCE;

    private List<SavedGame> savedGames;

    GameSaveManager() {
        loadAll();
    }

    public List<SavedGame> getSavedGames() {
        return savedGames;
    }

    public void loadAll() {
        savedGames = SavedGameDAO.INSTANCE.loadAll();
    }

    public void save(Date savedDate) {
        SavedGame savedGame = new SavedGame(GameManager.INSTANCE.getGame(), savedDate);
        SavedGameDAO.INSTANCE.saveGame(savedGame);
        savedGames.add(savedGame);
    }

}

package work.microhand.model.game;

import java.util.Date;

public class SavedGame {
    private final Game game;
    private final Date saveDate;

    public SavedGame(Game game, Date saveDate) {
        this.game = game;
        this.saveDate = saveDate;
    }

    public Game getGame() {
        return game;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    @Override
    public String toString() {
        return "存档时间：" + saveDate;
    }
}

package work.microhand.model.game;

import java.util.Date;

/**
 * @author SanseYooyea
 */
public class SavedGame extends Game {
    private final Date saveDate;

    public SavedGame(Date saveDate) {
        this.saveDate = saveDate;
    }

    public Date getSaveDate() {
        return saveDate;
    }
}

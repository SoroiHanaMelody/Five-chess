package work.microhand.service;


import work.microhand.manager.GameManager;
import work.microhand.manager.GameSaveManager;
import work.microhand.view.archive.ArchiveSelectionPage;
import work.microhand.view.game.GomokuGame;

import javax.swing.*;
import java.util.Date;

/**
 * @author SanseYooyea
 */
public class MenuService {
    public static void onClickNewGameMenuItem() {
        GameManager.INSTANCE.newGame();
        GomokuGame.staticRepaint();
    }

    public static void onClickSaveGameMenuItem() {
        GameSaveManager.INSTANCE.save(new Date());
    }

    public static void onClickLoadGameMenuItem() {
        SwingUtilities.invokeLater(ArchiveSelectionPage::new);
    }
}

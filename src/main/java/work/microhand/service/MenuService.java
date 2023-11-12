package work.microhand.service;


import work.microhand.manager.GameManager;

/**
 * @author SanseYooyea
 */
public class MenuService {
    public static void onClickNewGameMenuItem() {
        GameManager.INSTANCE.newGame();
    }

    public static void onClickSaveGameMenuItem() {
        GameManager.INSTANCE.saveGame();
    }

    public static void onClickLoadGameMenuItem() {
//        GameManager.INSTANCE.loadGame();
    }
}

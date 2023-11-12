package work.microhand.service;

import work.microhand.manager.GameManager;
import work.microhand.model.game.SavedGame;
import work.microhand.view.game.GomokuGame;

import javax.swing.*;

/**
 * @author SanseYooyea
 */
public class ArchiveSelectService {
    public static void onClickLoadButton(SavedGame selectedArchive) {
        if (selectedArchive != null) {
            // 执行加载存档的逻辑
            loadArchive(selectedArchive);
        } else {
            JOptionPane.showMessageDialog(null, "请选择要加载的存档");
        }
    }

    public static void onClickDeleteButton(DefaultListModel<SavedGame> archiveListModel, SavedGame selectedArchive) {
        if (selectedArchive != null) {
            // 执行删除存档的逻辑
            deleteArchive(archiveListModel, selectedArchive);
        } else {
            JOptionPane.showMessageDialog(null, "请选择要删除的存档");
        }
    }

    private static void loadArchive(SavedGame archive) {
        // 实现加载存档的逻辑
        GameManager.INSTANCE.loadGame(archive.getGame());
        JOptionPane.showMessageDialog(null, "加载存档: " + archive.getSaveDate());
        GomokuGame.staticRepaint();
    }

    private static void deleteArchive(DefaultListModel<SavedGame> archiveListModel, SavedGame archive) {
        // 实现删除存档的逻辑
        archiveListModel.removeElement(archive);
        JOptionPane.showMessageDialog(null, "删除存档: " + archive);
    }
}

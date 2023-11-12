package work.microhand.view.archive;

import work.microhand.manager.GameManager;
import work.microhand.manager.GameSaveManager;
import work.microhand.model.game.SavedGame;
import work.microhand.service.ArchiveSelectService;

import javax.swing.*;
import java.awt.*;

public class ArchiveSelectionPage extends JFrame {
    private JList<SavedGame> archiveList;
    private DefaultListModel<SavedGame> archiveListModel;

    public ArchiveSelectionPage() {
        setTitle("存档选择");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // 初始化存档列表
        archiveListModel = new DefaultListModel<>();
        archiveListModel.addAll(GameSaveManager.INSTANCE.getSavedGames());
        archiveList = new JList<>(archiveListModel);
        JScrollPane scrollPane = new JScrollPane(archiveList);

        // 初始化加载按钮和删除按钮
        JButton loadButton = new JButton("加载存档");
        JButton deleteButton = new JButton("删除存档");

        loadButton.addActionListener(e -> {
            SavedGame selectedArchive = archiveList.getSelectedValue();
            ArchiveSelectService.onClickLoadButton(selectedArchive);
        });

        deleteButton.addActionListener(e -> {
            SavedGame selectedArchive = archiveList.getSelectedValue();
            ArchiveSelectService.onClickDeleteButton(archiveListModel, selectedArchive);
        });

        // 布局界面
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

package work.microhand.view.archive;

import javax.swing.*;
import java.awt.*;

/**
 * @author SanseYooyea
 */
public class ArchiveSelectionPage extends JFrame {
    private JList<String> archiveList;
    private DefaultListModel<String> archiveListModel;

    public ArchiveSelectionPage() {
        setTitle("存档选择");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 初始化存档列表
        archiveListModel = new DefaultListModel<>();
        archiveList = new JList<>(archiveListModel);
        JScrollPane scrollPane = new JScrollPane(archiveList);

        // 初始化加载按钮和删除按钮
        JButton loadButton = new JButton("加载存档");
        JButton deleteButton = new JButton("删除存档");

        loadButton.addActionListener(e -> {
            String selectedArchive = archiveList.getSelectedValue();
            if (selectedArchive != null) {
                // 执行加载存档的逻辑
                loadArchive(selectedArchive);
            } else {
                JOptionPane.showMessageDialog(null, "请选择要加载的存档");
            }
        });

        deleteButton.addActionListener(e -> {
            String selectedArchive = archiveList.getSelectedValue();
            if (selectedArchive != null) {
                // 执行删除存档的逻辑
                deleteArchive(selectedArchive);
            } else {
                JOptionPane.showMessageDialog(null, "请选择要删除的存档");
            }
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

    private void loadArchive(String archiveName) {
        // 实现加载存档的逻辑
        // game.loadGame();
        JOptionPane.showMessageDialog(null, "加载存档: " + archiveName);
    }

    private void deleteArchive(String archiveName) {
        // 实现删除存档的逻辑
        archiveListModel.removeElement(archiveName);
        JOptionPane.showMessageDialog(null, "删除存档: " + archiveName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ArchiveSelectionPage::new);
    }
}

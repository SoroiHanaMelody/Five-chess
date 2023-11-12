package work.microhand.dao;

import com.google.gson.Gson;
import work.microhand.io.DataSource;
import work.microhand.model.game.SavedGame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SanseYooyea
 */
public class SavedGameDAO {
    public static final SavedGameDAO INSTANCE = new SavedGameDAO();

    private static final Gson GSON = new Gson();
    private final DataSource dataSource = DataSource.getInstance();


    // Save a SavedGame instance to the database
    public void saveGame(SavedGame savedGame) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO saved_games (SAVED_DATE, GAME_FIELDS) VALUES (?, ?)")) {
            preparedStatement.setDate(1, new Date(savedGame.getSaveDate().getTime()));
            preparedStatement.setString(2, GSON.toJson(savedGame, SavedGame.class));
            // Set other fields as needed
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Load a SavedGame instance from the database
    public SavedGame loadGame(Date savedDate) {
        SavedGame savedGame = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saved_games WHERE SAVED_DATE = ?")) {
            preparedStatement.setDate(1, savedDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    savedGame = GSON.fromJson(resultSet.getString("game_fields"), SavedGame.class);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedGame;
    }

    public List<SavedGame> loadAll() {
        List<SavedGame> savedGames = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saved_games")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    savedGames.add(GSON.fromJson(resultSet.getString("game_fields"), SavedGame.class));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedGames;
    }

    public void deleteGame(SavedGame savedGame) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM saved_games WHERE SAVED_DATE = ?")) {
            preparedStatement.setDate(1, new Date(savedGame.getSaveDate().getTime()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

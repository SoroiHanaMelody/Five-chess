package work.microhand.dao;

import com.google.gson.Gson;
import work.microhand.io.DataSource;
import work.microhand.model.game.SavedGame;

import java.sql.*;
import java.util.List;

/**
 * @author SanseYooyea
 */
public class SavedGameDAO {
    private static final Gson GSON = new Gson();
    private final DataSource dataSource = DataSource.getInstance();

    private List<SavedGame> savedGames;

    // Save a SavedGame instance to the database
    public void saveGame(SavedGame savedGame) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO saved_games (GAME_ID, SAVED_DATE, GAME_FIELDS) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, savedGames.size());
            preparedStatement.setDate(2, new java.sql.Date(savedGame.getSaveDate().getTime()));
            preparedStatement.setString(3, GSON.toJson(savedGame, SavedGame.class));
            // Set other fields as needed
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Load a SavedGame instance from the database
    public SavedGame loadGame(int gameId) {
        SavedGame savedGame = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saved_games WHERE game_id = ?")) {
            preparedStatement.setInt(1, gameId);

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

    public void loadAll() {
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
    }

    public void deleteGame(int gameId) {
        SavedGame savedGame = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM saved_games WHERE game_id = ?")) {
            preparedStatement.setInt(1, gameId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

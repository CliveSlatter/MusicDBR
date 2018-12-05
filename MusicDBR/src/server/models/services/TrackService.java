package server.models.services;

import server.Console;
import server.DatabaseConnection;
import server.models.Track;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TrackService {

    public static String selectAllInto(List<Track> targetList) {
        targetList.clear();
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT trackId, year, artist, title FROM Tracks"
            );
            if (statement != null) {
                ResultSet results = statement.executeQuery();
                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Track(results.getInt("trackId"), results.getInt("year"), results.getString("artist"), results.getString("title")));
                   }
                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select all from 'Tracks' table: " + resultsException.getMessage();
            Console.log(error);
            return error;
        }
        return "OK";
    }

    public static Track selectById(int id) {
        Track result = null;
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT trackId, year, artist, title FROM Tracks WHERE trackId = ?"
            );
            if (statement != null) {
                statement.setInt(1, id);
                ResultSet results = statement.executeQuery();
                if (results != null && results.next()) {
                    result = new Track(results.getInt("trackId"), results.getInt("year"), results.getString("artist"), results.getString("title"));
                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select by id from 'Tracks' table: " + resultsException.getMessage();
            Console.log(error);
        }
        return result;
    }

    public static String insert(Track itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "INSERT INTO Tracks (trackId, year, artist, title) VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, itemToSave.getTrackId());
            statement.setInt(2, itemToSave.getYear());
            statement.setString(3, itemToSave.getArtist());
            statement.setString(4, itemToSave.getTitle());
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't insert into 'Tracks' table: " + resultsException.getMessage();
            Console.log(error);
            return error;
        }
    }

    public static String update(Track itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "UPDATE Tracks SET year = ?, artist = ?, title = ? WHERE trackId = ?"
            );
            statement.setInt(1, itemToSave.getYear());
            statement.setString(2, itemToSave.getArtist());
            statement.setString(3, itemToSave.getTitle());
            statement.setInt(4, itemToSave.getTrackId());
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't update 'Tracks' table: " + resultsException.getMessage();
            Console.log(error);
            return error;
        }
    }

    public static String deleteById(int id) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "DELETE FROM Tracks WHERE trackId = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't delete by id from 'Tracks' table: " + resultsException.getMessage();
            Console.log(error);
            return error;
        }
    }

}

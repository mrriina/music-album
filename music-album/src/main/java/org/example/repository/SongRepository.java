package org.example.repository;

import org.example.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    default void saveSong(Song song) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO song (id, title, lyrics, artists, duration, album_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, song.getId());
            statement.setString(2, song.getTitle());
            statement.setString(3, song.getLyrics());
            statement.setString(4, song.getArtists());
            statement.setInt(5, song.getDuration());
            statement.setLong(6, song.getAlbumId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void update(Song song) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE song SET title=?, lyrics=?, artists=?, duration=?, album_id=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, song.getTitle());
            statement.setString(2, song.getLyrics());
            statement.setString(3, song.getArtists());
            statement.setInt(4, song.getDuration());
            statement.setLong(5, song.getAlbumId());
            statement.setLong(6, song.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void delete(Song song) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM song WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, song.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM song";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String lyrics = resultSet.getString("lyrics");
                String artists = resultSet.getString("artists");
                int duration = resultSet.getInt("duration");
                long album_id = resultSet.getInt("album_id");
                Song song = new Song(id, title, lyrics, artists, duration, album_id);
                songs.add(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songs;
    }

    default Song getSongById(long id) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM song WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String lyrics = resultSet.getString("lyrics");
                String artists = resultSet.getString("artists");
                int duration = resultSet.getInt("duration");
                long album_id = resultSet.getInt("album_id");
                return new Song(id, title, lyrics, artists, duration, album_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music_albums", "root", "");
        return connection;
    }
}
package org.example.repository;

import org.example.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    default void saveAlbum(Album album) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO album (id, title, artists, genre, release_year, songs_count) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, album.getId());
            statement.setString(2, album.getTitle());
            statement.setString(3, album.getArtists());
            statement.setString(4, album.getGenre());
            statement.setInt(5, album.getReleaseYear());
            statement.setInt(6, album.getSongsCount());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void update(Album album) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE album SET title=?, artists=?, genre=?, release_year=?, songs_count=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, album.getTitle());
            statement.setString(2, album.getArtists());
            statement.setString(3, album.getGenre());
            statement.setInt(4, album.getReleaseYear());
            statement.setInt(5, album.getSongsCount());
            statement.setLong(6, album.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void delete(Album album) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM album WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, album.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM album";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String artists = resultSet.getString("artists");
                String genre = resultSet.getString("genre");
                int releaseYear = resultSet.getInt("release_year");
                int songsCount = resultSet.getInt("songs_count");
                Album album = new Album(id, title, artists, genre, releaseYear, songsCount);
                albums.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    default Album getAlbumById(long id) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM album WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String artists = resultSet.getString("artists");
                String genre = resultSet.getString("genre");
                int releaseYear = resultSet.getInt("release_year");
                int songsCount = resultSet.getInt("songs_count");
                return new Album(id, title, artists, genre, releaseYear, songsCount);
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
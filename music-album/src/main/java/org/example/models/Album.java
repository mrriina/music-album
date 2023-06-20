package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Album {
    @Id
    private Long id;
    private String title;
    private String artists;
    private String genre;
    private int releaseYear;
    private int songsCount;

    @JsonCreator
    public Album(@JsonProperty("id") Long id,
                 @JsonProperty("title") String title,
                 @JsonProperty("artists") String artists,
                 @JsonProperty("genre") String genre,
                 @JsonProperty("releaseYear") int releaseYear,
                 @JsonProperty("songsCount") int songsCount) {
        this.id = id;
        this.title = title;
        this.artists = artists;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songsCount = songsCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getSongsCount() {
        return songsCount;
    }

    public void setSongsCount(int songsCount) {
        this.songsCount = songsCount;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artists='" + artists + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", songsCount=" + songsCount +
                '}';
    }
}
package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Song {
    @Id
    private Long id;
    private String title;
    private String lyrics;
    private String artists;
    private int duration;
    private Long albumId;

    @JsonCreator
    public Song(@JsonProperty("id") Long id,
                 @JsonProperty("title") String title,
                 @JsonProperty("lyrics") String lyrics,
                 @JsonProperty("artists") String artists,
                 @JsonProperty("duration") int duration,
                 @JsonProperty("album_id") long albumId) {
        this.id = id;
        this.title = title;
        this.lyrics = lyrics;
        this.artists = artists;
        this.duration = duration;
        this.albumId = albumId;
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

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", artists='" + artists + '\'' +
                ", duration=" + duration +
                ", albumId=" + albumId +
                '}';
    }
}
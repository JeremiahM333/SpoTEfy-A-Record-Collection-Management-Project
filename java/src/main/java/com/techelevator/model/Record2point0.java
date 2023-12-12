package com.techelevator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Record2point0 {

    private int recordId;

    private int userId;

    private String albumName;

    private String albumCover;

    private LocalDate releaseDate;

    private String mediaType;

    private String recordNotes;

    private List<Collection> collections = new ArrayList<>();

    private List<Artist> artists = new ArrayList<>();

    private List<Genre> genres = new ArrayList<>();


    public Record2point0(int recordId, int userId, String albumName, String albumCover, LocalDate releaseDate, String mediaType, String recordNotes) {
        this.recordId = recordId;
        this.userId = userId;
        this.albumName = albumName;
        this.albumCover = albumCover;
        this.releaseDate = releaseDate;
        this.mediaType = mediaType;
        this.recordNotes = recordNotes;
    }

    public Record2point0() {
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getRecordNotes() {
        return recordNotes;
    }

    public void setRecordNotes(String recordNotes) {
        this.recordNotes = recordNotes;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}

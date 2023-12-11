package com.techelevator.dao;

import com.techelevator.model.Artist;
import com.techelevator.model.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getGenresByRecordId(int recordId);

    List<Genre> createGenresForRecordId(int recordId, List<String> genreNames);

    Genre getGenreById(int genreId);
}

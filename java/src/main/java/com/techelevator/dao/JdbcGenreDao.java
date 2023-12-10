package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Genre;
import com.techelevator.model.Record;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGenreDao implements GenreDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> getGenresByRecordId(int recordId) {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT g.genre_id, genre_name " +
                     "FROM genres g " +
                     "JOIN records_genres rg ON g.genre_id = rg.genre_id " +
                     "WHERE record_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, recordId);
            while (results.next()) {
                genres.add(mapRowToGenre(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return genres;
    }

    private Genre mapRowToGenre(SqlRowSet rs) {
        Genre genre = new Genre();
        genre.setGenreId(rs.getInt("genre_id"));
        genre.setGenreName(rs.getString("genre_name"));
        return genre;
    }
}

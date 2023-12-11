package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Artist;
import com.techelevator.model.Genre;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

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

    @Override
    public List<Genre> createGenresForRecordId(int recordId, List<String> genreNames) {
        List<Genre> newGenres = new ArrayList<>();
        String createGenreSQL = "INSERT INTO genres(genre_name)\n" +
                "\tVALUES (?) RETURNING genre_id;";
        String addGenreToRecordSQL = "INSERT INTO records_genres(genre_id, record_id)\n" +
                "\tVALUES (?, ?)";

        for (String genre : genreNames) {
            try {
                int newArtistId = jdbcTemplate.queryForObject(createGenreSQL, int.class, genre);
                Genre newGenre = getGenreById(newArtistId);

                newGenres.add(newGenre);

                int rowsAffected = jdbcTemplate.update(addGenreToRecordSQL, newArtistId, recordId);

                if (rowsAffected == 0) {
                    throw new DaoException("Expected at least one row to be inserted. None were.");
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            } catch (DataIntegrityViolationException e) {
                throw new DaoException("Data integrity violation", e);
            }
        }

        return newGenres;
    }

    @Override
    public Genre getGenreById(int genreId) {
        Genre genre = null;
        String artistIdSQL = "SELECT genre_id, genre_name\n" +
                "FROM genres\n" +
                "WHERE genre_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(artistIdSQL, genreId);
            if (results.next()) {
                genre = mapRowToGenre(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return genre;
    }

    private Genre mapRowToGenre(SqlRowSet rs) {
        Genre genre = new Genre();
        genre.setGenreId(rs.getInt("genre_id"));
        genre.setGenreName(rs.getString("genre_name"));
        return genre;
    }
}

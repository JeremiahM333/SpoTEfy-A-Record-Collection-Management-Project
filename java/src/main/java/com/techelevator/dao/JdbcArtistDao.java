package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Artist;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcArtistDao implements ArtistDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcArtistDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Artist> getArtistsByRecordId(int recordId) {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT a.artist_id, artist_name " +
                "FROM artists a " +
                "JOIN artists_records ar ON a.artist_id = ar.artist_id " +
                "WHERE record_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, recordId);
            while (results.next()) {
                artists.add(mapRowToArtist(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return artists;
    }

    public List<Artist> createArtistsForRecordId(int recordId, List<String> artistNames) {
        List<Artist> newArtists = new ArrayList<>();
        String createArtistSQL = "INSERT INTO artists(artist_name)\n" +
                "\tVALUES (?) RETURNING artist_id;";
        String addRecordToArtistSQL = "INSERT INTO artists_records(artist_id, record_id)\n" +
                "\tVALUES (?, ?)";

        for (String artist : artistNames) {
            try {
                int newArtistId = jdbcTemplate.queryForObject(createArtistSQL, int.class, artist);
                Artist newArtist = getArtistById(newArtistId);

                newArtists.add(newArtist);

                int rowsAffected = jdbcTemplate.update(addRecordToArtistSQL, newArtistId, recordId);

                if (rowsAffected == 0) {
                    throw new DaoException("Expected at least one row to be inserted. None were.");
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            } catch (DataIntegrityViolationException e) {
                throw new DaoException("Data integrity violation", e);
            }
        }

        return newArtists;
    }

    public Artist getArtistById(int artistId) {
        Artist artist = null;
        String artistIdSQL = "SELECT artist_id, artist_name\n" +
                "FROM artists\n" +
                "WHERE artist_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(artistIdSQL, artistId);
            if (results.next()) {
                artist = mapRowToArtist(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return artist;
    }


    private Artist mapRowToArtist(SqlRowSet rs) {
        Artist artist = new Artist();
        artist.setArtistId(rs.getInt("artist_id"));
        artist.setArtistName(rs.getString("artist_name"));
        return artist;
    }
}

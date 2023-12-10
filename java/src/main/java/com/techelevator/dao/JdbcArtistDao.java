package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Artist;
import com.techelevator.model.Genre;
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

    @Override
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

    private Artist mapRowToArtist(SqlRowSet rs) {
        Artist artist = new Artist();
        artist.setArtistId(rs.getInt("artist_id"));
        artist.setArtistName(rs.getString("artist_name"));
        return artist;
    }
}

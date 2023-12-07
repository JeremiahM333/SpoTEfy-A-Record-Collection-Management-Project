package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Record;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecordDao implements RecordDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Record> getRecordsByCollectionId(int id) {
        List<Record> records = new ArrayList<>();
        String sql = "SELECT r.record_id, user_id, album_name, album_cover, release_date, media_type " +
                     "FROM records r " +
                     "JOIN collections_records cr ON r.record_id = cr.record_id " +
                     "WHERE collection_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                records.add(mapRowToRecord(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return records;
    }

    public List<Record> getRecordsByUserId(int userId) {
        List<Record> records = new ArrayList<>();
        String sql = "SELECT record_id, user_id, album_name, album_cover, release_date, media_type FROM records WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                records.add(mapRowToRecord(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return records;
    }

    private Record mapRowToRecord(SqlRowSet rs) {
        Record record = new Record();
        record.setRecordId(rs.getInt("record_id"));
        record.setUserId(rs.getInt("user_id"));
        record.setAlbumName(rs.getString("album_name"));
        record.setAlbumCover(rs.getString("album_cover"));
        record.setReleaseDate(rs.getDate("release_date").toLocalDate());
        record.setMediaType(rs.getString("media_type"));
        return record;
    }
}

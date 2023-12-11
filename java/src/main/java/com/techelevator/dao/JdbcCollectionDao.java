package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Collection> getPublicCollections() {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, user_id, collection_name, is_public, collection_cover FROM collections WHERE is_public";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                collections.add(mapRowToCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }

    public List<Collection> getCollectionsByUserId(int userId) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, user_id, collection_name, is_public, collection_cover FROM collections WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                collections.add(mapRowToCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }

    public Collection getCollectionById(int collectionId) {
        Collection collection = null;
        String sql = "SELECT collection_id, user_id, collection_name, is_public, collection_cover FROM collections WHERE collection_id = ?";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionId);
            if (result.next()) {
                collection = mapRowToCollection(result);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collection;
    }

    public int getNumOfCollectionsByUserId(int userId) {
        String sql = "SELECT COUNT(collection_id) AS num_of_collections FROM collections WHERE user_id = ? GROUP BY user_id";
        int numOfCollections = -1;
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
            if (result.next()) {
                numOfCollections = result.getInt("num_of_collections");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return numOfCollections;
    }

    @Override
    public Collection createCollection(Collection collection) {
        Collection newColletion = null;
        String insert = "INSERT INTO collections (collection_name, user_id, is_public, collection_cover) " +
                "VALUES (?, ?, ?, ?) RETURNING collection_id;";
        try {
            int newCollectionId = jdbcTemplate.queryForObject(insert, int.class,
                    collection.getCollectionName(), collection.getUserId(), collection.isPublic(), collection.getCollectionCover());
            newColletion = getCollectionById(newCollectionId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newColletion;
    }

    @Override
    public int addRecordToCollection(Integer collectionId, int recordId) {
        int rowsAffected = 0;
        String insert = "INSERT INTO collections_records (collection_id, record_id) " +
                "VALUES (?, ?)";
        try {
            rowsAffected = jdbcTemplate.update(insert, collectionId, recordId);

            if (rowsAffected == 0) {
                throw new DaoException("Expected one row to be affect, but none were");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return rowsAffected;
    }

    private Collection mapRowToCollection(SqlRowSet rs) {
        Collection collection = new Collection();
        collection.setCollectionId(rs.getInt("collection_id"));
        collection.setUserId(rs.getInt("user_id"));
        collection.setCollectionName(rs.getString("collection_name"));
        collection.setPublic(rs.getBoolean("is_public"));
        collection.setCollectionCover(rs.getString("collection_cover"));
        return collection;
    }
}

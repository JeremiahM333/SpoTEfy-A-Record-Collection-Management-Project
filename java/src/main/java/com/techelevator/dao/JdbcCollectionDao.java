package com.techelevator.dao;

import com.techelevator.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcCollectionDao implements CollectionDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection createTransfer(Collection collection) {
        Collection newColletion = null;
        String insertUserSQL = "INSERT INTO collections collection_id,collection_name RETURNING collection_id = ?";
    }

    private Collection mapRowToCollection(SqlRowSet rs) {
        Collection collection = new Collection();
        collection.setCollectionId(rs.getInt("collection_id"));
        collection.setCollectionName(rs.getString("collection_name"));
        return collection;
    }


}

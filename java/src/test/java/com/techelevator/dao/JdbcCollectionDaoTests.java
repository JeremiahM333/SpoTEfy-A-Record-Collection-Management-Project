package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcCollectionDaoTests extends BaseDaoTests{

    protected static final User USER_1 = new User(1, "user1", "user1", "ROLE_USER");

    private JdbcCollectionDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcCollectionDao(jdbcTemplate);
    }

    @Test
    public void createUser_creates_a_user() {
        Collection collection = new Collection();
        collection.setCollectionId(0);
        collection.setUserId(USER_1.getId());
        collection.setCollectionName("Test Name");
        collection.setPublic(false);
        Collection createdCollection = sut.createCollection(collection);

        Assert.assertNotNull(createdCollection);
        Assert.assertTrue(createdCollection.getCollectionId() > 0);

        collection.setCollectionId(createdCollection.getCollectionId());

        assertCollectionsMatch(collection, createdCollection);
    }

    @Test(expected = DaoException.class)
    public void createCollection_with_null_name() {
        Collection collection = new Collection();
        collection.setCollectionId(0);
        collection.setUserId(USER_1.getId());
        collection.setCollectionName(null);
        collection.setPublic(false);
        sut.createCollection(collection);
    }

    private void assertCollectionsMatch(Collection expected, Collection actual) {
        Assert.assertEquals(expected.getCollectionId(), actual.getCollectionId());
        Assert.assertEquals(expected.getUserId(), actual.getUserId());
        Assert.assertEquals(expected.getCollectionName(), actual.getCollectionName());
        Assert.assertEquals(expected.isPublic(), actual.isPublic());
//        Assert.assertEquals(expected.getCollectionImage(), actual.getCollectionImage());
    }
}

package com.techelevator.dao;

import com.techelevator.model.Collection;

public interface CollectionDao {


     Collection createCollection(Collection collection);

     Collection getCollectionById(int collectionId);

}

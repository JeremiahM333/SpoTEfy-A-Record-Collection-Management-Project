package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {


     List<Collection> getCollections();

     Collection createCollection(Collection collection);

     Collection getCollectionById(int collectionId);

}

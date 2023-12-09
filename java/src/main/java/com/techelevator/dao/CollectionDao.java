package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {


     List<Collection> getPublicCollections();

     List<Collection> getCollectionsByUserId(int userId);

     Collection getCollectionById(int collectionId);

     int getNumOfCollectionsByUserId(int userId);

     Collection createCollection(Collection collection);

     int addRecordToCollection(int collectionId);
}

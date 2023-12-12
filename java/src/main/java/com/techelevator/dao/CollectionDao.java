package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {


     List<Collection> getPublicCollections();

     List<Collection> getCollectionsByUserId(int userId);

     Collection getCollectionById(int collectionId);

     List<Collection> getPublicCollectionsBySearch(List<String> search);

     List<Collection> getCollectionsBySearchByUserId(List<String> search, int userId);

     int getNumOfCollectionsByUserId(int userId);

     List<Collection> getCollectionsByRecordId(int recordId);

     Collection createCollection(Collection collection);

     int addRecordToCollection(Integer collectionId, int recordId);
}

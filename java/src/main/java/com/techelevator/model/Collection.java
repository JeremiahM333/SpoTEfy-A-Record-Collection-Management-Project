package com.techelevator.model;

public class Collection {

    private int collectionId;

    private String collectionName;

    public Collection(int collectionId, String collectionName) {
        this.collectionId = collectionId;
        this.collectionName = collectionName;
    }

    public Collection() {
        this.collectionId = collectionId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

}

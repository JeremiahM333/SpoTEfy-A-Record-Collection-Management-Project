package com.techelevator.model;

public class Collection {

    private int collectionId;
    private int userId;
    private String collectionName;
    private boolean isPublic;

    public Collection(int collectionId, int userId, String collectionName, boolean isPublic) {
        this.collectionId = collectionId;
        this.userId = userId;
        this.collectionName = collectionName;
        this.isPublic = isPublic;
    }

    public Collection() {
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}

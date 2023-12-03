package com.techelevator.model;

public class Collection {

    private int collectionId;
    private int userId;
    private String collectionName;
    private boolean isPublic;
    private String collectionCover;

    public Collection(int collectionId, int userId, String collectionName, boolean isPublic, String collectionCover) {
        this.collectionId = collectionId;
        this.userId = userId;
        this.collectionName = collectionName;
        this.isPublic = isPublic;
        this.collectionCover = collectionCover;
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

    public String getCollectionCover() {
        return collectionCover;
    }

    public void setCollectionCover(String collectionCover) {
        this.collectionCover = collectionCover;
    }
}

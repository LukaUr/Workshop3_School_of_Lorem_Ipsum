package pl.coderslab.model;

import java.sql.Date;

public class Solution {
    private int id;
    private Date created;
    private Date updated;
    private String description;
    private int exerciseId;
    private int userID;

    public Solution(Date created, Date updated, String description, int exerciseId, int userID) {
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exerciseId = exerciseId;
        this.userID = userID;
    }

    public Solution() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

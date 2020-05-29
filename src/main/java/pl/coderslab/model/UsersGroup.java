package pl.coderslab.model;

import pl.coderslab.utils.AppConfig;

public class UsersGroup {
    private int id;
    private String name;

    public UsersGroup() {
    }

    public UsersGroup(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

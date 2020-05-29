package pl.coderslab.model;

import pl.coderslab.utils.BCrypt;

public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    private int user_group_id;

    public User() {
    }

    public User(String userName, String email, String password, int user_group_id) {
        this.userName = userName;
        this.email = email;
        hashPassword(password);
        this.user_group_id = user_group_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public int getUser_group_id() {
        return user_group_id;
    }

    public void setUser_group_id(int user_group_id) {
        this.user_group_id = user_group_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void hashPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
}

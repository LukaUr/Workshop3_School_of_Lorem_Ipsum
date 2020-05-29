package pl.coderslab.model;

import pl.coderslab.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password, user_group_id) VALUES (?, ?, ?, ?)";
    private static final String READ_USER_QUERY =
            "SELECT * FROM users where id = ?";
    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ?, user_group_id = ? where id = ?";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_USERS_QUERY =
            "SELECT * FROM users";
    private static final String READ_PASSWORD =
            "select password from users where id = ?";
    private static final String FIND_ALL_USERS_BY_GROUPID_QUERY =
            "SELECT * FROM users where user_group_id = ?";
    private static final String READ_USER_BY_EMAIL_QUERY =
            "select * from users where email = ?";

    public User createUser(User user) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            preS = setUserData(preS, user);
            preS.setString(3, user.getPassword());
            preS.executeUpdate();
            ResultSet rs = preS.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User readUser(int userId) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(READ_USER_QUERY);
            preS.setInt(1, userId);
            ResultSet rs = preS.executeQuery();
            if (rs.next()) {
                return getUserData(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User readUserByEmail(String email) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(READ_USER_BY_EMAIL_QUERY);
            preS.setString(1, email);
            ResultSet rs = preS.executeQuery();
            if (rs.next()) {
                return getUserData(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(User user) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(UPDATE_USER_QUERY);
            preS = setUserData(preS, user);
            preS.setString(3, verifyPassword(connection, user));
            preS.setInt(5, user.getId());
            preS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(DELETE_USER_QUERY);
            preS.setInt(1, userId);
            preS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User[] findAllUsers() {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(FIND_ALL_USERS_QUERY);
            ResultSet rs = preS.executeQuery();
            User[] allUsers = new User[0];
            while (rs.next()) {
                User user = getUserData(rs);
                allUsers = addUsersToArray(user, allUsers);
            }
            return allUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAllUsersByGroupId(int groupId) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(FIND_ALL_USERS_BY_GROUPID_QUERY);
            preS.setInt(1, groupId);
            ResultSet rs = preS.executeQuery();
            List<User> allUsers = new ArrayList<>();
            while (rs.next()) {
                User user = getUserData(rs);
                allUsers.add(user);
            }
            return allUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User[] addUsersToArray(User user, User[] users) {
        User[] result = Arrays.copyOf(users, users.length + 1);
        result[users.length] = user;
        return result;
    }

    private User getUserData(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUserName(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setUser_group_id(rs.getInt("user_group_id"));
        return user;
    }

    private PreparedStatement setUserData(PreparedStatement preS, User user) throws SQLException {
        preS.setString(1, user.getUserName());
        preS.setString(2, user.getEmail());
        preS.setInt(4, user.getUser_group_id());
        return preS;
    }

    private String verifyPassword(Connection connection, User user) throws SQLException {
        PreparedStatement p = connection.prepareStatement(READ_PASSWORD);
        p.setInt(1, user.getId());
        ResultSet r = p.executeQuery();
        if (r.next()) {
            String passwordFromDatabase = r.getString(1);
            if (passwordFromDatabase.equals(user.getPassword())) {
                return passwordFromDatabase;
            } else {
                user.hashPassword(user.getPassword());
                return user.getPassword();
            }
        }
        return null;
    }
}

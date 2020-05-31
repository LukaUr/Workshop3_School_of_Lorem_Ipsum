package pl.coderslab.model;

import pl.coderslab.utils.DBUtil;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupDao {

    public static final GroupDao dao = new GroupDao();

    private static final String CREATE_USERSGROUP_QUERY =
            "INSERT INTO users_groups(name) VALUES (?)";
    private static final String READ_USERSGROUP_QUERY =
            "SELECT * FROM users_groups where id = ?";
    private static final String UPDATE_USERSGROUP_QUERY =
            "UPDATE users_groups SET name = ? where id = ?";
    private static final String DELETE_USERSGROUP_QUERY =
            "DELETE FROM users_groups WHERE id = ?";
    private static final String FIND_ALL_USERSGROUPS_QUERY =
            "SELECT * FROM users_groups";

    public Group createUserGroup(Group usersGroup) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(CREATE_USERSGROUP_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preS.setString(1, usersGroup.getName());
            preS.executeUpdate();
            ResultSet rs = preS.getGeneratedKeys();
            if (rs.next()) {
                usersGroup.setId(rs.getInt(1));
            }
            return usersGroup;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Group readUsersGroup(int usersGroupId) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(READ_USERSGROUP_QUERY);
            preS.setInt(1, usersGroupId);
            ResultSet rs = preS.executeQuery();
            if (rs.next()) {
                Group usersGroup = new Group();
                usersGroup.setId(usersGroupId);
                usersGroup.setName(rs.getString("name"));
                return usersGroup;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUsersGroup(Group usersGroup) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(UPDATE_USERSGROUP_QUERY);
            preS.setString(1, usersGroup.getName());
            preS.setInt(2, usersGroup.getId());
            preS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsersGroup(int usersGroupId) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(DELETE_USERSGROUP_QUERY);
            preS.setInt(1, usersGroupId);
            preS.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "Remove all users from group before deleting it", "Group is not empty", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Group> findAllUsersGroups() {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(FIND_ALL_USERSGROUPS_QUERY);
            ResultSet rs = preS.executeQuery();
            List<Group> allUsersGroups = new ArrayList<>();
            while (rs.next()) {
                Group tmp = new Group();
                tmp.setId(rs.getInt("id"));
                tmp.setName(rs.getString("name"));
                allUsersGroups.add(tmp);
            }
            return allUsersGroups;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Group[] addUsersGroupToArray(Group usersGroup, Group[] allUsersGroups) {
        Group[] result = Arrays.copyOf(allUsersGroups, allUsersGroups.length + 1);
        result[allUsersGroups.length] = usersGroup;
        return result;
    }
}

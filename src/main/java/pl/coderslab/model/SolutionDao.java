package pl.coderslab.model;

import pl.coderslab.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionDao {

    public static final SolutionDao dao = new SolutionDao();

    private static final String CREATE_SOLUTION_QUERY =
            "INSERT INTO solutions(created, updated, description, exercise_id, user_id) VALUES (NOW(), ?, ?, ?, ?)";
    private static final String READ_SOLUTION_QUERY =
            "SELECT * FROM solutions where id = ?";
    private static final String UPDATE_SOLUTION_QUERY =
            "UPDATE solutions SET updated = ?, description = ?, exercise_id = ?, user_id = ? where id = ?";
    private static final String DELETE_SOLUTION_QUERY =
            "DELETE FROM solutions WHERE id = ?";
    private static final String FIND_ALL_SOLUTIONS_QUERY =
            "SELECT * FROM solutions";
    private static final String FIND_ALL_SOLUTIONS_FROM_USER_QUERY =
            "SELECT * FROM solutions where user_id = ?";
    private static final String FIND_ALL_SOLUTIONS_BY_EXERCISE_ID_QUERY =
            "SELECT * FROM solutions where exercise_id = ?";
    private static final String FIND_UNSOLVED_SOLUTIONS_FROM_USER_QUERY =
            "SELECT * FROM solutions where user_id = ? and updated is null";

    public Solution createSolution(Solution solution) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(CREATE_SOLUTION_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preS = setSolutionData(preS, solution);
            preS.executeUpdate();
            ResultSet rs = preS.getGeneratedKeys();
            if (rs.next()) {
                solution.setId(rs.getInt(1));
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Solution readSolution(int solutionId) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(READ_SOLUTION_QUERY);
            preS.setInt(1, solutionId);
            ResultSet rs = preS.executeQuery();
            if (rs.next()) {
                return getSolutionData(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSolution(Solution solution) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(UPDATE_SOLUTION_QUERY);
            preS = setSolutionData(preS, solution);
            preS.setInt(5, solution.getId());
            preS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSolution(int SolutionId) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(DELETE_SOLUTION_QUERY);
            preS.setInt(1, SolutionId);
            preS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Solution> findAllSolutions() {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(FIND_ALL_SOLUTIONS_QUERY);
            ResultSet rs = preS.executeQuery();
            List<Solution> allSolutions = new ArrayList<>();
            while (rs.next()) {
                Solution tmp = getSolutionData(rs);
                allSolutions.add(tmp);
            }
            return allSolutions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Solution[] findAllByUserId(int userId) {
        return findAllBySomeValue(userId, FIND_ALL_SOLUTIONS_FROM_USER_QUERY);
    }

    public Solution[] findAllByExerciseId(int id) {
        return findAllBySomeValue(id, FIND_ALL_SOLUTIONS_BY_EXERCISE_ID_QUERY);
    }

    public Solution[] findUnsolvedByUserId(int userId) {
        return findAllBySomeValue(userId, FIND_UNSOLVED_SOLUTIONS_FROM_USER_QUERY);
    }

    private Solution[] findAllBySomeValue(int value, String query) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preS = connection.prepareStatement(query);
            preS.setInt(1, value);
            ResultSet rs = preS.executeQuery();
            Solution[] allSolutions = new Solution[0];
            while (rs.next()) {
                Solution tmp = getSolutionData(rs);
                allSolutions = addSolutionToArray(tmp, allSolutions);
            }
            return allSolutions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PreparedStatement setSolutionData(PreparedStatement p, Solution s) throws SQLException {
        p.setDate(1, s.getUpdated());
        p.setString(2, s.getDescription());
        p.setInt(3, s.getExerciseId());
        p.setInt(4, s.getUserID());
        return p;
    }

    private Solution getSolutionData(ResultSet rs) throws SQLException {
        Solution s = new Solution();
        s.setId(rs.getInt("id"));
        s.setCreated(rs.getDate("created"));
        s.setUpdated(rs.getDate("updated"));
        s.setDescription(rs.getString("description"));
        s.setExerciseId(rs.getInt("exercise_id"));
        s.setUserID(rs.getInt("user_id"));
        return s;
    }

    private Solution[] addSolutionToArray(Solution solution, Solution[] allSolutions) {
        Solution[] result = Arrays.copyOf(allSolutions, allSolutions.length + 1);
        result[allSolutions.length] = solution;
        return result;
    }
}

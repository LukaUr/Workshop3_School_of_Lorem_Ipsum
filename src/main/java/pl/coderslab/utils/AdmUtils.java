package pl.coderslab.utils;

import pl.coderslab.model.*;

import java.util.List;
import java.util.Scanner;

public class AdmUtils {

    public static String trimmer(String input, int maxLength) {
        if (input != null && input.length() > maxLength) {
            return input.substring(0, maxLength - 3) + "...";
        }
        return input;
    }

    public static boolean checkUserId(int userId) {
        User user = UserDao.dao.readUser(userId);
        if (user != null) {
            return true;
        }
        System.out.println("There is no user with Id = " + userId);
        return false;
    }

    public static boolean checkUserEmail(User u) {
        String email = u.getEmail();
        int userId = u.getId();
        List<User> users = UserDao.dao.findAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getId() != userId) {
                System.out.println("User with this email already exists");
                return false;
            }
        }
        return true;
    }

    public static boolean checkGroupId(int groupId) {
        Group group = GroupDao.dao.readUsersGroup(groupId);
        if (group != null) {
            return true;
        }
        System.out.println("There is no group with Id = " + groupId);
        return false;
    }

    public static boolean checkUser(User user) {
        boolean test1 = checkUserEmail(user);
        boolean test2 = checkGroupId(user.getGroupId());
        return (test1 && test2);
    }

    public static boolean checkExerciseId(int id) {

        Exercise exercise = ExerciseDao.dao.readExercise(id);
        if (exercise != null) {
            return true;
        }
        System.out.println("Exercise with Id = " + id + " not found");
        return false;
    }

    public static boolean checkSolutionId(int id, int userId) {
        Solution solution = SolutionDao.dao.readSolution(id);
        if (solution != null && solution.getUserId() == userId) {
            return true;
        }
        System.out.println("Work with Id = " + id + " not found.");
        return false;
    }

    public static boolean checkUserOnDelete(int id) {
        if (checkUserId(id)) {
            Solution[] solutions = SolutionDao.dao.findAllByUserId(id);
            if (solutions.length == 0) {
                return true;
            }
            System.out.println("Unable to delete user. Delete all his/her work first.");
        }
        return false;
    }

    public static boolean checkExerciseOnDelete(int id) {
        if (checkExerciseId(id)) {
            Solution[] solutions = SolutionDao.dao.findAllByExerciseId(id);
            if (solutions.length == 0) {
                return true;
            }
            System.out.println("Unable to delete exercise. Delete all solutions of this exercise first.");
        }
        return false;
    }

    public static boolean checkGroupOnDelete(int id) {
        if (checkGroupId(id)) {
            List<User> users = UserDao.dao.findAllUsersByGroupId(id);
            if (users.size() == 0) {
                return true;
            }
            System.out.println("Unable to delete group. Group is not empty.");
        }
        return false;
    }

    public static boolean checkSolutionOnDelete(int id){
        Solution solution = SolutionDao.dao.readSolution(id);
        if (solution != null) {
            return true;
        }
        System.out.println("Work with Id = " + id + " not found.");
        return false;
    }
}

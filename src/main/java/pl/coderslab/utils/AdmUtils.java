package pl.coderslab.utils;

import pl.coderslab.model.*;

import java.util.List;
import java.util.Scanner;

public class AdmUtils {
    public static int getNumber(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("Choose a number");
            scan.next();
        }
        int result = scan.nextInt();
        scan.nextLine();
        return result;
    }

    public static String trimmer(String input, int maxLength) {
        if (input != null && input.length() > maxLength) {
            return input.substring(0, maxLength - 3) + "...";
        }
        return input;
    }

    public static boolean checkUserId(int userId) {
        UserDao userDao = new UserDao();
        User user = userDao.readUser(userId);
        if (user != null) {
            return true;
        }
        System.out.println("There is no user with Id = " + userId);
        return false;
    }

    public static boolean checkUserEmail(User u) {
        String email = u.getEmail();
        int userId = u.getId();
        UserDao userDao = new UserDao();
        List<User> users = userDao.findAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getId() != userId) {
                System.out.println("User with this email already exists");
                return false;
            }
        }
        return true;
    }

    public static boolean checkGroupId(int groupId) {
        UsersGroupDao usersGroupDao = new UsersGroupDao();
        UsersGroup group = usersGroupDao.readUsersGroup(groupId);
        if (group != null) {
            return true;
        }
        System.out.println("There is no group with Id = " + groupId);
        return false;
    }

    public static boolean checkUser(User user) {
        boolean test1 = checkUserEmail(user);
        boolean test2 = checkGroupId(user.getUser_group_id());
        return (test1 && test2);
    }

    public static boolean checkExerciseId(int id) {
        ExerciseDao dao = new ExerciseDao();
        Exercise exercise = dao.readExercise(id);
        if (exercise != null) {
            return true;
        }
        System.out.println("Exercise with Id = " + id + " not found");
        return false;
    }

    public static boolean checkSolutionId(int id, int userId) {
        SolutionDao dao = new SolutionDao();
        Solution solution = dao.readSolution(id);
        if (solution != null && solution.getUserID() == userId) {
            return true;
        }
        System.out.println("Work with Id = " + id + " not found.");
        return false;
    }

    public static boolean checkUserOnDelete(int id) {
        if (checkUserId(id)) {
            SolutionDao dao = new SolutionDao();
            Solution[] solutions = dao.findAllByUserId(id);
            if (solutions.length == 0) {
                return true;
            }
            System.out.println("Unable to delete user. Delete all his/her work first.");
        }
        return false;
    }

    public static boolean checkExerciseOnDelete(int id) {
        if (checkExerciseId(id)) {
            SolutionDao dao = new SolutionDao();
            Solution[] solutions = dao.findAllByExerciseId(id);
            if (solutions.length == 0) {
                return true;
            }
            System.out.println("Unable to delete exercise. Delete all solutions of this exercise first.");
        }
        return false;
    }

    public static boolean checkGroupOnDelete(int id) {
        if (checkGroupId(id)) {
            UserDao dao = new UserDao();
            List<User> users = dao.findAllUsersByGroupId(id);
            if (users.size() == 0) {
                return true;
            }
            System.out.println("Unable to delete group. Group is not empty.");
        }
        return false;
    }

    public static boolean checkSolutionOnDelete(int id){
        SolutionDao dao = new SolutionDao();
        Solution solution = dao.readSolution(id);
        if (solution != null) {
            return true;
        }
        System.out.println("Work with Id = " + id + " not found.");
        return false;
    }
}

package pl.coderslab.utils;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;
import pl.coderslab.model.UsersGroup;
import pl.coderslab.model.UsersGroupDao;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {
    public static void getUserFromParameter(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.readUser(userId);
        request.setAttribute("user", user);
        UsersGroupDao groupDao = new UsersGroupDao();
        UsersGroup group = groupDao.readUsersGroup(user.getUser_group_id());
        request.setAttribute("group", group);
    }
}

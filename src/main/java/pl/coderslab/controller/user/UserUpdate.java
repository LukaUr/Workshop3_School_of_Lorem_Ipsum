package pl.coderslab.controller.user;

import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/user/edit")
public class UserUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        User user = UserDao.dao.readUser(userId);
        user.setName(userName);
        user.setEmail(email);
        if (password.length() > 0) {
            user.setPassword(password);
        }
        user.setGroupId(groupId);
        UserDao.dao.updateUser(user);
        response.sendRedirect("/app/user/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = UserDao.dao.readUser(userId);
        request.setAttribute("user", user);
        List<Group> groups = GroupDao.dao.findAllUsersGroups();
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/app/user/editUser.jsp").forward(request, response);
    }
}

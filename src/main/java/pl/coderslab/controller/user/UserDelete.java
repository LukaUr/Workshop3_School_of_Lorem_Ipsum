package pl.coderslab.controller.user;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/user/delete")
public class UserDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDao.dao.deleteUser(userId);
        response.sendRedirect("/app/user/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = UserDao.dao.readUser(userId);
        request.setAttribute("user", user);
        Group group = GroupDao.dao.readUsersGroup(user.getGroupId());
        request.setAttribute("group", group);
        getServletContext().getRequestDispatcher("/app/user/deleteUser.jsp").forward(request, response);
    }
}

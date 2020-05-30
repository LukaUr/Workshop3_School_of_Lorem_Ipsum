package pl.coderslab.controller.user;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;
import pl.coderslab.model.UsersGroup;
import pl.coderslab.model.UsersGroupDao;

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
        UserDao dao = new UserDao();
        dao.deleteUser(userId);
        response.sendRedirect("/app/user/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDao dao = new UserDao();
        User user = dao.readUser(userId);
        request.setAttribute("user", user);
        UsersGroupDao groupdao = new UsersGroupDao();
        UsersGroup group = groupdao.readUsersGroup(user.getUser_group_id());
        request.setAttribute("group", group);
        getServletContext().getRequestDispatcher("/app/user/deleteUser.jsp").forward(request, response);
    }
}

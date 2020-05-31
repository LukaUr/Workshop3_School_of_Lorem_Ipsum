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
import java.util.List;

@WebServlet("/app/user/add")
public class UserAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        User user = new User(userName, email, password, groupId);
        UserDao.dao.createUser(user);
        response.sendRedirect("/app/user/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Group> groups = GroupDao.dao.findAllUsersGroups();
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/app/user/addUser.jsp").forward(request, response);
    }
}

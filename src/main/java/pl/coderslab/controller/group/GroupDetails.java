package pl.coderslab.controller.group;

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

@WebServlet("/app/group/details")
public class GroupDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));
        Group group = GroupDao.dao.readUsersGroup(groupId);
        List<User> users = UserDao.dao.findAllUsersByGroupId(groupId);
        request.setAttribute("users", users);
        request.setAttribute("group", group);
        getServletContext().getRequestDispatcher("/app/group/groupDetails.jsp").forward(request, response);
    }
}

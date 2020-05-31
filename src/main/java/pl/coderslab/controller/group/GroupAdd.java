package pl.coderslab.controller.group;

import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/group/add")
public class GroupAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Group newGroup = new Group();
        String groupName = request.getParameter("groupName");
        newGroup.setName(groupName);
        GroupDao.dao.createUserGroup(newGroup);
        response.sendRedirect("/app/group/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/app/group/addGroup.jsp").forward(request, response);
    }
}

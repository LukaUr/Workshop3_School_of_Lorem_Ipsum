package pl.coderslab.controller.group;

import pl.coderslab.model.UsersGroup;
import pl.coderslab.model.UsersGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/group/add")
public class GroupAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersGroupDao dao = new UsersGroupDao();
        UsersGroup newGroup = new UsersGroup();
        String groupName = request.getParameter("groupName");
        newGroup.setName(groupName);
        dao.createUserGroup(newGroup);
        response.sendRedirect("/app/group/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/app/group/addGroup.jsp").forward(request, response);
    }
}

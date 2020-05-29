package pl.coderslab.controller.group;

import pl.coderslab.model.UsersGroup;
import pl.coderslab.model.UsersGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/group/delete")
public class GroupDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));
        UsersGroupDao dao = new UsersGroupDao();
        dao.deleteUsersGroup(groupId);
        response.sendRedirect("/app/group/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));
        UsersGroupDao dao = new UsersGroupDao();
        UsersGroup group = dao.readUsersGroup(groupId);
        request.setAttribute("group", group);
        getServletContext().getRequestDispatcher("/app/group/deleteGroup.jsp").forward(request, response);
    }
}

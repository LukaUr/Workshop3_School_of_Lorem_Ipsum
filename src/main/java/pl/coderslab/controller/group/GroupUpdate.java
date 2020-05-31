package pl.coderslab.controller.group;

import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/group/update")
public class GroupUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));
        String groupName = request.getParameter("groupName");
        Group group = new Group();
        group.setId(groupId);
        group.setName(groupName);
        GroupDao.dao.updateUsersGroup(group);
        response.sendRedirect("/app/group/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));
        Group group = GroupDao.dao.readUsersGroup(groupId);
        request.setAttribute("group", group);
        getServletContext().getRequestDispatcher("/app/group/editGroup.jsp").forward(request, response);
    }
}

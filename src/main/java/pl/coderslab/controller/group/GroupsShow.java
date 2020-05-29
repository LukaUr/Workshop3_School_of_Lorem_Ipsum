package pl.coderslab.controller.group;

import pl.coderslab.model.UsersGroup;
import pl.coderslab.model.UsersGroupDao;
import pl.coderslab.utils.AppConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/group/groups")
public class GroupsShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersGroupDao dao = new UsersGroupDao();
        List<UsersGroup> groups = dao.findAllUsersGroups();
        request.setAttribute("groups", groups);
        request.setAttribute("number", getServletContext().getInitParameter(AppConfig.NUMBER_OF_SOLUTIONS_KEY_CODE));
        getServletContext().getRequestDispatcher("/app/group/groups.jsp").forward(request, response);
    }
}

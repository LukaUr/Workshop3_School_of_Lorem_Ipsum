package pl.coderslab.controller.misc;

import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/daotest")
public class DaoTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupDao dao = new GroupDao();
        List<Group> allUsersGroups = dao.findAllUsersGroups();
        request.setAttribute("groups", allUsersGroups);
        getServletContext().getRequestDispatcher("/groups.jsp").forward(request, response);
    }
}

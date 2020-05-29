package pl.coderslab.controller;

import pl.coderslab.model.UsersGroup;
import pl.coderslab.model.UsersGroupDao;

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
        UsersGroupDao dao = new UsersGroupDao();
        List<UsersGroup> allUsersGroups = dao.findAllUsersGroups();
        request.setAttribute("groups", allUsersGroups);
        getServletContext().getRequestDispatcher("/groups.jsp").forward(request, response);
    }
}

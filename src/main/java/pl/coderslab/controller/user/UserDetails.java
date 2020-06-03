package pl.coderslab.controller.user;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/user/details")
public class UserDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = UserDao.dao.readUser(userId);
        request.setAttribute("user", user);
        List<Solution> solutions = SolutionDao.dao.findAllByUserId(userId);
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/app/user/detailsUser.jsp").forward(request, response);
    }
}

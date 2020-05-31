package pl.coderslab.controller.user;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;
import pl.coderslab.model.UsersGroup;
import pl.coderslab.model.UsersGroupDao;
import pl.coderslab.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/user/details")
public class UserDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.getUserFromParameter(request);
        getServletContext().getRequestDispatcher("/app/user/detailsUser.jsp").forward(request, response);
    }
}

package pl.coderslab.controller.misc;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;
import pl.coderslab.utils.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String logging = request.getParameter("logging");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if (logging.equals("Log in as teacher")) {
            if (email.equals(Teacher.name) && BCrypt.checkpw(password, Teacher.password)) {
                session.setAttribute("loggedTeacher", true);
                response.sendRedirect("/teacher");
            } else {
                String message = "Invalid email or password. You are not logged.";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {

            User user = UserDao.dao.readUserByEmail(email);
            if (user != null && BCrypt.checkpw(password, user.getPassword())) {
                session.setAttribute("loggedUser", user);
                session.setAttribute("logged", true);
                response.sendRedirect("/student");

            } else {
                String message = "Invalid email or password. You are not logged.";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}


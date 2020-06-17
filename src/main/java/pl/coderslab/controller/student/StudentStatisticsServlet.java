package pl.coderslab.controller.student;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/statistics")
public class StudentStatisticsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getAttribute("loggedUser");
        List<Solution> solutions = SolutionDao.dao.findAllByUserId(user.getId());
        int countAll = solutions.size();
        int countSolved = 0;
        for (Solution solution : solutions) {
            if (solution.getUpdated() != null) {
                countSolved++;
            }
        }
        request.setAttribute("countAll", countAll);
        request.setAttribute("countSolved", countSolved);
        getServletContext().getRequestDispatcher("/student/statistics.jsp").forward(request, response);
    }
}

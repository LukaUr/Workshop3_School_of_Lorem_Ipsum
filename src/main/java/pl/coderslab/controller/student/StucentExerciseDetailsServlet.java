package pl.coderslab.controller.student;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/exerciseDetails")
public class StucentExerciseDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int solutionId = Integer.parseInt(request.getParameter("id"));
        Solution solution = SolutionDao.dao.readSolution(solutionId);
        request.setAttribute("solution", solution);
        getServletContext().getRequestDispatcher("/student/exerciseDetails.jsp").forward(request, response);
    }
}

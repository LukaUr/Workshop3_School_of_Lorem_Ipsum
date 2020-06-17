package pl.coderslab.controller.student;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet("/student/solve")
public class SolveExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int solutionId = Integer.parseInt(request.getParameter("solutionId"));
        String description = request.getParameter("description");
        Solution solution = SolutionDao.dao.readSolution(solutionId);
        solution.setDescription(description);
        solution.setUpdated(Date.valueOf(LocalDate.now()));
        SolutionDao.dao.updateSolution(solution);
        response.sendRedirect("/student/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int solutionId = Integer.parseInt(request.getParameter("id"));
        Solution solution = SolutionDao.dao.readSolution(solutionId);
        request.setAttribute("solution", solution);
        getServletContext().getRequestDispatcher("/student/solve.jsp").forward(request, response);
    }
}

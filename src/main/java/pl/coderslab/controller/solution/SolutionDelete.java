package pl.coderslab.controller.solution;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;
import pl.coderslab.utils.AdmUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/solution/delete")
public class SolutionDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int solutionId = Integer.parseInt(request.getParameter("id"));
        SolutionDao.dao.deleteSolution(solutionId);
        response.sendRedirect("/app/solution/solutions");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int solutionId = Integer.parseInt(request.getParameter("id"));
        Solution solution = SolutionDao.dao.readSolution(solutionId);
        solution.setDescription(AdmUtils.trimmer(solution.getDescription(), 30));
        request.setAttribute("solution", solution);
        getServletContext().getRequestDispatcher("/app/solution/solutionDelete.jsp").forward(request, response);
    }
}

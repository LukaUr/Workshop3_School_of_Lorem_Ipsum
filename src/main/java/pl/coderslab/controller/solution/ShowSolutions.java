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
import java.util.List;

@WebServlet("/app/solution/solutions")
public class ShowSolutions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Solution> solutions = SolutionDao.dao.findAllSolutions();
        for (Solution solution : solutions) {
            solution.setExerciseTitle(AdmUtils.trimmer(solution.getExerciseTitle(), 20));
            solution.setUserName(AdmUtils.trimmer(solution.getUserName(), 30));
            solution.setDescription(AdmUtils.trimmer(solution.getDescription(), 20));

        }
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/app/solution/showSolutions.jsp").forward(request, response);
    }
}

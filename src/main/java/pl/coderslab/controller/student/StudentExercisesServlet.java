package pl.coderslab.controller.student;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;
import pl.coderslab.model.User;
import pl.coderslab.utils.AdmUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/exercises")
public class StudentExercisesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getAttribute("loggedUser");
        List<Solution> solutions = SolutionDao.dao.findAllByUserId(user.getId());
        for (Solution solution : solutions) {
            solution.setExerciseTitle(AdmUtils.trimmer(solution.getExerciseTitle(), 20));
            solution.setDescription(AdmUtils.trimmer(solution.getDescription(), 20));
        }
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/student/exercises.jsp").forward(request, response);
    }
}

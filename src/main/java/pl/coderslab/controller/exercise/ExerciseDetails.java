package pl.coderslab.controller.exercise;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.ExerciseDao;
import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/exercise/details")
public class ExerciseDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("id"));
        Exercise exercise = ExerciseDao.dao.readExercise(exerciseId);
        request.setAttribute("exercise", exercise);
        List<Solution> solutions = SolutionDao.dao.findAllByExerciseId(exerciseId);
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/app/exercise/exerciseDetails.jsp").forward(request, response);
    }
}

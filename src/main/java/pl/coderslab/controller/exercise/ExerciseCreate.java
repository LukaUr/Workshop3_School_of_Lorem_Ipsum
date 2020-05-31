package pl.coderslab.controller.exercise;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/exercise/add")
public class ExerciseCreate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Exercise exercise = new Exercise(title, description);
        ExerciseDao.dao.createExercise(exercise);
        response.sendRedirect("/app/exercise/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
getServletContext().getRequestDispatcher("/app/exercise/addExercise.jsp").forward(request, response);
    }
}

package pl.coderslab.controller.exercise;

import pl.coderslab.model.*;
import pl.coderslab.utils.AdmUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/exercise/exercises")
public class ShowExercises extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseDao dao = new ExerciseDao();
        List<Exercise> allExercises = dao.findAllExercises();
        for (Exercise exercise : allExercises) {
            exercise.setDescription(AdmUtils.trimmer(exercise.getDescription(), 50));
            exercise.setTitle((AdmUtils.trimmer(exercise.getTitle(), 20)));
        }
        request.setAttribute("exercises", allExercises);
        getServletContext().getRequestDispatcher("/app/exercise/exercises.jsp").forward(request, response);
    }
}


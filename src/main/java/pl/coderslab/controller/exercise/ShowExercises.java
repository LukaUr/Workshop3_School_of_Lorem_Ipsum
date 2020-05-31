package pl.coderslab.controller.exercise;

import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/exercise/exercises")
public class ShowExercises extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseDao dao = new ExerciseDao();
        Exercise[] allExercises = dao.findAllExercises();
        for (Exercise exercise : allExercises) {
            if(exercise.getDescription().length() > 50)
            exercise.setDescription(exercise.getDescription().substring(0, 47) + "...");
        }
        request.setAttribute("exercises", allExercises);
        getServletContext().getRequestDispatcher("/app/exercise/exercises.jsp").forward(request, response);
    }
}


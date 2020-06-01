package pl.coderslab.controller.exercise;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/exercise/edit")
public class ExerciseUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("id"));
        Exercise exercise = ExerciseDao.dao.readExercise(exerciseId);
        exercise.setTitle(request.getParameter("title"));
        exercise.setDescription((request.getParameter("description")));
        ExerciseDao.dao.updateExercise(exercise);
        response.sendRedirect("/app/exercise/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("id"));
        Exercise exercise = ExerciseDao.dao.readExercise(exerciseId);
        request.setAttribute("exercise", exercise);
        getServletContext().getRequestDispatcher("/app/exercise/editExercise.jsp").forward(request, response);
    }
}

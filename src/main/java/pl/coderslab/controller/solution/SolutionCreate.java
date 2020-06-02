package pl.coderslab.controller.solution;

import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/solution/add")
public class SolutionCreate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("exercise"));
        int userId = Integer.parseInt(request.getParameter("user"));
        Solution solution = new Solution();
        solution.setExerciseId(exerciseId);
        solution.setUserId(userId);
        SolutionDao.dao.createSolution(solution);
        response.sendRedirect("/app/solution/solutions");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exercise> exercises = ExerciseDao.dao.findAllExercises();
        request.setAttribute("exercises", exercises);
        List<User> users = UserDao.dao.findAllUsers();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/app/solution/addSolution.jsp").forward(request, response);

    }
}

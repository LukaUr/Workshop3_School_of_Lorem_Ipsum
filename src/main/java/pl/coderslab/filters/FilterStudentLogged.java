package pl.coderslab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/student/*")
public class FilterStudentLogged implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        Object loggedStudent = session.getAttribute("logged");
        if (loggedStudent != null && (boolean) loggedStudent) {
            request.setAttribute("loggedUser", session.getAttribute("loggedUser"));
            chain.doFilter(req, resp);
        } else {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("/");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

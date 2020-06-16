package pl.coderslab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter(urlPatterns = {"/app/*", "/teacher/*"})
public class FilterAdminLogged implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        Object loggedAdmin = session.getAttribute("loggedTeacher");
        if (loggedAdmin != null && (boolean) loggedAdmin) {
            chain.doFilter(req, resp);
        } else {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("/");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

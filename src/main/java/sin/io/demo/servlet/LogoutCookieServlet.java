package sin.io.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/logout-cookie"})
public class LogoutCookieServlet extends HttpServlet {
  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Cookie c = new Cookie("username", "");
    c.setMaxAge(0);                        
    c.setPath(req.getContextPath());      
    resp.addCookie(c);

    resp.sendRedirect(req.getContextPath() + "/Login.html");
  }
}

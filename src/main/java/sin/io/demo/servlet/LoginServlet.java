package sin.io.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");
    String user = req.getParameter("username");
    String pass = req.getParameter("password");

    if (user != null && !user.isBlank()) {

      Cookie cookie = new Cookie("username", user);
      cookie.setMaxAge(7 * 24 * 60 * 60); 
      cookie.setHttpOnly(true);           
      cookie.setSecure(req.isSecure());   
      cookie.setPath(req.getContextPath());
      resp.addCookie(cookie);

      resp.sendRedirect(req.getContextPath() + "/hello");
    } else {
      resp.sendRedirect(req.getContextPath() + "/Login.html");
    }
  }
}

package sin.io.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();

    String name = "";
    Cookie[] cookies = req.getCookies(); 
    if (cookies != null) {
      for (Cookie c : cookies) {
        if ("username".equals(c.getName())) {
          name = c.getValue();
          break;
        }
      }
    }

    if (name == null || name.isBlank()) {
      resp.sendRedirect(req.getContextPath() + "/Login.html");
      return;
    }

    out.println("Xin chào " + name);
    out.println("<br/><a href='"+req.getContextPath()+"/logout-cookie'>Logout (xóa cookie)</a>");
  }
}

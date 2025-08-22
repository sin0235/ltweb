package sin.io.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {
  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();

    HttpSession session = req.getSession(false); // không tạo mới
    String name = (session != null) ? (String) session.getAttribute("name") : null;

    if (name == null) {
      resp.sendRedirect(req.getContextPath() + "/Login.html");
      return;
    }

    out.println("<h2>Chào bạn, " + name + "</h2>");
    out.println("<p>Đây là trang sau khi Login bằng Session.</p>");
    out.println("<a href='"+req.getContextPath()+"/logout'>Logout</a>");
  }
}

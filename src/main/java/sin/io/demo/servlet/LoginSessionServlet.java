package sin.io.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login-session"})
public class LoginSessionServlet extends HttpServlet {
  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");
    String user = req.getParameter("username");
    String pass = req.getParameter("password");

    // Ví dụ đúng slide (thường slide demo user: "trungnh", pass: "123")
    boolean ok = "trungnh".equals(user) && "123".equals(pass);

    if (ok) {
      HttpSession session = req.getSession(); // tạo/lấy session (slide: getSession)
      session.setAttribute("name", user);     // lưu thông tin (slide)
      // session.setMaxInactiveInterval(30*60); // (tuỳ chọn) timeout 30 phút
      resp.sendRedirect(req.getContextPath() + "/profile");
    } else {
      resp.sendRedirect(req.getContextPath() + "/Login.html");
    }
  }
}

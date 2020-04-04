package servlets;

import model.service.UserService;
import model.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_user")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));

        UserService userService = new UserServiceImpl();
        userService.deleteUser(id);

        resp.sendRedirect("/users");
    }
}

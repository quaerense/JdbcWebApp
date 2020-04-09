package servlet;

import model.entity.User;
import model.service.UserService;
import model.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit_user")
public class SendEditUserFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.getUserById(id);

        req.setAttribute("user", user);

        req.getRequestDispatcher("/jsp/edit.jsp").forward(req, resp);
    }
}

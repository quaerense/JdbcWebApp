package servlets;

import model.entity.User;
import model.service.UserService;
import model.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String email = req.getParameter("email");

        UserService userService = new UserServiceImpl();
        userService.editUser(id, new User(fname, lname, email));

        resp.sendRedirect("/users");
    }
}

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

@WebServlet("/search_user")
public class SearchUserByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int id;

        if (!req.getParameter("id").equals("") || !req.getParameter("id").isEmpty()) {
            id = Integer.parseInt(req.getParameter("id"));
        } else {
            id = -1;
        }

        UserService userService = new UserServiceImpl();
        User user = userService.getUserById(id);

        if (user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/jsp/get.jsp").forward(req, resp);
        } else {
            req.setAttribute("id", id);
            req.getServletContext().getRequestDispatcher("/error").forward(req, resp);
        }
    }

}

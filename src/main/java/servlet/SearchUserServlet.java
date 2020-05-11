package servlet;

import model.dao.UserDao;
import model.dao.UserDaoImpl;
import model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchUserServlet extends HttpServlet {
    private UserDao dao;

    @Override
    public void init() {
        dao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;

        if (!req.getParameter("id").equals("") || !req.getParameter("id").isEmpty()) {
            id = Integer.parseInt(req.getParameter("id"));
        } else {
            id = -1;
        }

        User user = dao.getUserById(id);

        if (user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/jsp/get.jsp").forward(req, resp);
        } else {
            req.setAttribute("id", id);
            req.getServletContext().getRequestDispatcher("/error").forward(req, resp);
        }
    }

}

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

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    private int id;
    private UserDao dao;

    @Override
    public void init() {
        dao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        id = Integer.parseInt(req.getParameter("id"));
        User user = dao.getUserById(id);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/jsp/delete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        dao.deleteUser(id);

        resp.sendRedirect(req.getContextPath() + "/users");
    }
}

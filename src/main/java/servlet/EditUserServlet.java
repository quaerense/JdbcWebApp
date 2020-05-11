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

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
    private int id;
    private UserDao dao;

    @Override
    public void init() {
        dao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));
        User user = dao.getUserById(id);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/jsp/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String email = req.getParameter("email");

        dao.editUser(id, new User(fname, lname, email));

        resp.sendRedirect(req.getContextPath() + "/users");
    }
}

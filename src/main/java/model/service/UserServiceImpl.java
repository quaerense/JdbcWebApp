package model.service;

import model.dao.UserDao;
import model.dao.UserDaoImpl;
import model.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void editUser(int id, User user) {
        userDao.editUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}

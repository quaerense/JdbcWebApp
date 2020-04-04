package model.service;

import model.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    void editUser(int id, User user);

    void deleteUser(int id);
}

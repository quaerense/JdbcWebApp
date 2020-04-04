package model.dao;

import connection.JdbcConnection;
import connection.MySqlJdbcConnection;
import model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcConnection jdbcConnection = new MySqlJdbcConnection();

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (fname, lname, email) VALUES (?, ?, ?)";

        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getFname());
            statement.setString(2, user.getLname());
            statement.setString(3, user.getEmail());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();

        try (Connection connection = jdbcConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fname = resultSet.getString(2);
                String lname = resultSet.getString(3);
                String email = resultSet.getString(4);

                userList.add(new User(id, fname, lname, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        User user = null;

        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            String fname = resultSet.getString(2);
            String lname = resultSet.getString(3);
            String email = resultSet.getString(4);

            user = new User(id, fname, lname, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void editUser(int id, User user) {
        String sql = "UPDATE users SET fname = ?, lname = ?, email = ? WHERE user_id = ?";

        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getFname());
            statement.setString(2, user.getLname());
            statement.setString(3, user.getEmail());
            statement.setInt(4, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

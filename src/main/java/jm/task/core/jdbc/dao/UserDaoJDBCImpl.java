package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE user(Id INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(40), LastName VARCHAR(40), age SMALLINT)";
        try(Statement statement = Util.getConnection().createStatement()){
            statement.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void dropUsersTable() {
        String sql = "DROP TABLE user";
        try(Statement statement = Util.getConnection().createStatement()){
            statement.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO user(NAME, LASTNAME, AGE) VALUES (?, ?, ?)";
        try(PreparedStatement preparedStatement = Util.getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM user WHERE Id IS ?";

        try(PreparedStatement preparedStatement = Util.getConnection().prepareStatement(sql)){
            preparedStatement.setLong(1, id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}

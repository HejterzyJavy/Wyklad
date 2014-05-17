package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import util.DbUtil;

public class UserDao {
    private Connection connection;

    public UserDao() {
        connection = DbUtil.getConnection();
    }

    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into users(login,haslo,adres,kod_pocztowy,telefon,imie,nazwisko,pesel,dob,email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getHaslo());
            preparedStatement.setString(3, user.getAdres());
            preparedStatement.setString(4, user.getKodPocztowy());
            preparedStatement.setString(5, user.getTelefon());
            preparedStatement.setString(6, user.getImie());
            preparedStatement.setString(7, user.getNazwisko());
            preparedStatement.setString(8, user.getPesel());
            preparedStatement.setDate(9, new java.sql.Date(user.getDob().getTime()));
            preparedStatement.setString(10, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where userid=?");

                // Parameters start with 1  
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set imie=?, nazwisko=?, dob=?, email=?"
                            + "where userid=?");

            preparedStatement.setString(1, user.getImie());
            preparedStatement.setString(2, user.getNazwisko());
            preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getUserid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setUserid(rs.getInt("userid"));
                user.setImie(rs.getString("imie"));
                user.setNazwisko(rs.getString("nazwisko"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(int userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where userid=?");

            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setUserid(rs.getInt("userid"));
                user.setImie(rs.getString("imie"));
                user.setNazwisko(rs.getString("nazwisko"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public int jakieId(String login, String haslo)
    {
        int jakieId=0;
            try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                if (rs.getString("login").equals(login) && rs.getString("haslo").equals(haslo))
                {
                    jakieId=rs.getInt("userid");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jakieId;
    }
    
    public int zaloguj(String login,String haslo) {
        List<User> users = new ArrayList<User>();
        int jakieStanowisko=-1;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                if (rs.getString("login").equals(login) && rs.getString("haslo").equals(haslo))
                {
                    jakieStanowisko=rs.getInt("stanowisko");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jakieStanowisko;
    }
}

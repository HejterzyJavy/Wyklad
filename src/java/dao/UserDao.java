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
                    .prepareStatement("insert into users(userid,login,haslo,adres,kod_pocztowy,telefon,imie,nazwisko,pesel,dob,email,stanowisko) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,? )");
            preparedStatement.setInt(1, getLastId());           
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getHaslo());
            preparedStatement.setString(4, user.getAdres());
            preparedStatement.setString(5, user.getKodPocztowy());
            preparedStatement.setString(6, user.getTelefon());
            preparedStatement.setString(7, user.getImie());
            preparedStatement.setString(8, user.getNazwisko());
            preparedStatement.setString(9, user.getPesel());
            preparedStatement.setDate(10, new java.sql.Date(user.getDob().getTime()));
            preparedStatement.setString(11, user.getEmail());
            preparedStatement.setInt(12, 0);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        public Integer getLastId() {
        Integer lastId = new Integer(0);
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                lastId = rs.getInt("userid");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        lastId++;
        return lastId;
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
    
    public boolean sprawdzLogin (String login)
    {
        boolean sprawdzLogin=false;
        String loginBaza=new String();
            try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                loginBaza=rs.getString("login");
              if(loginBaza.equalsIgnoreCase(login))
              {
                  sprawdzLogin=true;
                  break;
              }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sprawdzLogin;
    }
    
        public boolean sprawdzEmail (String email)
    {
        boolean sprawdzEmail=false;
        String emailBaza=new String();
            try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                emailBaza=rs.getString("email");
              if(emailBaza.equalsIgnoreCase(email))
              {
                  sprawdzEmail=true;
                  break;
              }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sprawdzEmail;
    }
    
    public String getPasswordByLogin (String login)
    {
        String haslo=new String();
        String podanyLogin=login;
        String loginBaza=new String();
        
                 try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                loginBaza=rs.getString("login");
              if(podanyLogin.equals(loginBaza))
              {
                  haslo=rs.getString("haslo");;
                  break;
              }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return haslo;
    }
   
       public boolean sprawdzHaslo (String haslo)
    {
        boolean sprawdzHaslo=false;
        String hasloBaza=new String();
            try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                hasloBaza=rs.getString("haslo");
              if(hasloBaza.equalsIgnoreCase(haslo))
              {
                  sprawdzHaslo=true;
                  break;
              }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sprawdzHaslo;
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

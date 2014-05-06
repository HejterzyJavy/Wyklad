/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Rent;
import model.User;
import util.DbUtil;

/**
 *
 * @author Adrian
 */
//asdasdas
public class RentDao {

       private Connection connection;

    public RentDao() {
        connection = DbUtil.getConnection();
    }
    
    
            public void addRent(Rent rent) {   
            //Integer id=getLastId();
        try {
 
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into wypozyczenie(id_wypozyczenie,id,userid,do_zaplaty,data_wypozyczenia,data_zwrotu,status,opis) values (?, ?, ?, ?, ?, ?,?,?)");
            
            preparedStatement.setInt(1,rent.getIdWypozyczenie());
            preparedStatement.setInt(2, rent.getIdSamochod());
            preparedStatement.setInt(3, rent.getIdUser());
            preparedStatement.setLong(4, rent.getDoZaplaty());
            preparedStatement.setDate(5, new java.sql.Date(rent.getDataWypozyczenia().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(rent.getDataZwrotu().getTime()));
            preparedStatement.setString(7, rent.getStatus());
            preparedStatement.setString(8, rent.getOpis());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        
                  public List<Rent> getAllRents() {

        List<Rent> rents= new ArrayList<Rent>();
        //sdfsd
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from wypozyczenie");

            while (rs.next()) {

                Rent rent = new Rent();
                rent.setIdWypozyczenie(rs.getInt("id_wypozyczenie"));
                rent.setIdSamochod(rs.getInt("id"));
                rent.setIdUser(rs.getInt("userid"));
                rent.setDoZaplaty(rs.getInt("do_zaplaty"));
                rent.setDataWypozyczenia(rs.getDate("data_wypozyczenia"));
                rent.setDataZwrotu(rs.getDate("data_zwrotu"));
                rent.setStatus(rs.getString("status"));
                rent.setOpis(rs.getString("opis"));
      
                rents.add(rent);
            }
            
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return rents;
    }
            
                  
                  
                  
        public List<Rent> getDontAcceptRents() {

        List<Rent> rents= new ArrayList<Rent>();
        //sdfsd
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from wypozyczenie");

            while (rs.next()) {

                Rent rent = new Rent();
                rent.setIdWypozyczenie(rs.getInt("id_wypozyczenie"));
                rent.setIdSamochod(rs.getInt("id"));
                rent.setIdUser(rs.getInt("userid"));
                rent.setDoZaplaty(rs.getInt("do_zaplaty"));
                rent.setDataWypozyczenia(rs.getDate("data_wypozyczenia"));
                rent.setDataZwrotu(rs.getDate("data_zwrotu"));
                rent.setStatus(rs.getString("status"));
                rent.setOpis(rs.getString("opis"));
                
                if(rent.getStatus().equalsIgnoreCase("oczekujace"))
                rents.add(rent);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return rents;
    }
         
        
        
            public Rent getRentById(int rentId) {

        Rent rent = new Rent();

        try {

            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from wypozyczenie where id_wypozyczenie=?");

            preparedStatement.setInt(1, rentId);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                rent.setIdWypozyczenie(rs.getInt("id_wypozyczenie"));
                rent.setIdSamochod(rs.getInt("id"));
                rent.setIdUser(rs.getInt("userid"));
                rent.setDoZaplaty(rs.getInt("do_zaplaty"));
                rent.setDataWypozyczenia(rs.getDate("data_wypozyczenia"));
                rent.setDataZwrotu(rs.getDate("data_zwrotu"));
                rent.setStatus(rs.getString("status"));
                rent.setOpis(rs.getString("opis"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return rent;

    }
        
        
            
        
           public List<Rent> getAcceptRents( List<Car> cars,List<User> users) {

        List<Rent> rents= new ArrayList<Rent>();
        //sdfsd
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from wypozyczenie");

            while (rs.next()) {

                Rent rent = new Rent();
                rent.setIdWypozyczenie(rs.getInt("id_wypozyczenie"));
                rent.setIdSamochod(rs.getInt("id"));
                rent.setIdUser(rs.getInt("userid"));
                rent.setDoZaplaty(rs.getInt("do_zaplaty"));
                rent.setDataWypozyczenia(rs.getDate("data_wypozyczenia"));
                rent.setDataZwrotu(rs.getDate("data_zwrotu"));
                rent.setStatus(rs.getString("status"));
                rent.setOpis(rs.getString("opis"));
                
                if(rent.getStatus().equalsIgnoreCase("oczekujace"))
                {
                    for (int i=0;i<users.size();i++)
                    {
                        if(users.get(i).getUserid()==rent.getIdUser())
                        {
                        rent.setTmpImie(users.get(i).getImie());
                        rent.setTmpNazwisko(users.get(i).getNazwisko());
                        }
                    }        
                    
                      for (int i=0;i<cars.size();i++)
                    {
                        if(cars.get(i).getId()==rent.getIdSamochod())
                        {
                        rent.setTmpMarka(cars.get(i).getMarka());
                        rent.setTmpModel(cars.get(i).getModel());
                        }
                        
                        }  
                    
                            
                    rents.add(rent);
                
                }
                
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return rents;
    }
        
        
        
    public Integer getLastId() {

        Integer lastId = new Integer(0);
        //sdfsd
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from wypozyczenie");
            while (rs.next()) {
                lastId = rs.getInt("id_wypozyczenie");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        lastId++;
        return lastId;
    }         
            
            
                public void acceptRent(Rent rent) {

        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("update wypozyczenie set status=?"
                            + "where id_wypozyczenie=?");

                // Parameters start with 1  
            preparedStatement.setString(1, rent.getStatus());

            preparedStatement.setInt(2, rent.getIdWypozyczenie());
/*
            preparedStatement.setDate(3, new java.sql.Date(rent.getDataWypozyczenia().getTime()));

            preparedStatement.setDate(4, new java.sql.Date(rent.getDataZwrotu().getTime()));

            preparedStatement.setString(5, rent.getStatus());

            preparedStatement.setInt(6, rent.getIdWypozyczenie());
  */          
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
                
                
                    public void updateRent(Rent rent) {

        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("update wypozyczenie set id=?, userid=?, do_zaplaty=?, data_wypozyczenia=?,data_zwrotu=?,status=?,opis=?"
                            + "where id_wypozyczenie=?");

                // Parameters start with 1  
            preparedStatement.setInt(1, rent.getIdSamochod());

            preparedStatement.setInt(2, rent.getIdUser());

            preparedStatement.setLong(3, rent.getDoZaplaty());
            
            preparedStatement.setDate(4, new java.sql.Date(rent.getDataWypozyczenia().getTime()));

            preparedStatement.setDate(5, new java.sql.Date(rent.getDataZwrotu().getTime()));

            preparedStatement.setString(6, rent.getStatus());

            preparedStatement.setString(7, rent.getOpis());
            
            preparedStatement.setInt(8, rent.getIdWypozyczenie());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
                
            
            
}
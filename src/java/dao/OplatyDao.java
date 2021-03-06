/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Oplaty;
import model.User;
import util.DbUtil;

/**
 *
 * @author Adrian
 */
public class OplatyDao {
    
        private Connection connection;

    public OplatyDao() {
        connection = DbUtil.getConnection();
    }

    public void addFee(Oplaty oplaty) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into oplaty(id_oplaty,rozpoczecie_oc,zakonczenie_oc,rozpoczecie_ac,zakonczenie_ac) values (?, ?, ?, ?, ? )");
            preparedStatement.setInt(1, getLastId());
            preparedStatement.setDate(2, new java.sql.Date(oplaty.getRozpoczecieOc().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(oplaty.getZakonczenieOc().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(oplaty.getRozpoczecieAc().getTime()));
            preparedStatement.setDate(5,new java.sql.Date(oplaty.getZakonczenieAc().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    
    
        public Integer getLastId() {
        Integer lastId = new Integer(0);
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from oplaty");
            while (rs.next()) {
                lastId = rs.getInt("id_oplaty");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        lastId++;
        return lastId;
    }
    
        
           public List<Oplaty> getAllFee() {
        List<Oplaty> oplaty = new ArrayList<Oplaty>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from oplaty");
            while (rs.next()) {
                Oplaty oplata = new Oplaty();
                oplata.setIdOplaty(rs.getInt("id_oplaty"));
                oplata.setRozpoczecieOc(rs.getDate("rozpoczecie_oc"));
                oplata.setZakonczenieOc(rs.getDate("zakonczenie_oc"));
                oplata.setRozpoczecieAc(rs.getDate("rozpoczecie_ac"));
                oplata.setZakonczenieAc(rs.getDate("zakonczenie_ac"));
                
                oplaty.add(oplata);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oplaty;
    } 
        
    
           
    public static long ileDoKonca(Date d1, Date d2)
    {
      return Math.round((d2.getTime() - d1.getTime()) / 86400000.0);
    }
           
           
           
               public void deleteFee(int feeId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from oplaty where id_oplaty=?");

            preparedStatement.setInt(1, feeId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
           
           
       public Oplaty getFeeById(int feeId) {
        Oplaty oplata = new Oplaty();

        try {
                PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from oplaty where id_oplaty=?");

            preparedStatement.setInt(1, feeId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                oplata.setIdOplaty(rs.getInt("id_oplaty"));
                oplata.setRozpoczecieOc(rs.getDate("rozpoczecie_oc"));
                oplata.setZakonczenieOc(rs.getDate("zakonczenie_oc"));
                oplata.setRozpoczecieAc(rs.getDate("rozpoczecie_ac"));
                oplata.setZakonczenieAc(rs.getDate("zakonczenie_ac"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return oplata;
    }
    
          public void zmienDateOC(int id, Date nowyPoczatekOc,Date nowyKoniecOc) throws SQLException {
        
        try {  
             PreparedStatement preparedStatement = connection
                    .prepareStatement("update oplaty set rozpoczecie_oc=?,zakonczenie_oc=? where id_oplaty=?");

            preparedStatement.setDate(1,new java.sql.Date(nowyPoczatekOc.getTime()) );
            preparedStatement.setDate(2,new java.sql.Date(nowyKoniecOc.getTime()) );
            preparedStatement.setInt(3, id);
            int rowsAffected = preparedStatement.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
            }
    } 

          
                public void zmienDateAC(int id, Date nowyPoczatekAc,Date nowyKoniecAc) throws SQLException {
        
        try {  
             PreparedStatement preparedStatement = connection
                    .prepareStatement("update oplaty set rozpoczecie_ac=?,zakonczenie_ac=? where id_oplaty=?");

            preparedStatement.setDate(1,new java.sql.Date(nowyPoczatekAc.getTime()) );
            preparedStatement.setDate(2,new java.sql.Date(nowyKoniecAc.getTime()) );
            preparedStatement.setInt(3, id);
            int rowsAffected = preparedStatement.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
            }
    } 
          
          
                     
}

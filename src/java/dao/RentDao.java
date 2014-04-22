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
import java.util.List;
import model.Car;
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
    
}
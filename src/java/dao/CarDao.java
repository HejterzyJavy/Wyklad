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
public class CarDao {

       private Connection connection;

    public CarDao() {
        connection = DbUtil.getConnection();
    }
    
        public void addCar(Car car) {   
        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into samochod(id,marka,model,rocznik,przebieg,pojemnosc_silnika) values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, car.getId().toString());
            preparedStatement.setString(2, car.getMarka());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setInt(4, car.getRocznik());
            preparedStatement.setInt(5, car.getPrzebieg());
            preparedStatement.setString(6, car.getPojemnoscSilnika() );
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
        
        public void deleteCar(int carId) {

        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where id=?");

                // Parameters start with 1  
             preparedStatement.setInt(1, carId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }    
        
       
           public void updateCar(Car car) {

        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("update samochod set marka=?, model=?, rocznik=?, przebieg=?, pojemnosc_silnika=?, cena_doba=?  "
                            + "where id=?");

                // Parameters start with 1  
            preparedStatement.setString(1, car.getMarka());

            preparedStatement.setString(2, car.getModel());

            preparedStatement.setInt(3, car.getRocznik());

            preparedStatement.setInt(4, car.getPrzebieg());

            preparedStatement.setString(5, car.getPojemnoscSilnika());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
           
           
       public List<Car> getAllCars() {

        List<Car> cars = new ArrayList<Car>();
        //sdfsd
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from samochod");

            while (rs.next()) {

                Car car = new Car();
                car.setID(rs.getInt("id"));
                car.setMarka(rs.getString("marka"));
                car.setModel(rs.getString("model"));
                car.setRocznik(rs.getInt("rocznik"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                //car.setCenaDoba(rs.getInt("cena_doba"));
              
                cars.add(car);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return cars;
    }
        
       
       
        public List<Car> getCarByBrand(String carBrand) {

        List<Car> cars = new ArrayList<Car>();

        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from samochod");

            while (rs.next()) {

                Car car = new Car();
                car.setID(rs.getInt("id"));
                car.setMarka(rs.getString("marka"));
                car.setModel(rs.getString("model"));
                car.setRocznik(rs.getInt("rocznik"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                //car.setCenaDoba(rs.getInt("cena_doba"));
                if(car.getMarka().equals(carBrand))
                cars.add(car);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return cars;
    }
       
       
        
            public List<Car> getCarByYearInterval(Integer min,Integer max) {

        List<Car> cars = new ArrayList<Car>();

        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from samochod");

            while (rs.next()) {

                Car car = new Car();
                car.setID(rs.getInt("id"));
                car.setMarka(rs.getString("marka"));
                car.setModel(rs.getString("model"));
                car.setRocznik(rs.getInt("rocznik"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                //car.setCenaDoba(rs.getInt("cena_doba"));
                if(car.getRocznik()>=min && car.getRocznik()<=max)
                cars.add(car);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return cars;
    }
        
        
        
       
       
          public Car getCarById(int carId) {

        Car car = new Car();

        try {

            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from samochod where carId=?");

            preparedStatement.setInt(1, carId);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                
                car.setID(rs.getInt("userid"));
                car.setMarka(rs.getString("marka"));
                car.setModel(rs.getString("model"));
                car.setRocznik(rs.getInt("rocznik"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                car.setCenaDoba(rs.getInt("cena_doba"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return car;
    } 
        
        
}

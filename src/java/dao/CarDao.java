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
            Integer id=getLastId();
        try {
 
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into samochod(id,marka,model,rocznik,rodzaj_paliwa,moc_silnika,przebieg,pojemnosc_silnika,skrzynia_biegow,typ_nadwozia,sciezka_zdjecie,dostepnosc,cena_doba,zdjecie) values (?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?)");
            
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, car.getMarka());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setInt(4, car.getRocznik());
            preparedStatement.setString(5, car.getRodzajPaliwa());
            preparedStatement.setInt(6, car.getMocSilnika());
            preparedStatement.setInt(7, car.getPrzebieg());
            preparedStatement.setString(8, car.getPojemnoscSilnika());
            preparedStatement.setString(9, car.getSkrzyniaBiegow());
            preparedStatement.setString(10, car.getTypNadwozia());
            preparedStatement.setString(11, car.getSciezkaZdjecie());
            preparedStatement.setInt(12, 1);
            preparedStatement.setInt(13, car.getCenaDoba());
            preparedStatement.setBlob(14, car.getZdjecie());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
        
        public void deleteCar(int carId) {

        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from samochod where id=?");

                // Parameters start with 1  
             preparedStatement.setInt(1, carId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }    
        
       
        public void update (int id,Car car)
        {
          
            deleteCar(id);
               
               
                   try {
 
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into samochod(id,marka,model,rocznik,rodzaj_paliwa,moc_silnika,przebieg,pojemnosc_silnika,skrzynia_biegow,typ_nadwozia,sciezka_zdjecie,dostepnosc,cena_doba) values (?,?, ?, ?, ?, ?, ?,?,?,?,?,?,?)");
            
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, car.getMarka());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setInt(4, car.getRocznik());
            preparedStatement.setString(5, car.getRodzajPaliwa());
            preparedStatement.setInt(6, car.getMocSilnika());
            preparedStatement.setInt(7, car.getPrzebieg());
            preparedStatement.setString(8, car.getPojemnoscSilnika());
            preparedStatement.setString(9, car.getSkrzyniaBiegow());
            preparedStatement.setString(10, car.getTypNadwozia());
            preparedStatement.setString(11, car.getSciezkaZdjecie().substring(14, car.getSciezkaZdjecie().length()-4));
            preparedStatement.setInt(12, 1);
            preparedStatement.setInt(13, car.getCenaDoba());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }    
               
               
        }
        
        
           public void updateCar( Car car) {

        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("update samochod set marka=?, model=?, rocznik=?, rodzaj_paliwa=?,moc_silnika=?, przebieg=?, pojemnosc_silnika=?, skrzynia_biegow=?,typ_nadwozia=?,sciezka_zdjecie=?,dostepnosc=?,cena_doba=?"
                            + "where id=?");

                // Parameters start with 1  
            
            
            preparedStatement.setString(1, car.getMarka());

            preparedStatement.setString(2, car.getModel());

            preparedStatement.setInt(3, car.getRocznik());

            preparedStatement.setString(4, car.getRodzajPaliwa());
            
            preparedStatement.setInt(5, car.getMocSilnika());
     
            preparedStatement.setInt(6, car.getPrzebieg());

            preparedStatement.setString(7, car.getPojemnoscSilnika());
            
            preparedStatement.setString(8, car.getSkrzyniaBiegow());
            
            preparedStatement.setString(9, car.getTypNadwozia());
            
            preparedStatement.setString(10, car.getSciezkaZdjecie());
            
            preparedStatement.setInt(11, car.getDostepnosc());
            
            preparedStatement.setInt(12, car.getCenaDoba());
            
            preparedStatement.setInt(13, car.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
           
    
           

    
           
           
           
     public Integer getLastId() {

        Integer lastId = new Integer(0);
        //sdfsd
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from samochod");
            while (rs.next()) {
            lastId=rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        lastId++;
        return lastId;
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
                car.setRodzajPaliwa(rs.getString("rodzaj_paliwa"));
                car.setMocSilnika(rs.getInt("moc_silnika"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                car.setSkrzyniaBiegow(rs.getString("skrzynia_biegow"));
                car.setTypNadwozia(rs.getString("typ_nadwozia"));
                car.setSciezkaZdjecie(rs.getString("sciezka_zdjecie"));
                car.setDostepnosc(rs.getInt("dostepnosc"));
                car.setCenaDoba(rs.getInt("cena_doba"));
                //car.setZdjecie(rs.getB);
                car.setTmp(car.getId());
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
                car.setRodzajPaliwa(rs.getString("rodzaj_paliwa"));
                car.setMocSilnika(rs.getInt("moc_silnika"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                car.setSkrzyniaBiegow(rs.getString("skrzynia_biegow"));
                car.setTypNadwozia(rs.getString("typ_nadwozia"));
                car.setSciezkaZdjecie(rs.getString("sciezka_zdjecie"));
                car.setCenaDoba(rs.getInt("cena_doba"));
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
                car.setRodzajPaliwa(rs.getString("rodzaj_paliwa"));
                car.setMocSilnika(rs.getInt("moc_silnika"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                car.setSkrzyniaBiegow(rs.getString("skrzynia_biegow"));
                car.setTypNadwozia(rs.getString("typ_nadwozia"));
                car.setSciezkaZdjecie(rs.getString("sciezka_zdjecie"));
                car.setCenaDoba(rs.getInt("cena_doba"));
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
                
                car.setID(rs.getInt("id"));
                car.setMarka(rs.getString("marka"));
                car.setModel(rs.getString("model"));
                car.setRocznik(rs.getInt("rocznik"));
                car.setRodzajPaliwa(rs.getString("rodzaj_paliwa"));
                car.setMocSilnika(rs.getInt("moc_silnika"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                car.setSkrzyniaBiegow(rs.getString("skrzynia_biegow"));
                car.setTypNadwozia(rs.getString("typ_nadwozia"));
                car.setSciezkaZdjecie(rs.getString("sciezka_zdjecie"));
                car.setCenaDoba(rs.getInt("cena_doba"));
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return car;
    } 
        
        
}

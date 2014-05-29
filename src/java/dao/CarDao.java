package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Oplaty;
import model.Wyposazenie;
import util.DbUtil;

public class CarDao {

    private Connection connection;
    private OplatyDao oplatydao;
    private WyposazenieDao wyposazeniedao;

    public CarDao() {
        connection = DbUtil.getConnection();
        oplatydao=new OplatyDao();
        wyposazeniedao=new WyposazenieDao();
    }

    public void addCar(Car car,Wyposazenie wyposazenie,Oplaty oplaty) {
        Integer id = getLastId();
        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into samochod(id,id_wyposazenie,id_oplaty,rejestracja,marka,model,rocznik,rodzaj_paliwa,moc_silnika,przebieg,pojemnosc_silnika,skrzynia_biegow,"
                            + "typ_nadwozia,dostepnosc,cena_doba,zdjecie) values (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, wyposazeniedao.getLastId());
            preparedStatement.setInt(3, oplatydao.getLastId());
            preparedStatement.setString(4, car.getRejestracja());
            preparedStatement.setString(5, car.getMarka());
            preparedStatement.setString(6, car.getModel());
            preparedStatement.setInt(7, car.getRocznik());
            preparedStatement.setString(8, car.getRodzajPaliwa());
            preparedStatement.setInt(9, car.getMocSilnika());
            preparedStatement.setInt(10, car.getPrzebieg());
            preparedStatement.setString(11, car.getPojemnoscSilnika());
            preparedStatement.setString(12, car.getSkrzyniaBiegow());
            preparedStatement.setString(13, car.getTypNadwozia());
            preparedStatement.setInt(14, 1);
            preparedStatement.setInt(15, car.getCenaDoba());
            preparedStatement.setBlob(16, car.getZdjecie());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(int carId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from samochod where id=?");
 
            preparedStatement.setInt(1, carId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Car car) {
        deleteCar(id);
        try {
              PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into samochod(id,marka,model,rocznik,rodzaj_paliwa,moc_silnika,przebieg,pojemnosc_silnika,skrzynia_biegow,typ_nadwozia,dostepnosc,cena_doba,zdjecie) values (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?)");

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
            preparedStatement.setInt(11, 1);
            preparedStatement.setInt(12, car.getCenaDoba());
            preparedStatement.setBlob(13, car.getZdjecie());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void zmienPrzebieg(int id, Integer przebieg) throws SQLException {
        String sql = "update samochod set przebieg=? where id=?";
        try {  
             PreparedStatement preparedStatement = connection
                    .prepareStatement("update samochod set przebieg=? where id=?");

            preparedStatement.setInt(1, przebieg);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public void przyjmijSamochod(int id) throws SQLException {
        String sql = "update samochod set przebieg=? where id=?";
        try {  
             PreparedStatement preparedStatement = connection
                    .prepareStatement("update samochod set dostepnosc=? where id=?");

            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
            }
    }
       
    public void wypozyczSamochod(int id) throws SQLException {
        String sql = "update samochod set przebieg=? where id=?"; 
        try {  
             PreparedStatement preparedStatement = connection
                    .prepareStatement("update samochod set dostepnosc=? where id=?");

            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public void updateCar(Car car) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update samochod set marka=?, model=?, rocznik=?, rodzaj_paliwa=?,moc_silnika=?, przebieg=?, pojemnosc_silnika=?, skrzynia_biegow=?,typ_nadwozia=?,sciezka_zdjecie=?,dostepnosc=?,cena_doba=?"
                            + "where id=?");
 
            preparedStatement.setString(1, car.getMarka());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getRocznik());
            preparedStatement.setString(4, car.getRodzajPaliwa());
            preparedStatement.setInt(5, car.getMocSilnika());
            preparedStatement.setInt(6, car.getPrzebieg());
            preparedStatement.setString(7, car.getPojemnoscSilnika());
            preparedStatement.setString(8, car.getSkrzyniaBiegow());
            preparedStatement.setString(9, car.getTypNadwozia());
            preparedStatement.setInt(10, car.getDostepnosc());
            preparedStatement.setInt(11, car.getCenaDoba());
            preparedStatement.setInt(12, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getLastId() {
        Integer lastId = new Integer(0);
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from samochod");
            while (rs.next()) {
                lastId = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        lastId++;
        return lastId;
    }

    public List<String> specifyEquipment(Integer idCar) 
    {
       Integer carId=idCar;
       List<String> Equipment = new ArrayList<String>();
       Car car=new Car();
       car=getCarById(carId);
        System.out.println("TO JEST MIEJSCE W KTORYM JEST BLAD krok wczesniej" +car.getIdWyposazenie());
       Integer idWyposazenie = new Integer(0);
       idWyposazenie=car.getIdWyposazenie();
      
       Equipment=wyposazeniedao.getWyposazenieById(idWyposazenie);   
       
       return Equipment;
    }
    
    
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<Car>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from samochod");
            while (rs.next()) {
                Car car = new Car();
                car.setID(rs.getInt("id"));
                car.setIdOplaty(rs.getInt("id_oplaty"));
                car.setIdWyposazenie(rs.getInt("id_wyposazenie"));
                car.setRejestracja(rs.getString("rejestracja"));
                car.setMarka(rs.getString("marka"));
                car.setModel(rs.getString("model"));
                car.setRocznik(rs.getInt("rocznik"));
                car.setRodzajPaliwa(rs.getString("rodzaj_paliwa"));
                car.setMocSilnika(rs.getInt("moc_silnika"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                car.setSkrzyniaBiegow(rs.getString("skrzynia_biegow"));
                car.setTypNadwozia(rs.getString("typ_nadwozia"));
                car.setDostepnosc(rs.getInt("dostepnosc"));
                car.setCenaDoba(rs.getInt("cena_doba"));
                //car.setZdjecie(rs.ge);
                //car.setZdjecie(rs.getB);
                car.setTmp(car.getId());
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    
    public String getMarki() {
        String marki = new String();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT distinct `marka` FROM `samochod`");
            while (rs.next()) {
                marki =  marki + rs.getString("marka") +",";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marki;
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
                car.setCenaDoba(rs.getInt("cena_doba"));
                if (car.getMarka().equalsIgnoreCase(carBrand)) {
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public List<Car> getCarByYearInterval(Integer min, Integer max) {
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
                car.setCenaDoba(rs.getInt("cena_doba"));
                if (car.getRocznik() >= min && car.getRocznik() <= max) {
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


    
    
    
    
    public List<Car> getDontReturnedCar() {
        List<Car> cars = new ArrayList<Car>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from samochod");
            while (rs.next()) {
                Car car = new Car();
                car.setID(rs.getInt("id"));
                car.setRejestracja(rs.getString("rejestracja"));
                car.setMarka(rs.getString("marka"));
                car.setModel(rs.getString("model"));
                car.setRocznik(rs.getInt("rocznik"));
                car.setRodzajPaliwa(rs.getString("rodzaj_paliwa"));
                car.setMocSilnika(rs.getInt("moc_silnika"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                car.setSkrzyniaBiegow(rs.getString("skrzynia_biegow"));
                car.setTypNadwozia(rs.getString("typ_nadwozia"));
                car.setDostepnosc(rs.getInt("dostepnosc"));
                car.setCenaDoba(rs.getInt("cena_doba"));
                if (car.getDostepnosc()==0) {
                    cars.add(car);
                }
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
                    prepareStatement("select * from samochod where id=?");

            preparedStatement.setInt(1, carId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                car.setID(rs.getInt("id"));
                car.setIdWyposazenie(rs.getInt("id_wyposazenie"));
                car.setIdOplaty(rs.getInt("id_oplaty"));
                car.setMarka(rs.getString("marka"));
                car.setModel(rs.getString("model"));
                car.setRocznik(rs.getInt("rocznik"));
                car.setRodzajPaliwa(rs.getString("rodzaj_paliwa"));
                car.setMocSilnika(rs.getInt("moc_silnika"));
                car.setPrzebieg(rs.getInt("przebieg"));
                car.setPojemnoscSilnika(rs.getString("pojemnosc_silnika"));
                car.setSkrzyniaBiegow(rs.getString("skrzynia_biegow"));
                car.setTypNadwozia(rs.getString("typ_nadwozia"));
                car.setDostepnosc(rs.getInt("dostepnosc"));
                car.setCenaDoba(rs.getInt("cena_doba"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
    
        public List<Car> getListCarById(List<Oplaty> listaOplat ) {
        List<Car> cars = new ArrayList<Car>();
        Car car=new Car();
        
        for (int i=0;i<cars.size();i++)
        {
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from samochod where id_oplaty=?");

            preparedStatement.setInt(1, listaOplat.get(i).getIdOplaty());
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
                car.setDostepnosc(rs.getInt("dostepnosc"));
                car.setCenaDoba(rs.getInt("cena_doba"));
                
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        
        return cars;
    }
    
    
    
    public Blob getCarImage(int carId) {
        Car car = new Car();
        Blob blob = null;
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from samochod where id=?");

            preparedStatement.setInt(1, carId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                blob = rs.getBlob("zdjecie");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blob;
    }
}

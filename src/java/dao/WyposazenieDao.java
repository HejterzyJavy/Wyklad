package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Wyposazenie;
import util.DbUtil;

/*
            wyposazenieId,naped4x4,centralny_zamek,czujnik_deszczu,czujnik_parkowania,el_lusterka
            ,el_szyby,klimatyzacja,komputer_pokladowy,pod_przed_szyba,pod_fotele,radio,system_nawigacji,
            skorzana_tapicerka,tempomat,wsp_kierownicy,kontrola_antyposlizgowa,autoalarm,blok_skrzyni_biegow
            ,esp,immobiliser,poduszki_powietrzne,alufelgi,bagaznik_na_dachu,hak,ksenony,przyc_szyby,
            szyberdach
            */

public class WyposazenieDao {
    private Connection connection;
    
    public WyposazenieDao() {
        connection = DbUtil.getConnection();
    }

    public void addWyposazenie(Wyposazenie wyposazenie) {
        Integer id = getLastId();
        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into samochod(wyposazenieId,naped4x4,centralny_zamek,czujnik_deszczu,czujnik_parkowania,el_lusterka,el_szyby,klimatyzacja,komputer_pokladowy,pod_przed_szyba,pod_fotele,radio,system_nawigacji,skorzana_tapicerka,tempomat,wsp_kierownicy,kontrola_antyposlizgowa,autoalarm,blok_skrzyni_biegow,esp,immobiliser,poduszki_powietrzne,alufelgi,bagaznik_na_dachu,hak,ksenony,przyc_szyby,szyberdach) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, wyposazenie.getNaped4x4());
            preparedStatement.setInt(3, wyposazenie.getCentralny_zamek());
            preparedStatement.setInt(4, wyposazenie.getCzujnik_deszczu());
            preparedStatement.setInt(5, wyposazenie.getCzujnik_parkowania());
            preparedStatement.setInt(6, wyposazenie.getEl_lusterka());
            preparedStatement.setInt(7, wyposazenie.getEl_szyby());
            preparedStatement.setInt(8, wyposazenie.getKlimatyzacja());
            preparedStatement.setInt(9, wyposazenie.getKomputer_pokladowy());
            preparedStatement.setInt(10, wyposazenie.getPod_przed_szyba());
            preparedStatement.setInt(11, wyposazenie.getPod_fotele());
            preparedStatement.setInt(12, wyposazenie.getRadio());
            preparedStatement.setInt(13, wyposazenie.getSystem_nawigacji());
            preparedStatement.setInt(14, wyposazenie.getSkorzana_tapicerka());
            preparedStatement.setInt(15, wyposazenie.getTempomat());
            preparedStatement.setInt(16, wyposazenie.getWsp_kierownicy());
            preparedStatement.setInt(17, wyposazenie.getKontrola_antyposlizgowa());
            preparedStatement.setInt(18, wyposazenie.getAutoalarm());
            preparedStatement.setInt(19, wyposazenie.getBlok_skrzyni_biegow());
            preparedStatement.setInt(20, wyposazenie.getEsp());
            preparedStatement.setInt(21, wyposazenie.getImmobiliser());
            preparedStatement.setInt(22, wyposazenie.getPoduszki_powietrzne());
            preparedStatement.setInt(23, wyposazenie.getAlufelgi());
            preparedStatement.setInt(24, wyposazenie.getBagaznik_na_dachu());
            preparedStatement.setInt(25, wyposazenie.getHak());
            preparedStatement.setInt(26, wyposazenie.getKsenony());
            preparedStatement.setInt(27, wyposazenie.getPrzyc_szyby());
            preparedStatement.setInt(28, wyposazenie.getSzyberdach());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWyposazenie(int wyposazenieId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from wyposazenie where id=?");

            preparedStatement.setInt(1, wyposazenieId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Wyposazenie wyposazenie) {

        deleteWyposazenie(id);
        try {
             PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into samochod(wyposazenieId,naped4x4,centralny_zamek,czujnik_deszczu,czujnik_parkowania,el_lusterka,el_szyby,klimatyzacja,komputer_pokladowy,pod_przed_szyba,pod_fotele,radio,system_nawigacji,skorzana_tapicerka,tempomat,wsp_kierownicy,kontrola_antyposlizgowa,autoalarm,blok_skrzyni_biegow,esp,immobiliser,poduszki_powietrzne,alufelgi,bagaznik_na_dachu,hak,ksenony,przyc_szyby,szyberdach) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, wyposazenie.getNaped4x4());
            preparedStatement.setInt(3, wyposazenie.getCentralny_zamek());
            preparedStatement.setInt(4, wyposazenie.getCzujnik_deszczu());
            preparedStatement.setInt(5, wyposazenie.getCzujnik_parkowania());
            preparedStatement.setInt(6, wyposazenie.getEl_lusterka());
            preparedStatement.setInt(7, wyposazenie.getEl_szyby());
            preparedStatement.setInt(8, wyposazenie.getKlimatyzacja());
            preparedStatement.setInt(9, wyposazenie.getKomputer_pokladowy());
            preparedStatement.setInt(10, wyposazenie.getPod_przed_szyba());
            preparedStatement.setInt(11, wyposazenie.getPod_fotele());
            preparedStatement.setInt(12, wyposazenie.getRadio());
            preparedStatement.setInt(13, wyposazenie.getSystem_nawigacji());
            preparedStatement.setInt(14, wyposazenie.getSkorzana_tapicerka());
            preparedStatement.setInt(15, wyposazenie.getTempomat());
            preparedStatement.setInt(16, wyposazenie.getWsp_kierownicy());
            preparedStatement.setInt(17, wyposazenie.getKontrola_antyposlizgowa());
            preparedStatement.setInt(18, wyposazenie.getAutoalarm());
            preparedStatement.setInt(19, wyposazenie.getBlok_skrzyni_biegow());
            preparedStatement.setInt(20, wyposazenie.getEsp());
            preparedStatement.setInt(21, wyposazenie.getImmobiliser());
            preparedStatement.setInt(22, wyposazenie.getPoduszki_powietrzne());
            preparedStatement.setInt(23, wyposazenie.getAlufelgi());
            preparedStatement.setInt(24, wyposazenie.getBagaznik_na_dachu());
            preparedStatement.setInt(25, wyposazenie.getHak());
            preparedStatement.setInt(26, wyposazenie.getKsenony());
            preparedStatement.setInt(27, wyposazenie.getPrzyc_szyby());
            preparedStatement.setInt(28, wyposazenie.getSzyberdach());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateWyposazenie(Wyposazenie wyposazenie) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update wyposazenie set wyposazenieId=?, naped4x4=?, centralny_zamek=?, czujnik_deszczu=?, czujnik_parkowania=?, el_lusterka=?, el_szyby=?, klimatyzacja=?, komputer_pokladowy=?, pod_przed_szyba=?, pod_fotele=?, radio=?, system_nawigacji=?, skorzana_tapicerka=?, tempomat=?, wsp_kierownicy=?, kontrola_antyposlizgowa=?, autoalarm=?, blok_skrzyni_biegow=?, esp=?, immobiliser=?, poduszki_powietrzne=?, alufelgi=?, bagaznik_na_dachu=?, hak=?, ksenony=?, przyc_szyby=?, szyberdach=?"
                            + "where id=?");

            preparedStatement.setInt(1, wyposazenie.getWyposazenieId());
            preparedStatement.setInt(2, wyposazenie.getNaped4x4());
            preparedStatement.setInt(3, wyposazenie.getCentralny_zamek());
            preparedStatement.setInt(4, wyposazenie.getCzujnik_deszczu());
            preparedStatement.setInt(5, wyposazenie.getCzujnik_parkowania());
            preparedStatement.setInt(6, wyposazenie.getEl_lusterka());
            preparedStatement.setInt(7, wyposazenie.getEl_szyby());
            preparedStatement.setInt(8, wyposazenie.getKlimatyzacja());
            preparedStatement.setInt(9, wyposazenie.getKomputer_pokladowy());
            preparedStatement.setInt(10, wyposazenie.getPod_przed_szyba());
            preparedStatement.setInt(11, wyposazenie.getPod_fotele());
            preparedStatement.setInt(12, wyposazenie.getRadio());
            preparedStatement.setInt(13, wyposazenie.getSystem_nawigacji());
            preparedStatement.setInt(14, wyposazenie.getSkorzana_tapicerka());
            preparedStatement.setInt(15, wyposazenie.getTempomat());
            preparedStatement.setInt(16, wyposazenie.getWsp_kierownicy());
            preparedStatement.setInt(17, wyposazenie.getKontrola_antyposlizgowa());
            preparedStatement.setInt(18, wyposazenie.getAutoalarm());
            preparedStatement.setInt(19, wyposazenie.getBlok_skrzyni_biegow());
            preparedStatement.setInt(20, wyposazenie.getEsp());
            preparedStatement.setInt(21, wyposazenie.getImmobiliser());
            preparedStatement.setInt(22, wyposazenie.getPoduszki_powietrzne());
            preparedStatement.setInt(23, wyposazenie.getAlufelgi());
            preparedStatement.setInt(24, wyposazenie.getBagaznik_na_dachu());
            preparedStatement.setInt(25, wyposazenie.getHak());
            preparedStatement.setInt(26, wyposazenie.getKsenony());
            preparedStatement.setInt(27, wyposazenie.getPrzyc_szyby());
            preparedStatement.setInt(28, wyposazenie.getSzyberdach());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getLastId() {
        Integer lastId = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from wyposazenie");
            while (rs.next()) {
                lastId = rs.getInt("wyposazenieId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lastId++;
        return lastId;
    }

    public List<Wyposazenie> getAllCars() {
        List<Wyposazenie> wyposazeniee = new ArrayList<Wyposazenie>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from wyposazenie");
            while (rs.next()) {
                Wyposazenie wyposazenie = new Wyposazenie();
                wyposazenie.setWyposazenieId(rs.getInt("wyposazenieId"));
                wyposazenie.setNaped4x4(rs.getInt("naped4x4"));
                wyposazenie.setCentralny_zamek(rs.getInt("centralny_zamek"));
                wyposazenie.setCzujnik_deszczu(rs.getInt("czujnik_deszczu"));
                wyposazenie.setCzujnik_parkowania(rs.getInt("czujnik_parkowania"));
                wyposazenie.setEl_lusterka(rs.getInt("el_lusterka"));
                wyposazenie.setEl_szyby(rs.getInt("el_szyby"));
                wyposazenie.setKlimatyzacja(rs.getInt("klimatyzacja"));
                wyposazenie.setKomputer_pokladowy(rs.getInt("komputer_pokladowy"));
                wyposazenie.setPod_przed_szyba(rs.getInt("pod_przed_szyba"));
                wyposazenie.setPod_fotele(rs.getInt("pod_fotele"));
                wyposazenie.setRadio(rs.getInt("radio"));
                wyposazenie.setSystem_nawigacji(rs.getInt("system_nawigacji"));
                wyposazenie.setSkorzana_tapicerka(rs.getInt("skorzana_tapicerka"));
                wyposazenie.setTempomat(rs.getInt("tempomat"));
                wyposazenie.setWsp_kierownicy(rs.getInt("wsp_kierownicy"));
                wyposazenie.setKontrola_antyposlizgowa(rs.getInt("kontrola_antyposlizgowa"));
                wyposazenie.setAutoalarm(rs.getInt("autoalarm"));
                wyposazenie.setBlok_skrzyni_biegow(rs.getInt("blok_skrzyni_biegow"));
                wyposazenie.setEsp(rs.getInt("esp"));
                wyposazenie.setImmobiliser(rs.getInt("immobiliser"));
                wyposazenie.setPoduszki_powietrzne(rs.getInt("poduszki_powietrzne"));
                wyposazenie.setAlufelgi(rs.getInt("alufelgi"));
                wyposazenie.setBagaznik_na_dachu(rs.getInt("bagaznik_na_dachu"));
                wyposazenie.setHak(rs.getInt("hak"));
                wyposazenie.setKsenony(rs.getInt("ksenony"));
                wyposazenie.setPrzyc_szyby(rs.getInt("przyc_szyby"));
                wyposazenie.setSzyberdach(rs.getInt("szyberdach"));
                wyposazeniee.add(wyposazenie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyposazeniee;
    }
    
    public List<Wyposazenie> getCarByBrand(String carBrand) {
        List<Wyposazenie> wyposazeniee = new ArrayList<Wyposazenie>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from wyposazenie");
            while (rs.next()) {
                Wyposazenie wyposazenie = new Wyposazenie();
                wyposazenie.setWyposazenieId(rs.getInt("wyposazenieId"));
                wyposazenie.setNaped4x4(rs.getInt("naped4x4"));
                wyposazenie.setCentralny_zamek(rs.getInt("centralny_zamek"));
                wyposazenie.setCzujnik_deszczu(rs.getInt("czujnik_deszczu"));
                wyposazenie.setCzujnik_parkowania(rs.getInt("czujnik_parkowania"));
                wyposazenie.setEl_lusterka(rs.getInt("el_lusterka"));
                wyposazenie.setEl_szyby(rs.getInt("el_szyby"));
                wyposazenie.setKlimatyzacja(rs.getInt("klimatyzacja"));
                wyposazenie.setKomputer_pokladowy(rs.getInt("komputer_pokladowy"));
                wyposazenie.setPod_przed_szyba(rs.getInt("pod_przed_szyba"));
                wyposazenie.setPod_fotele(rs.getInt("pod_fotele"));
                wyposazenie.setRadio(rs.getInt("radio"));
                wyposazenie.setSystem_nawigacji(rs.getInt("system_nawigacji"));
                wyposazenie.setSkorzana_tapicerka(rs.getInt("skorzana_tapicerka"));
                wyposazenie.setTempomat(rs.getInt("tempomat"));
                wyposazenie.setWsp_kierownicy(rs.getInt("wsp_kierownicy"));
                wyposazenie.setKontrola_antyposlizgowa(rs.getInt("kontrola_antyposlizgowa"));
                wyposazenie.setAutoalarm(rs.getInt("autoalarm"));
                wyposazenie.setBlok_skrzyni_biegow(rs.getInt("blok_skrzyni_biegow"));
                wyposazenie.setEsp(rs.getInt("esp"));
                wyposazenie.setImmobiliser(rs.getInt("immobiliser"));
                wyposazenie.setPoduszki_powietrzne(rs.getInt("poduszki_powietrzne"));
                wyposazenie.setAlufelgi(rs.getInt("alufelgi"));
                wyposazenie.setBagaznik_na_dachu(rs.getInt("bagaznik_na_dachu"));
                wyposazenie.setHak(rs.getInt("hak"));
                wyposazenie.setKsenony(rs.getInt("ksenony"));
                wyposazenie.setPrzyc_szyby(rs.getInt("przyc_szyby"));
                wyposazenie.setSzyberdach(rs.getInt("szyberdach"));
                wyposazeniee.add(wyposazenie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyposazeniee;
    }

    public List<Wyposazenie> getCarByYearInterval(Integer min, Integer max) {
        List<Wyposazenie> wyposazeniee = new ArrayList<Wyposazenie>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from wyposazenie");
            while (rs.next()) {
                Wyposazenie wyposazenie = new Wyposazenie();
                wyposazenie.setWyposazenieId(rs.getInt("wyposazenieId"));
                wyposazenie.setNaped4x4(rs.getInt("naped4x4"));
                wyposazenie.setCentralny_zamek(rs.getInt("centralny_zamek"));
                wyposazenie.setCzujnik_deszczu(rs.getInt("czujnik_deszczu"));
                wyposazenie.setCzujnik_parkowania(rs.getInt("czujnik_parkowania"));
                wyposazenie.setEl_lusterka(rs.getInt("el_lusterka"));
                wyposazenie.setEl_szyby(rs.getInt("el_szyby"));
                wyposazenie.setKlimatyzacja(rs.getInt("klimatyzacja"));
                wyposazenie.setKomputer_pokladowy(rs.getInt("komputer_pokladowy"));
                wyposazenie.setPod_przed_szyba(rs.getInt("pod_przed_szyba"));
                wyposazenie.setPod_fotele(rs.getInt("pod_fotele"));
                wyposazenie.setRadio(rs.getInt("radio"));
                wyposazenie.setSystem_nawigacji(rs.getInt("system_nawigacji"));
                wyposazenie.setSkorzana_tapicerka(rs.getInt("skorzana_tapicerka"));
                wyposazenie.setTempomat(rs.getInt("tempomat"));
                wyposazenie.setWsp_kierownicy(rs.getInt("wsp_kierownicy"));
                wyposazenie.setKontrola_antyposlizgowa(rs.getInt("kontrola_antyposlizgowa"));
                wyposazenie.setAutoalarm(rs.getInt("autoalarm"));
                wyposazenie.setBlok_skrzyni_biegow(rs.getInt("blok_skrzyni_biegow"));
                wyposazenie.setEsp(rs.getInt("esp"));
                wyposazenie.setImmobiliser(rs.getInt("immobiliser"));
                wyposazenie.setPoduszki_powietrzne(rs.getInt("poduszki_powietrzne"));
                wyposazenie.setAlufelgi(rs.getInt("alufelgi"));
                wyposazenie.setBagaznik_na_dachu(rs.getInt("bagaznik_na_dachu"));
                wyposazenie.setHak(rs.getInt("hak"));
                wyposazenie.setKsenony(rs.getInt("ksenony"));
                wyposazenie.setPrzyc_szyby(rs.getInt("przyc_szyby"));
                wyposazenie.setSzyberdach(rs.getInt("szyberdach"));
                wyposazeniee.add(wyposazenie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyposazeniee;
    }

    public List<Wyposazenie> getDontReturnedCar() {
        List<Wyposazenie> wyposazeniee = new ArrayList<Wyposazenie>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from wyposazenie");
            while (rs.next()) {
                Wyposazenie wyposazenie = new Wyposazenie();
                wyposazenie.setWyposazenieId(rs.getInt("wyposazenieId"));
                wyposazenie.setNaped4x4(rs.getInt("naped4x4"));
                wyposazenie.setCentralny_zamek(rs.getInt("centralny_zamek"));
                wyposazenie.setCzujnik_deszczu(rs.getInt("czujnik_deszczu"));
                wyposazenie.setCzujnik_parkowania(rs.getInt("czujnik_parkowania"));
                wyposazenie.setEl_lusterka(rs.getInt("el_lusterka"));
                wyposazenie.setEl_szyby(rs.getInt("el_szyby"));
                wyposazenie.setKlimatyzacja(rs.getInt("klimatyzacja"));
                wyposazenie.setKomputer_pokladowy(rs.getInt("komputer_pokladowy"));
                wyposazenie.setPod_przed_szyba(rs.getInt("pod_przed_szyba"));
                wyposazenie.setPod_fotele(rs.getInt("pod_fotele"));
                wyposazenie.setRadio(rs.getInt("radio"));
                wyposazenie.setSystem_nawigacji(rs.getInt("system_nawigacji"));
                wyposazenie.setSkorzana_tapicerka(rs.getInt("skorzana_tapicerka"));
                wyposazenie.setTempomat(rs.getInt("tempomat"));
                wyposazenie.setWsp_kierownicy(rs.getInt("wsp_kierownicy"));
                wyposazenie.setKontrola_antyposlizgowa(rs.getInt("kontrola_antyposlizgowa"));
                wyposazenie.setAutoalarm(rs.getInt("autoalarm"));
                wyposazenie.setBlok_skrzyni_biegow(rs.getInt("blok_skrzyni_biegow"));
                wyposazenie.setEsp(rs.getInt("esp"));
                wyposazenie.setImmobiliser(rs.getInt("immobiliser"));
                wyposazenie.setPoduszki_powietrzne(rs.getInt("poduszki_powietrzne"));
                wyposazenie.setAlufelgi(rs.getInt("alufelgi"));
                wyposazenie.setBagaznik_na_dachu(rs.getInt("bagaznik_na_dachu"));
                wyposazenie.setHak(rs.getInt("hak"));
                wyposazenie.setKsenony(rs.getInt("ksenony"));
                wyposazenie.setPrzyc_szyby(rs.getInt("przyc_szyby"));
                wyposazenie.setSzyberdach(rs.getInt("szyberdach"));
                wyposazeniee.add(wyposazenie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyposazeniee;
    }
    
    public Wyposazenie getCarById(int carId) {
        Wyposazenie wyposazenie = new Wyposazenie();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from wyposazenie where id=?");
            preparedStatement.setInt(1, carId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                wyposazenie.setWyposazenieId(rs.getInt("wyposazenieId"));
                wyposazenie.setNaped4x4(rs.getInt("naped4x4"));
                wyposazenie.setCentralny_zamek(rs.getInt("centralny_zamek"));
                wyposazenie.setCzujnik_deszczu(rs.getInt("czujnik_deszczu"));
                wyposazenie.setCzujnik_parkowania(rs.getInt("czujnik_parkowania"));
                wyposazenie.setEl_lusterka(rs.getInt("el_lusterka"));
                wyposazenie.setEl_szyby(rs.getInt("el_szyby"));
                wyposazenie.setKlimatyzacja(rs.getInt("klimatyzacja"));
                wyposazenie.setKomputer_pokladowy(rs.getInt("komputer_pokladowy"));
                wyposazenie.setPod_przed_szyba(rs.getInt("pod_przed_szyba"));
                wyposazenie.setPod_fotele(rs.getInt("pod_fotele"));
                wyposazenie.setRadio(rs.getInt("radio"));
                wyposazenie.setSystem_nawigacji(rs.getInt("system_nawigacji"));
                wyposazenie.setSkorzana_tapicerka(rs.getInt("skorzana_tapicerka"));
                wyposazenie.setTempomat(rs.getInt("tempomat"));
                wyposazenie.setWsp_kierownicy(rs.getInt("wsp_kierownicy"));
                wyposazenie.setKontrola_antyposlizgowa(rs.getInt("kontrola_antyposlizgowa"));
                wyposazenie.setAutoalarm(rs.getInt("autoalarm"));
                wyposazenie.setBlok_skrzyni_biegow(rs.getInt("blok_skrzyni_biegow"));
                wyposazenie.setEsp(rs.getInt("esp"));
                wyposazenie.setImmobiliser(rs.getInt("immobiliser"));
                wyposazenie.setPoduszki_powietrzne(rs.getInt("poduszki_powietrzne"));
                wyposazenie.setAlufelgi(rs.getInt("alufelgi"));
                wyposazenie.setBagaznik_na_dachu(rs.getInt("bagaznik_na_dachu"));
                wyposazenie.setHak(rs.getInt("hak"));
                wyposazenie.setKsenony(rs.getInt("ksenony"));
                wyposazenie.setPrzyc_szyby(rs.getInt("przyc_szyby"));
                wyposazenie.setSzyberdach(rs.getInt("szyberdach"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyposazenie;
    }
}

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
            preparedStatement.setString(2, wyposazenie.getNaped4x4());
            preparedStatement.setString(3, wyposazenie.getCentralny_zamek());
            preparedStatement.setString(4, wyposazenie.getCzujnik_deszczu());
            preparedStatement.setString(5, wyposazenie.getCzujnik_parkowania());
            preparedStatement.setString(6, wyposazenie.getEl_lusterka());
            preparedStatement.setString(7, wyposazenie.getEl_szyby());
            preparedStatement.setString(8, wyposazenie.getKlimatyzacja());
            preparedStatement.setString(9, wyposazenie.getKomputer_pokladowy());
            preparedStatement.setString(10, wyposazenie.getPod_przed_szyba());
            preparedStatement.setString(11, wyposazenie.getPod_fotele());
            preparedStatement.setString(12, wyposazenie.getRadio());
            preparedStatement.setString(13, wyposazenie.getSystem_nawigacji());
            preparedStatement.setString(14, wyposazenie.getSkorzana_tapicerka());
            preparedStatement.setString(15, wyposazenie.getTempomat());
            preparedStatement.setString(16, wyposazenie.getWsp_kierownicy());
            preparedStatement.setString(17, wyposazenie.getKontrola_antyposlizgowa());
            preparedStatement.setString(18, wyposazenie.getAutoalarm());
            preparedStatement.setString(19, wyposazenie.getBlok_skrzyni_biegow());
            preparedStatement.setString(20, wyposazenie.getEsp());
            preparedStatement.setString(21, wyposazenie.getImmobiliser());
            preparedStatement.setString(22, wyposazenie.getPoduszki_powietrzne());
            preparedStatement.setString(23, wyposazenie.getAlufelgi());
            preparedStatement.setString(24, wyposazenie.getBagaznik_na_dachu());
            preparedStatement.setString(25, wyposazenie.getHak());
            preparedStatement.setString(26, wyposazenie.getKsenony());
            preparedStatement.setString(27, wyposazenie.getPrzyc_szyby());
            preparedStatement.setString(28, wyposazenie.getSzyberdach());
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
            preparedStatement.setString(2, wyposazenie.getNaped4x4());
            preparedStatement.setString(3, wyposazenie.getCentralny_zamek());
            preparedStatement.setString(4, wyposazenie.getCzujnik_deszczu());
            preparedStatement.setString(5, wyposazenie.getCzujnik_parkowania());
            preparedStatement.setString(6, wyposazenie.getEl_lusterka());
            preparedStatement.setString(7, wyposazenie.getEl_szyby());
            preparedStatement.setString(8, wyposazenie.getKlimatyzacja());
            preparedStatement.setString(9, wyposazenie.getKomputer_pokladowy());
            preparedStatement.setString(10, wyposazenie.getPod_przed_szyba());
            preparedStatement.setString(11, wyposazenie.getPod_fotele());
            preparedStatement.setString(12, wyposazenie.getRadio());
            preparedStatement.setString(13, wyposazenie.getSystem_nawigacji());
            preparedStatement.setString(14, wyposazenie.getSkorzana_tapicerka());
            preparedStatement.setString(15, wyposazenie.getTempomat());
            preparedStatement.setString(16, wyposazenie.getWsp_kierownicy());
            preparedStatement.setString(17, wyposazenie.getKontrola_antyposlizgowa());
            preparedStatement.setString(18, wyposazenie.getAutoalarm());
            preparedStatement.setString(19, wyposazenie.getBlok_skrzyni_biegow());
            preparedStatement.setString(20, wyposazenie.getEsp());
            preparedStatement.setString(21, wyposazenie.getImmobiliser());
            preparedStatement.setString(22, wyposazenie.getPoduszki_powietrzne());
            preparedStatement.setString(23, wyposazenie.getAlufelgi());
            preparedStatement.setString(24, wyposazenie.getBagaznik_na_dachu());
            preparedStatement.setString(25, wyposazenie.getHak());
            preparedStatement.setString(26, wyposazenie.getKsenony());
            preparedStatement.setString(27, wyposazenie.getPrzyc_szyby());
            preparedStatement.setString(28, wyposazenie.getSzyberdach());
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
            preparedStatement.setString(2, wyposazenie.getNaped4x4());
            preparedStatement.setString(3, wyposazenie.getCentralny_zamek());
            preparedStatement.setString(4, wyposazenie.getCzujnik_deszczu());
            preparedStatement.setString(5, wyposazenie.getCzujnik_parkowania());
            preparedStatement.setString(6, wyposazenie.getEl_lusterka());
            preparedStatement.setString(7, wyposazenie.getEl_szyby());
            preparedStatement.setString(8, wyposazenie.getKlimatyzacja());
            preparedStatement.setString(9, wyposazenie.getKomputer_pokladowy());
            preparedStatement.setString(10, wyposazenie.getPod_przed_szyba());
            preparedStatement.setString(11, wyposazenie.getPod_fotele());
            preparedStatement.setString(12, wyposazenie.getRadio());
            preparedStatement.setString(13, wyposazenie.getSystem_nawigacji());
            preparedStatement.setString(14, wyposazenie.getSkorzana_tapicerka());
            preparedStatement.setString(15, wyposazenie.getTempomat());
            preparedStatement.setString(16, wyposazenie.getWsp_kierownicy());
            preparedStatement.setString(17, wyposazenie.getKontrola_antyposlizgowa());
            preparedStatement.setString(18, wyposazenie.getAutoalarm());
            preparedStatement.setString(19, wyposazenie.getBlok_skrzyni_biegow());
            preparedStatement.setString(20, wyposazenie.getEsp());
            preparedStatement.setString(21, wyposazenie.getImmobiliser());
            preparedStatement.setString(22, wyposazenie.getPoduszki_powietrzne());
            preparedStatement.setString(23, wyposazenie.getAlufelgi());
            preparedStatement.setString(24, wyposazenie.getBagaznik_na_dachu());
            preparedStatement.setString(25, wyposazenie.getHak());
            preparedStatement.setString(26, wyposazenie.getKsenony());
            preparedStatement.setString(27, wyposazenie.getPrzyc_szyby());
            preparedStatement.setString(28, wyposazenie.getSzyberdach());
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

    public List<Wyposazenie> getAllWyposazenie() {
        List<Wyposazenie> wyposazeniee = new ArrayList<Wyposazenie>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from wyposazenie");
            while (rs.next()) {
                Wyposazenie wyposazenie = new Wyposazenie();
                wyposazenie.setWyposazenieId(rs.getInt("wyposazenieId"));
                wyposazenie.setNaped4x4(rs.getString("naped4x4"));
                wyposazenie.setCentralny_zamek(rs.getString("centralny_zamek"));
                wyposazenie.setCzujnik_deszczu(rs.getString("czujnik_deszczu"));
                wyposazenie.setCzujnik_parkowania(rs.getString("czujnik_parkowania"));
                wyposazenie.setEl_lusterka(rs.getString("el_lusterka"));
                wyposazenie.setEl_szyby(rs.getString("el_szyby"));
                wyposazenie.setKlimatyzacja(rs.getString("klimatyzacja"));
                wyposazenie.setKomputer_pokladowy(rs.getString("komputer_pokladowy"));
                wyposazenie.setPod_przed_szyba(rs.getString("pod_przed_szyba"));
                wyposazenie.setPod_fotele(rs.getString("pod_fotele"));
                wyposazenie.setRadio(rs.getString("radio"));
                wyposazenie.setSystem_nawigacji(rs.getString("system_nawigacji"));
                wyposazenie.setSkorzana_tapicerka(rs.getString("skorzana_tapicerka"));
                wyposazenie.setTempomat(rs.getString("tempomat"));
                wyposazenie.setWsp_kierownicy(rs.getString("wsp_kierownicy"));
                wyposazenie.setKontrola_antyposlizgowa(rs.getString("kontrola_antyposlizgowa"));
                wyposazenie.setAutoalarm(rs.getString("autoalarm"));
                wyposazenie.setBlok_skrzyni_biegow(rs.getString("blok_skrzyni_biegow"));
                wyposazenie.setEsp(rs.getString("esp"));
                wyposazenie.setImmobiliser(rs.getString("immobiliser"));
                wyposazenie.setPoduszki_powietrzne(rs.getString("poduszki_powietrzne"));
                wyposazenie.setAlufelgi(rs.getString("alufelgi"));
                wyposazenie.setBagaznik_na_dachu(rs.getString("bagaznik_na_dachu"));
                wyposazenie.setHak(rs.getString("hak"));
                wyposazenie.setKsenony(rs.getString("ksenony"));
                wyposazenie.setPrzyc_szyby(rs.getString("przyc_szyby"));
                wyposazenie.setSzyberdach(rs.getString("szyberdach"));
                wyposazeniee.add(wyposazenie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyposazeniee;
    }
    
    public List<Wyposazenie> getWyposazenieByBrand(String wyposazenieBrand) {
        List<Wyposazenie> wyposazeniee = new ArrayList<Wyposazenie>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from wyposazenie");
            while (rs.next()) {
                Wyposazenie wyposazenie = new Wyposazenie();
                wyposazenie.setWyposazenieId(rs.getInt("wyposazenieId"));
                wyposazenie.setNaped4x4(rs.getString("naped4x4"));
                wyposazenie.setCentralny_zamek(rs.getString("centralny_zamek"));
                wyposazenie.setCzujnik_deszczu(rs.getString("czujnik_deszczu"));
                wyposazenie.setCzujnik_parkowania(rs.getString("czujnik_parkowania"));
                wyposazenie.setEl_lusterka(rs.getString("el_lusterka"));
                wyposazenie.setEl_szyby(rs.getString("el_szyby"));
                wyposazenie.setKlimatyzacja(rs.getString("klimatyzacja"));
                wyposazenie.setKomputer_pokladowy(rs.getString("komputer_pokladowy"));
                wyposazenie.setPod_przed_szyba(rs.getString("pod_przed_szyba"));
                wyposazenie.setPod_fotele(rs.getString("pod_fotele"));
                wyposazenie.setRadio(rs.getString("radio"));
                wyposazenie.setSystem_nawigacji(rs.getString("system_nawigacji"));
                wyposazenie.setSkorzana_tapicerka(rs.getString("skorzana_tapicerka"));
                wyposazenie.setTempomat(rs.getString("tempomat"));
                wyposazenie.setWsp_kierownicy(rs.getString("wsp_kierownicy"));
                wyposazenie.setKontrola_antyposlizgowa(rs.getString("kontrola_antyposlizgowa"));
                wyposazenie.setAutoalarm(rs.getString("autoalarm"));
                wyposazenie.setBlok_skrzyni_biegow(rs.getString("blok_skrzyni_biegow"));
                wyposazenie.setEsp(rs.getString("esp"));
                wyposazenie.setImmobiliser(rs.getString("immobiliser"));
                wyposazenie.setPoduszki_powietrzne(rs.getString("poduszki_powietrzne"));
                wyposazenie.setAlufelgi(rs.getString("alufelgi"));
                wyposazenie.setBagaznik_na_dachu(rs.getString("bagaznik_na_dachu"));
                wyposazenie.setHak(rs.getString("hak"));
                wyposazenie.setKsenony(rs.getString("ksenony"));
                wyposazenie.setPrzyc_szyby(rs.getString("przyc_szyby"));
                wyposazenie.setSzyberdach(rs.getString("szyberdach"));
                wyposazeniee.add(wyposazenie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyposazeniee;
    }

    public List<Wyposazenie> getDontReturnedWyposazenie() {
        List<Wyposazenie> wyposazeniee = new ArrayList<Wyposazenie>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from wyposazenie");
            while (rs.next()) {
                Wyposazenie wyposazenie = new Wyposazenie();
                wyposazenie.setWyposazenieId(rs.getInt("wyposazenieId"));
                wyposazenie.setNaped4x4(rs.getString("naped4x4"));
                wyposazenie.setCentralny_zamek(rs.getString("centralny_zamek"));
                wyposazenie.setCzujnik_deszczu(rs.getString("czujnik_deszczu"));
                wyposazenie.setCzujnik_parkowania(rs.getString("czujnik_parkowania"));
                wyposazenie.setEl_lusterka(rs.getString("el_lusterka"));
                wyposazenie.setEl_szyby(rs.getString("el_szyby"));
                wyposazenie.setKlimatyzacja(rs.getString("klimatyzacja"));
                wyposazenie.setKomputer_pokladowy(rs.getString("komputer_pokladowy"));
                wyposazenie.setPod_przed_szyba(rs.getString("pod_przed_szyba"));
                wyposazenie.setPod_fotele(rs.getString("pod_fotele"));
                wyposazenie.setRadio(rs.getString("radio"));
                wyposazenie.setSystem_nawigacji(rs.getString("system_nawigacji"));
                wyposazenie.setSkorzana_tapicerka(rs.getString("skorzana_tapicerka"));
                wyposazenie.setTempomat(rs.getString("tempomat"));
                wyposazenie.setWsp_kierownicy(rs.getString("wsp_kierownicy"));
                wyposazenie.setKontrola_antyposlizgowa(rs.getString("kontrola_antyposlizgowa"));
                wyposazenie.setAutoalarm(rs.getString("autoalarm"));
                wyposazenie.setBlok_skrzyni_biegow(rs.getString("blok_skrzyni_biegow"));
                wyposazenie.setEsp(rs.getString("esp"));
                wyposazenie.setImmobiliser(rs.getString("immobiliser"));
                wyposazenie.setPoduszki_powietrzne(rs.getString("poduszki_powietrzne"));
                wyposazenie.setAlufelgi(rs.getString("alufelgi"));
                wyposazenie.setBagaznik_na_dachu(rs.getString("bagaznik_na_dachu"));
                wyposazenie.setHak(rs.getString("hak"));
                wyposazenie.setKsenony(rs.getString("ksenony"));
                wyposazenie.setPrzyc_szyby(rs.getString("przyc_szyby"));
                wyposazenie.setSzyberdach(rs.getString("szyberdach"));
                wyposazeniee.add(wyposazenie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyposazeniee;
    }
    
    public Wyposazenie getWyposazenieById(int wyposazenieId) {
        Wyposazenie wyposazenie = new Wyposazenie();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from wyposazenie where id=?");
            preparedStatement.setInt(1, wyposazenieId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                wyposazenie.setWyposazenieId(rs.getInt("wyposazenieId"));
                wyposazenie.setNaped4x4(rs.getString("naped4x4"));
                wyposazenie.setCentralny_zamek(rs.getString("centralny_zamek"));
                wyposazenie.setCzujnik_deszczu(rs.getString("czujnik_deszczu"));
                wyposazenie.setCzujnik_parkowania(rs.getString("czujnik_parkowania"));
                wyposazenie.setEl_lusterka(rs.getString("el_lusterka"));
                wyposazenie.setEl_szyby(rs.getString("el_szyby"));
                wyposazenie.setKlimatyzacja(rs.getString("klimatyzacja"));
                wyposazenie.setKomputer_pokladowy(rs.getString("komputer_pokladowy"));
                wyposazenie.setPod_przed_szyba(rs.getString("pod_przed_szyba"));
                wyposazenie.setPod_fotele(rs.getString("pod_fotele"));
                wyposazenie.setRadio(rs.getString("radio"));
                wyposazenie.setSystem_nawigacji(rs.getString("system_nawigacji"));
                wyposazenie.setSkorzana_tapicerka(rs.getString("skorzana_tapicerka"));
                wyposazenie.setTempomat(rs.getString("tempomat"));
                wyposazenie.setWsp_kierownicy(rs.getString("wsp_kierownicy"));
                wyposazenie.setKontrola_antyposlizgowa(rs.getString("kontrola_antyposlizgowa"));
                wyposazenie.setAutoalarm(rs.getString("autoalarm"));
                wyposazenie.setBlok_skrzyni_biegow(rs.getString("blok_skrzyni_biegow"));
                wyposazenie.setEsp(rs.getString("esp"));
                wyposazenie.setImmobiliser(rs.getString("immobiliser"));
                wyposazenie.setPoduszki_powietrzne(rs.getString("poduszki_powietrzne"));
                wyposazenie.setAlufelgi(rs.getString("alufelgi"));
                wyposazenie.setBagaznik_na_dachu(rs.getString("bagaznik_na_dachu"));
                wyposazenie.setHak(rs.getString("hak"));
                wyposazenie.setKsenony(rs.getString("ksenony"));
                wyposazenie.setPrzyc_szyby(rs.getString("przyc_szyby"));
                wyposazenie.setSzyberdach(rs.getString("szyberdach"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyposazenie;
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Car;
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
                    .prepareStatement("insert into wyposazenie(wyposazenieId,naped4x4,centralny_zamek,czujnik_deszczu,czujnik_parkowania,el_lusterka,el_szyby,klimatyzacja,komputer_pokladowy,pod_przed_szyba,pod_fotele,radio,system_nawigacji,skorzana_tapicerka,tempomat,wsp_kierownicy,kontrola_antyposlizgowa,autoalarm,blok_skrzyni_biegow,esp,immobiliser,poduszki_powietrzne,alufelgi,bagaznik_na_dachu,hak,ksenony,przyc_szyby,szyberdach) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, id);
            
            try {
            if(wyposazenie.getNaped4x4().equals("4x4"))
            preparedStatement.setInt(2, 1);
            } catch (Exception e)
             {
            preparedStatement.setInt(2, 0);    
             }
            
            try {
            if(wyposazenie.getCentralny_zamek().equals("centralny_zamek"))
            preparedStatement.setInt(3,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(3, 0);
             }
            
            try {
            if(wyposazenie.getCzujnik_deszczu().equals("czujnik_deszczu"))
            preparedStatement.setInt(4,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(4, 0);    
             }
            
            try{
            if(wyposazenie.getCzujnik_parkowania().equals("czujnik_parkowania"))
            preparedStatement.setInt(5, 1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(5, 0);    
             }
            
            try{
            if(wyposazenie.getEl_lusterka().equals("el_lusterka"))
            preparedStatement.setInt(6,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(6,0);    
             }
            
            try {
            if(wyposazenie.getEl_szyby().equals("el_szyby"))
            preparedStatement.setInt(7,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(7,1);    
             }
            
            try {
            if(wyposazenie.getKlimatyzacja().equals("klimatyzacja"))
            preparedStatement.setInt(8,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(8,0);
             }
            
            try{
            if(wyposazenie.getKomputer_pokladowy().equals("komputer_pokladowy"))
            preparedStatement.setInt(9,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(9,0);    
             }
            
            try{
            if(wyposazenie.getPod_przed_szyba().equals("pod_przed_szyba"))
            preparedStatement.setInt(10,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(10,0);    
             }
            
            try{
            if(wyposazenie.getPod_fotele().equals("pod_fotele"))
            preparedStatement.setInt(11,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(11,0);  
             }
            
            try{
            if(wyposazenie.getRadio().equals("radio"))
            preparedStatement.setInt(12,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(12,0);
             }
            
            try{
            if( wyposazenie.getSystem_nawigacji().equals("system_nawigacji"))
            preparedStatement.setInt(13,1);
            }
             catch (Exception e)
             {
            preparedStatement.setInt(13,0);   
             }
            
            try{
            if(wyposazenie.getSkorzana_tapicerka().equals("skorzana_tapicerka"))
            preparedStatement.setInt(14,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(14,0);    
             }
            
            try{
            if(wyposazenie.getTempomat().equals("tempomat"))
            preparedStatement.setInt(15,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(15,0);
             }
            
            try{
            if(wyposazenie.getWsp_kierownicy().equals("wsp_kierownicy"))
            preparedStatement.setInt(16,1);
            }
             catch (Exception e)
             {
            preparedStatement.setInt(16,0);    
             }
            
            try{
            if(wyposazenie.getKontrola_antyposlizgowa().equals("kontrola_antyposlizgowa"))
            preparedStatement.setInt(17,1);
            }
             catch (Exception e)
             {
            preparedStatement.setInt(17,0);    
             }
            
            try{
            if(wyposazenie.getAutoalarm().equals("autoalarm"))
            preparedStatement.setInt(18,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(18,0);
             }
            
            try{
            if(wyposazenie.getBlok_skrzyni_biegow().equals("blok_skrzyni_biegow"))
            preparedStatement.setInt(19,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(19,0);    
             }
            
            try{
            if(wyposazenie.getEsp().equals("esp"))
            preparedStatement.setInt(20, 1);
              }
            catch (Exception e)
             {
            preparedStatement.setInt(20, 0);    
             }
            
            try{
            if(wyposazenie.getImmobiliser().equals("immobiliser"))
            preparedStatement.setInt(21,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(21,0);
             }
            
            try{
            if(wyposazenie.getPoduszki_powietrzne().equals("poduszki_powietrzne"))
            preparedStatement.setInt(22,1);
            }
             catch (Exception e)
             {
            preparedStatement.setInt(22,0);    
             }
            
            try{
            if(wyposazenie.getAlufelgi().equals("alufelgi"))
            preparedStatement.setInt(23,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(23,0);    
             }
            
            try{
            if(wyposazenie.getBagaznik_na_dachu().equals("bagaznik_na_dachu"))
            preparedStatement.setInt(24,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(24,0);    
             }
            
            try{
            if(wyposazenie.getHak().equals("hak"))
            preparedStatement.setInt(25,1);
             }
            catch (Exception e)
             {
            preparedStatement.setInt(25,0);    
             }
            
            try{
            if(wyposazenie.getKsenony().equals("ksenony"))
            preparedStatement.setInt(26,1);
            }
            catch (Exception e)
             {
            preparedStatement.setInt(26,0);    
             }
            
            try{
            if(wyposazenie.getPrzyc_szyby().equals("przyc_szyby"))
            preparedStatement.setInt(27,1);
              }
            catch (Exception e)
             {
            preparedStatement.setInt(27,0);   
             }
            
            try{
            if(wyposazenie.getSzyberdach().equals("szyberdach"))
            preparedStatement.setInt(28,1);
              }
            catch (Exception e)
             {
            preparedStatement.setInt(28,0);    
             }
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
    
    public void deleteWyposazenie(int wyposazenieId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from wyposazenie where wyposazenieId=?");

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
                    .prepareStatement("insert into wyposazenie(wyposazenieId,naped4x4,centralny_zamek,czujnik_deszczu,czujnik_parkowania,el_lusterka,el_szyby,klimatyzacja,komputer_pokladowy,pod_przed_szyba,pod_fotele,radio,system_nawigacji,skorzana_tapicerka,tempomat,wsp_kierownicy,kontrola_antyposlizgowa,autoalarm,blok_skrzyni_biegow,esp,immobiliser,poduszki_powietrzne,alufelgi,bagaznik_na_dachu,hak,ksenony,przyc_szyby,szyberdach) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
    
    
    public List<String> getWyposazenieById(Integer id_wyp)
    {
        List<String> Equipment = new ArrayList<String>();
        Integer tmp = new Integer(0);
    
        
         try {
     PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from wyposazenie where wyposazenieId=?");

            preparedStatement.setInt(1,id_wyp);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                tmp=rs.getInt("naped4x4");
                if(tmp==1)
                Equipment.add("4x4");
             
                
            tmp=rs.getInt("centralny_zamek");
            if(tmp==1)
            Equipment.add("centralny_zamek");
            
                    tmp=rs.getInt("czujnik_deszczu");
                    if(tmp==1)
                    Equipment.add("czujnik_deszczu");
                    
                    tmp=rs.getInt("czujnik_parkowania");
                    if(tmp==1)
                    Equipment.add("czujnik_parkowania");
                    
            tmp=rs.getInt("el_lusterka");
            if(tmp==1)
            Equipment.add("Elektryczne Lusterka");
                    
            tmp=rs.getInt("el_szyby");
            if(tmp==1)
            Equipment.add("Elektryczne Szyby");
          
            //////////////////
            tmp=rs.getInt("klimatyzacja");
            if(tmp==1)
            Equipment.add("Klimatyzacja");
                    
            
            
            tmp=rs.getInt("komputer_pokladowy");
            if(tmp==1)
            Equipment.add("Komputer Pokladowy");
            
            
            
            
            
            tmp=rs.getInt("pod_przed_szyba");
            if(tmp==1)
            Equipment.add("Podgrzewana Przednia Szyba");
                    
            
            
            tmp=rs.getInt("pod_fotele");
            if(tmp==1)
            Equipment.add("Podgrzewane fotele");
            
            
            
            
            
            tmp=rs.getInt("radio");
            if(tmp==1)
            Equipment.add("Radio");
                    
            
            
            tmp=rs.getInt("system_nawigacji");
            if(tmp==1)
            Equipment.add("System Nawigacji");
            
            
            
            
            tmp=rs.getInt("skorzana_tapicerka");
            if(tmp==1)
            Equipment.add("Skorzana Tapicerka");
                    
            
            tmp=rs.getInt("tempomat");
            if(tmp==1)
            Equipment.add("Tempomat");
            
            
            
            tmp=rs.getInt("wsp_kierownicy");
            if(tmp==1)
            Equipment.add("Wspomaganie Kierownicy");
                    
            tmp=rs.getInt("kontrola_antyposlizgowa");
            if(tmp==1)
            Equipment.add("Kontrola Antyposlizgowa");
            
            
            tmp=rs.getInt("autoalarm");
            if(tmp==1)
            Equipment.add("Autoalarm");
                    
            tmp=rs.getInt("blok_skrzyni_biegow");
            if(tmp==1)
            Equipment.add("Blok Skrzyni Biegow");
            
            
            tmp=rs.getInt("esp");
            if(tmp==1)
            Equipment.add("Elektroniczny Program Stabilizacji");
                   
            
            tmp=rs.getInt("immobiliser");
            if(tmp==1)
            Equipment.add("Immobiliser");
            
            
            tmp=rs.getInt("poduszki_powietrzne");
            if(tmp==1)
            Equipment.add("Poduszki Powietrzne");
                    
            
            tmp=rs.getInt("alufelgi");
            if(tmp==1)
            Equipment.add("Alufelgi");
            
            
            tmp=rs.getInt("bagaznik_na_dachu");
            if(tmp==1)
            Equipment.add("Bagaznik na dachu");
                    
            tmp=rs.getInt("hak");
            if(tmp==1)
            Equipment.add("Hak");
            
            
            tmp=rs.getInt("ksenony");
            if(tmp==1)
            Equipment.add("Ksenony");
                    
            tmp=rs.getInt("przyc_szyby");
            if(tmp==1)
            Equipment.add("Przyciemniane Szyby");
            
            
            tmp=rs.getInt("szyberdach");
            if(tmp==1)
            Equipment.add("Szyberdach");
                    
          
            
            
            
                                  }
        } catch (SQLException e) {
            e.printStackTrace();
        }
                
        
        return Equipment;
    }
    
  
}

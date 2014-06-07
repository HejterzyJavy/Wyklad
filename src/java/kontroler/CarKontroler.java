package kontroler;

import dao.CarDao;
import dao.OplatyDao;
import dao.RentDao;
import dao.WyposazenieDao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Car;
import model.Oplaty;
import model.Rent;
import model.Wyposazenie;
/*import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
*/

@MultipartConfig

// specifies servlet takes multipart/form-data
public class CarKontroler extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private static String INDEX = "/index.html";
    private static String ZALOGOWANY = "/Zalogowany.jsp";
    private static String OFERTA = "/Oferta.jsp";
    private static String DODAWANIE = "/dodajSamochod.jsp";
    private static String WYPOZYCZANIE = "/Wypozyczanie.jsp";
    private static String panelPracownika = "/panelPracownika.jsp";

    private CarDao dao;
    private boolean czyZalogowany = false;
    private OplatyDao oplatydao;
    private WyposazenieDao wyposazeniedao;
    
    public CarKontroler() {
        super();
        dao = new CarDao();
        oplatydao=new OplatyDao();
        wyposazeniedao=new WyposazenieDao();
    }
    
    private static final String SAVE_DIR = "img/samochody2";
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                System.out.println(s.substring(s.indexOf("=") + 2, s.length()-1));
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = new Car();
        Wyposazenie wyposazenie=new Wyposazenie();
        Oplaty oplaty=new Oplaty();
        
        List<Car> cars = new ArrayList<Car>();
        RequestDispatcher view = request.getRequestDispatcher("/panelPracownika.jsp");
       
        String zatwierdzSamochod = request.getParameter("zatwierdzSamochod");
        if (zatwierdzSamochod != null) {

            DateFormat dateFrm = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date myDate = new java.util.Date();
            java.sql.Date dataRozpoczeciaOc;
            java.sql.Date dataZakonczeniaOc;
            java.sql.Date dataRozpoczeciaAc;
            java.sql.Date dataZakonczeniaAc;
           
            car.setRejestracja(request.getParameter("rejestracja"));
            car.setMarka(request.getParameter("firma"));
            car.setModel(request.getParameter("model"));
            car.setRocznik(Integer.parseInt(request.getParameter("rokProdukcji")));
            car.setRodzajPaliwa(request.getParameter("paliwo"));
            car.setMocSilnika(Integer.parseInt(request.getParameter("mocSilnika")));
            car.setPrzebieg(Integer.parseInt(request.getParameter("przebieg")));
            car.setPojemnoscSilnika(request.getParameter("pojemnosc"));
            car.setSkrzyniaBiegow(request.getParameter("skrzynia"));
            car.setTypNadwozia(request.getParameter("typNadwozia"));
            car.setCenaDoba(Integer.parseInt(request.getParameter("cenaDoba")));
            final Part filePart = request.getPart("pliczek");
            wyposazenie.setNaped4x4(request.getParameter("naped"));
            wyposazenie.setCentralny_zamek(request.getParameter("centralny_zamek"));
            wyposazenie.setCzujnik_deszczu(request.getParameter("czujnik_deszczu"));
            //wyposazenie.setCzujnik_deszczu("");
            wyposazenie.setCzujnik_parkowania(request.getParameter("czujnik_parkowania"));
            wyposazenie.setEl_lusterka(request.getParameter("el_lusterka"));
            wyposazenie.setEl_szyby(request.getParameter("el_szyby"));
            wyposazenie.setKlimatyzacja(request.getParameter("klimatyzacja"));
            wyposazenie.setKomputer_pokladowy(request.getParameter("komputer_pokladowy"));
            wyposazenie.setPod_przed_szyba(request.getParameter("pod_przed_szyba"));
            wyposazenie.setPod_fotele(request.getParameter("pod_fotele"));
            wyposazenie.setRadio(request.getParameter("radio"));
            wyposazenie.setSystem_nawigacji(request.getParameter("system_nawigacji"));
            wyposazenie.setSkorzana_tapicerka(request.getParameter("skorzana_tapicerka"));
            wyposazenie.setTempomat(request.getParameter("tempomat"));
            wyposazenie.setWsp_kierownicy(request.getParameter("wsp_kierownicy"));
            wyposazenie.setKontrola_antyposlizgowa(request.getParameter("kontrola_antyposlizgowa"));
            wyposazenie.setAutoalarm(request.getParameter("autoalarm"));
            wyposazenie.setBlok_skrzyni_biegow(request.getParameter("blok_skrzyni_biegow"));
            wyposazenie.setEsp(request.getParameter("esp"));
            wyposazenie.setImmobiliser(request.getParameter("immobiliser"));
            wyposazenie.setPoduszki_powietrzne(request.getParameter("poduszki_powietrzne"));
            wyposazenie.setAlufelgi(request.getParameter("alufelgi"));
            wyposazenie.setBagaznik_na_dachu(request.getParameter("bagaznik_na_dachu"));
            wyposazenie.setHak(request.getParameter("hak"));
            wyposazenie.setKsenony(request.getParameter("ksenony"));
            wyposazenie.setPrzyc_szyby(request.getParameter("przyc_szyby"));
            wyposazenie.setSzyberdach(request.getParameter("szyberdach"));
            
            
     try {
           myDate = dateFrm.parse(request.getParameter("rozpoczecieOc"));
           dataRozpoczeciaOc = new java.sql.Date(myDate.getTime());
           myDate = dateFrm.parse(request.getParameter("ZakonczenieOc"));
           dataZakonczeniaOc = new java.sql.Date(myDate.getTime());
           
           myDate = dateFrm.parse(request.getParameter("rozpoczecieAc"));
           dataRozpoczeciaAc = new java.sql.Date(myDate.getTime());
           myDate = dateFrm.parse(request.getParameter("ZakonczenieAc"));
           dataZakonczeniaAc = new java.sql.Date(myDate.getTime());

        }       catch (Exception e)
               {
               dataRozpoczeciaOc = null;
               dataZakonczeniaOc = null;
               dataRozpoczeciaAc = null;
               dataZakonczeniaAc = null;
               }
            
            
            oplaty.setRozpoczecieOc(dataRozpoczeciaOc);
            oplaty.setZakonczenieOc(dataZakonczeniaOc);
            oplaty.setRozpoczecieAc(dataRozpoczeciaAc);
            oplaty.setZakonczenieAc(dataZakonczeniaAc);
            
            String daneZPliku="";
            InputStream isr = filePart.getInputStream();
            int x;
  
           car.setZdjecie(isr);
           dao.addCar(car,wyposazenie,oplaty);
           wyposazeniedao.addWyposazenie(wyposazenie);
           oplatydao.addFee(oplaty);
        }
        String dodajSamochod = request.getParameter("dodaj");
        if (dodajSamochod != null) {
            view = request.getRequestDispatcher(DODAWANIE);
            //  view.forward(request, response); 
        }

        String wypozyczenie = request.getParameter("wypozyczenie");
        if(wypozyczenie !=null) {
            cars = dao.getAllCars();
            request.setAttribute("Cars", cars);
            view = request.getRequestDispatcher("/Samochody.jsp");
        }
         
        String usunSamochod = request.getParameter("usun");
        if (usunSamochod != null) {
            cars = dao.getAllCars();
            request.setAttribute("wyswietlPrzyjmij", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlListeKoniec", 0);
            request.setAttribute("Cars", cars);
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 1);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            view = request.getRequestDispatcher(panelPracownika);
            //  view.forward(request, response); 
        }

        String Edytuj = request.getParameter("edit");
        if (Edytuj != null) {
            cars = dao.getAllCars();
            request.setAttribute("Edit", cars);
                 
     
            request.setAttribute("wyswietlPrzyjmij", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlListeKoniec", 0);
            request.setAttribute("wyswietlEdycje", 1);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            
            view = request.getRequestDispatcher(panelPracownika);
        }

        String zatwierdzUsun = request.getParameter("zatwierdzUsun");
        if (zatwierdzUsun != null) {
            List<Car> test = new ArrayList<Car>();
            Car tmp = new Car();
            

            test = dao.getAllCars();
            for (int i = 0; i < test.size(); i++) {
                tmp = test.get(i);
                String index = request.getParameter(tmp.getId().toString());

                if (index != null) {
                    oplatydao.deleteFee(tmp.getIdOplaty());
                    wyposazeniedao.deleteWyposazenie(tmp.getIdWyposazenie());
                    dao.deleteCar(Integer.parseInt(index));
                }

            }
            cars = dao.getAllCars();
            request.setAttribute("Cars", cars);
                 request.setAttribute("wyswietlPrzyjmij", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlListeKoniec", 0);
            
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 1);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            view = request.getRequestDispatcher(panelPracownika);
        }

        String zatwierdzEdytuj = request.getParameter("zatwierdzEdytuj");
        if (zatwierdzEdytuj != null) {
            List<Car> test = new ArrayList<Car>();
            Car tmp = new Car();
            String przebieg, idSamochod;
            test = dao.getAllCars();

            for (int i = 0; i < test.size(); i++) {
                przebieg = request.getParameter(test.get(i).getId().toString());
                if (przebieg != null) {
                    if (Integer.parseInt(przebieg) != test.get(i).getPrzebieg()) {

                        test.get(i).setPrzebieg(Integer.parseInt(przebieg));
                        try {
                            dao.zmienPrzebieg(test.get(i).getId(),Integer.parseInt(przebieg));
                        } catch (SQLException ex) {
                            Logger.getLogger(CarKontroler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            cars = dao.getAllCars();
            request.setAttribute("Edit", cars);
                 request.setAttribute("wyswietlPrzyjmij", 0);
             
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlListeKoniec", 0);
            
            request.setAttribute("wyswietlEdycje", 1);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            view = request.getRequestDispatcher(panelPracownika);
        }

        String wyswietlOferte = request.getParameter("oferta");
        if (wyswietlOferte != null) {
           // Integer czyZalogowany1=Integer.parseInt(request.getParameter("czyZalogowany1"));
            //if(czyZalogowany1==null)
              //  czyZalogowany1=0;
            String czyZalogowany=new String();
            String ktoZalogowany=new String();
            String idZalogowany=new String();
            HttpSession session = request.getSession(true);
            try {
                czyZalogowany = session.getAttribute("czyZalogowany1").toString();
                idZalogowany = session.getAttribute("jakieId").toString();
            } catch(NullPointerException e) {
                czyZalogowany="0";
                idZalogowany="0";
            }
            try {
                ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            } catch(NullPointerException e) {
                ktoZalogowany="-1";
            }
            
            cars = dao.getReturnedCar();
            request.setAttribute("Cars", cars);
            request.setAttribute("czyZalogowany", czyZalogowany);
            request.setAttribute("ktoZalogowany", ktoZalogowany);
            request.setAttribute("idZalogowany", idZalogowany);
            request.setAttribute("wyslanoEmail", 0);
            request.setAttribute("Marki", dao.getMarki());
            view = request.getRequestDispatcher("/Samochody.jsp");
        }
        
        
        String wyswietlOfertePrzeglad = request.getParameter("ofertaPrzeglad");
        if (wyswietlOfertePrzeglad != null) {
           // Integer czyZalogowany1=Integer.parseInt(request.getParameter("czyZalogowany1"));
            //if(czyZalogowany1==null)
              //  czyZalogowany1=0;
            String czyZalogowany=new String();
            String ktoZalogowany=new String();
            String idZalogowany=new String();
            HttpSession session = request.getSession(true);
            try {
                czyZalogowany = session.getAttribute("czyZalogowany1").toString();
                idZalogowany = session.getAttribute("jakieId").toString();
            } catch(NullPointerException e) {
                czyZalogowany="0";
                idZalogowany="0";
            }
            try {
                ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            } catch(NullPointerException e) {
                ktoZalogowany="-1";
            }
            
            cars = dao.getReturnedCar();
            request.setAttribute("Cars", cars);
            request.setAttribute("czyZalogowany", czyZalogowany);
            request.setAttribute("ktoZalogowany", ktoZalogowany);
            request.setAttribute("idZalogowany", idZalogowany);
            request.setAttribute("wyslanoEmail", 0);
            request.setAttribute("Marki", dao.getMarki());
            view = request.getRequestDispatcher("/przegladSamochod.jsp");
        }
        
        
        
         String wybranoRocznik = request.getParameter("wybranoRocznik");
        if (wybranoRocznik != null) {
            
           request.setAttribute("wyswietlWypozycz",0); 
           request.setAttribute("wyswietlZakresRocznika",1); 
           request.setAttribute("wyswietlWyborRoku",0); 
            request.setAttribute("wyswietlMarke",0); 
           request.setAttribute("wyswietlWyborMarki",0); 
           view = request.getRequestDispatcher(OFERTA);
        }
        
            String wybranoMarke = request.getParameter("wybranoMarke");
        if (wybranoMarke != null) {
            request.setAttribute("wyswietlWypozycz",0); 
           request.setAttribute("wyswietlMarke",0); 
           request.setAttribute("wyswietlWyborMarki",1); 
              request.setAttribute("wyswietlZakresRocznika",0); 
           request.setAttribute("wyswietlWyborRoku",0); 
           view = request.getRequestDispatcher(OFERTA);
        }
        
        
        
        
        
        
             String zatwierdzZakresRocznik = request.getParameter("zatwierdzRocznik");
        if (zatwierdzZakresRocznik != null) {
           List<Car> test = new ArrayList<Car>();
           String poczatekRocznik=new String();
           String koniecRocznik=new String();
            String czyZalogowany=new String();
            String ktoZalogowany=new String();
            String idZalogowany=new String();
           
           request.setAttribute("wyswietlZakresRocznika",0); 
           request.setAttribute("wyswietlWyborRoku",0); 
           poczatekRocznik=request.getParameter("rocznikPoczatek");
           koniecRocznik=request.getParameter("rocznikKoniec");
  
            HttpSession session = request.getSession(true);
            try {
                czyZalogowany = session.getAttribute("czyZalogowany1").toString();
                idZalogowany = session.getAttribute("jakieId").toString();
            } catch(NullPointerException e) {
                czyZalogowany="0";
                idZalogowany="0";
            }
            try {
                ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            } catch(NullPointerException e) {
                ktoZalogowany="-1";
            }
            test=dao.getCarByYearInterval(Integer.parseInt(poczatekRocznik),Integer.parseInt(koniecRocznik));
            request.setAttribute("Cars", test);
            request.setAttribute("czyZalogowany", czyZalogowany);
            request.setAttribute("ktoZalogowany", ktoZalogowany);
            request.setAttribute("idZalogowany", idZalogowany);
            request.setAttribute("wyslanoEmail", 0);
            view = request.getRequestDispatcher("/Samochody.jsp");
        }
        
        
        String przyjmijSamochody = request.getParameter("przyjmijSamochody");
        if (przyjmijSamochody != null) {
            int wyswietlPrzyjmij=0;
            
            cars = dao.getDontReturnedCar();
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
                 request.setAttribute("wyswietlPrzyjmij", 0);
                  request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlListeKoniec", 0);
            
             if (cars.isEmpty())
                 wyswietlPrzyjmij=0;
             if (!cars.isEmpty())
                 wyswietlPrzyjmij=1;
            
            request.setAttribute("wyswietlPrzyjmij", wyswietlPrzyjmij);
            request.setAttribute("przyjmij", cars);
            view = request.getRequestDispatcher(panelPracownika);
        }
        
        String zatwierdzPrzyjmij = request.getParameter("zatwierdzPrzyjmij");
        if (zatwierdzPrzyjmij != null) {
            List<Car> test = new ArrayList<Car>();
            Car tmp = new Car();
            String zwrocony, idSamochod;
            test = dao.getAllCars();
            request.setAttribute("wyswietlPrzyjmij", 0);
                  request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlListeKoniec", 0);
            request.setAttribute("wyswietlPrzyjmij", 0);
            
            Rent rent=new Rent();
            RentDao rentdao=new RentDao();
            
            for (int i = 0; i < test.size(); i++) {
                zwrocony = request.getParameter(test.get(i).getId().toString());
                if (zwrocony != null) {
                        try {
                            dao.przyjmijSamochod(Integer.parseInt(zwrocony));
                            rent=rentdao.getRentByCarId(Integer.parseInt(zwrocony));
                            rentdao.endRent(rent.getIdWypozyczenie());
                        } catch (SQLException ex) {
                            Logger.getLogger(CarKontroler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
            }
        }
        
        String wyswietlMarke = request.getParameter("marka");
        if (wyswietlMarke != null) {
            String marka = request.getParameter("pole");
            String czyZalogowany=new String();
            String ktoZalogowany=new String();
            String idZalogowany=new String();
            HttpSession session = request.getSession(true);
            try {
                czyZalogowany = session.getAttribute("czyZalogowany1").toString();
                idZalogowany = session.getAttribute("jakieId").toString();
            } catch(NullPointerException e) {
                czyZalogowany="0";
                idZalogowany="0";
            }
            
            try {
                ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            } catch(NullPointerException e) {
                ktoZalogowany="-1";
            }
      
            cars = dao.getCarByBrand(marka);
            request.setAttribute("Cars", cars);
            request.setAttribute("czyZalogowany", czyZalogowany);
            request.setAttribute("ktoZalogowany", ktoZalogowany);
            request.setAttribute("idZalogowany", idZalogowany);
            request.setAttribute("wyslanoEmail", 0);
            view = request.getRequestDispatcher("/Samochody.jsp");
        }
        
           String wyswietlMarkePrzeglad = request.getParameter("markaPrzeglad");
        if (wyswietlMarkePrzeglad != null) {
            String marka = request.getParameter("pole");
            String czyZalogowany=new String();
            String ktoZalogowany=new String();
            String idZalogowany=new String();
            HttpSession session = request.getSession(true);
            try {
                czyZalogowany = session.getAttribute("czyZalogowany1").toString();
                idZalogowany = session.getAttribute("jakieId").toString();
            } catch(NullPointerException e) {
                czyZalogowany="0";
                idZalogowany="0";
            }
            
            try {
                ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            } catch(NullPointerException e) {
                ktoZalogowany="-1";
            }
      
            cars = dao.getCarByBrand(marka);
            request.setAttribute("Cars", cars);
            request.setAttribute("czyZalogowany", czyZalogowany);
            request.setAttribute("ktoZalogowany", ktoZalogowany);
            request.setAttribute("idZalogowany", idZalogowany);
            request.setAttribute("wyslanoEmail", 0);
            view = request.getRequestDispatcher("/przegladSamochod.jsp");
        }
        
        
        
        String wyswietlRok = request.getParameter("rocznik");
        if (wyswietlRok != null) {
            Integer rokOd = Integer.parseInt(request.getParameter("rokOd"));
            Integer rokDo = Integer.parseInt(request.getParameter("rokDo"));
            cars = dao.getCarByYearInterval(rokOd, rokDo);
            
            String czyZalogowany=new String();
            String ktoZalogowany=new String();
            String idZalogowany=new String();
            HttpSession session = request.getSession(true);
            try {
                czyZalogowany = session.getAttribute("czyZalogowany1").toString();
                idZalogowany = session.getAttribute("jakieId").toString();
            } catch(NullPointerException e) {
                czyZalogowany="0";
                idZalogowany="0";
            }
            try {
                ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            } catch(NullPointerException e) {
                ktoZalogowany="-1";
            }

            request.setAttribute("Cars", cars);
            request.setAttribute("czyZalogowany", czyZalogowany);
            request.setAttribute("ktoZalogowany", ktoZalogowany);
            request.setAttribute("idZalogowany", idZalogowany);
            request.setAttribute("wyslanoEmail", 0);
            view = request.getRequestDispatcher("/Samochody.jsp");
        }
        
        
            String wyswietlRokPrzeglad = request.getParameter("rocznikPrzeglad");
        if (wyswietlRokPrzeglad != null) {
            Integer rokOd = Integer.parseInt(request.getParameter("rokOd"));
            Integer rokDo = Integer.parseInt(request.getParameter("rokDo"));
            cars = dao.getCarByYearInterval(rokOd, rokDo);
            
            String czyZalogowany=new String();
            String ktoZalogowany=new String();
            String idZalogowany=new String();
            HttpSession session = request.getSession(true);
            try {
                czyZalogowany = session.getAttribute("czyZalogowany1").toString();
                idZalogowany = session.getAttribute("jakieId").toString();
            } catch(NullPointerException e) {
                czyZalogowany="0";
                idZalogowany="0";
            }
            try {
                ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            } catch(NullPointerException e) {
                ktoZalogowany="-1";
            }

            request.setAttribute("Cars", cars);
            request.setAttribute("czyZalogowany", czyZalogowany);
            request.setAttribute("ktoZalogowany", ktoZalogowany);
            request.setAttribute("idZalogowany", idZalogowany);
            request.setAttribute("wyslanoEmail", 0);
            view = request.getRequestDispatcher("/przegladSamochod.jsp");
        }
        
        
        
        
        
          String wyswietlRozliczenia = request.getParameter("rozliczenia");
        if(wyswietlRozliczenia!=null)
        {
            List<Oplaty> listaOplat = new ArrayList<Oplaty>();
            List<Car> listaSamochodow = new ArrayList<Car>();
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieRozliczenia", 1);
            listaOplat=oplatydao.getAllFee();
            listaSamochodow=dao.getAllCars();
            
            for (int i=0;i<listaOplat.size();i++)
            {
                listaOplat.get(i).setTmpMarkaSamochodu(listaSamochodow.get(i).getMarka());
                listaOplat.get(i).setTmpModelSamochodu(listaSamochodow.get(i).getModel());
                listaOplat.get(i).setTmpRejestracjaSamochodu(listaSamochodow.get(i).getRejestracja());
                //listaOplat.get(i).setTmpRejestracjaSamochodu("asd");
            }
            
            //request.setAttribute("listaSamochodow", listaSamochodow);
            request.setAttribute("listaOplat", listaOplat);
            view = request.getRequestDispatcher(panelPracownika);
        }
        
        
             String koniecUbezpieczen = request.getParameter("koniecUbezpieczen");
        if(koniecUbezpieczen!=null)
        {
            GregorianCalendar calendar= new GregorianCalendar();
       
            DateFormat dateFrm = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date myDate = new java.util.Date();
            java.sql.Date dataWypozyczenia;
            java.sql.Date aktualnaData=null;
            /*aktualnaData.setYear(calendar.get(Calendar.YEAR));
            aktualnaData.setMonth(calendar.get(Calendar.MONTH));
            aktualnaData.setDate(calendar.get(Calendar.DATE));
            */
            long roznica=0;
            
            List<Oplaty> listaOplat = new ArrayList<Oplaty>();
            List<Car> listaSamochodow = new ArrayList<Car>();
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlListeKoniec", 1);
            request.setAttribute("wyswietlPrzyjmij", 0);
            
            listaOplat=oplatydao.getAllFee();
            listaSamochodow=dao.getAllCars();
            
            for (int i=0;i<listaOplat.size();i++)
            {
                listaOplat.get(i).setTmpMarkaSamochodu(listaSamochodow.get(i).getMarka());
                listaOplat.get(i).setTmpModelSamochodu(listaSamochodow.get(i).getModel());
                listaOplat.get(i).setTmpRejestracjaSamochodu(listaSamochodow.get(i).getRejestracja());
                //listaOplat.get(i).setTmpRejestracjaSamochodu("asd");
                roznica=Math.abs(listaOplat.get(i).getZakonczenieOc().getTime() - (listaOplat.get(i).getRozpoczecieOc().getTime()));
               listaOplat.get(i).setDoKoncaOc(roznica);
            }
       
            
            
            //listaOplat.get(1).getRozpoczecieAc().ge
            //request.setAttribute("listaSamochodow", listaSamochodow);
            request.setAttribute("listaUbezpieczen", listaOplat);
            Integer tablica=0;
            for(int i=0;i<listaOplat.size();i++)
            {
               tablica=i;
               request.setAttribute(tablica.toString(), listaOplat.get(i).getTmpMarkaSamochodu()); 
            }
            
            view = request.getRequestDispatcher(panelPracownika);
        }
        
        
       String przedluzenieOC = request.getParameter("przedluzenieOC");
        if(przedluzenieOC!=null)
        {
        List<Oplaty> listaOplat = new ArrayList<Oplaty>();
        List<Car> listaSamochodow = new ArrayList<Car>();
            
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 1);
            request.setAttribute("wyswietlListeOC", 1);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlPrzyjmij", 0);
            
            listaOplat=oplatydao.getAllFee();
            listaSamochodow=dao.getAllCars();
            
            for (int i=0;i<listaOplat.size();i++)
            {
                listaOplat.get(i).setTmpMarkaSamochodu(listaSamochodow.get(i).getMarka());
                listaOplat.get(i).setTmpModelSamochodu(listaSamochodow.get(i).getModel());
                listaOplat.get(i).setTmpRejestracjaSamochodu(listaSamochodow.get(i).getRejestracja());
                //listaOplat.get(i).setTmpRejestracjaSamochodu("asd");
            }
            
            
            request.setAttribute("listaOC", listaOplat);
            view = request.getRequestDispatcher(panelPracownika);
        }
        
        
               String przedluzenieAC = request.getParameter("przedluzenieAC");
        if(przedluzenieAC!=null)
        {
        List<Oplaty> listaOplat = new ArrayList<Oplaty>();
        List<Car> listaSamochodow = new ArrayList<Car>();
            
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 1);
            request.setAttribute("wyswietlZmianaAC", 1);
            request.setAttribute("wyswietlPrzyjmij", 0);
             
             
            listaOplat=oplatydao.getAllFee();
            listaSamochodow=dao.getAllCars();
            
            for (int i=0;i<listaOplat.size();i++)
            {
                listaOplat.get(i).setTmpMarkaSamochodu(listaSamochodow.get(i).getMarka());
                listaOplat.get(i).setTmpModelSamochodu(listaSamochodow.get(i).getModel());
                listaOplat.get(i).setTmpRejestracjaSamochodu(listaSamochodow.get(i).getRejestracja());
                //listaOplat.get(i).setTmpRejestracjaSamochodu("asd");
            }
            
            
            request.setAttribute("listaAC", listaOplat);
            view = request.getRequestDispatcher(panelPracownika);
        }
        
        
        
        
           String zatwierdzZmianaOC = request.getParameter("zatwierdzZmianaOC");
        if(zatwierdzZmianaOC!=null)
        {
            List<Oplaty> wszystkieOplaty = new ArrayList<Oplaty>();
            Oplaty tmp = new Oplaty();
            String test=new String();
            String test2=new String();
            wszystkieOplaty=oplatydao.getAllFee();
            DateFormat dateFrm = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date myDate = new java.util.Date();
            java.sql.Date nowyPoczatekOc=null;
            java.sql.Date nowyKoniecOc=null;
            boolean jestZmiana=false;
            List<Oplaty> listaOplat = new ArrayList<Oplaty>();
            List<Car> listaSamochodow = new ArrayList<Car>();
            
            
            for (int i = 0; i < wszystkieOplaty.size(); i++)
            {
                try {
                    test2=request.getParameter("pocz"+wszystkieOplaty.get(i).getIdOplaty());
                    if(!test2.isEmpty())
                    {
                    myDate=dateFrm.parse(test2);
                    nowyPoczatekOc = new java.sql.Date(myDate.getTime());
                    }
                } catch (ParseException ex ) {
                    Logger.getLogger(CarKontroler.class.getName()).log(Level.SEVERE, null, ex);
                    nowyPoczatekOc=null;
                }
                
                try {
                    test=request.getParameter("kon"+wszystkieOplaty.get(i).getIdOplaty());
                    if(!test.isEmpty())
                    {
                    myDate=dateFrm.parse(test);
                    nowyKoniecOc = new java.sql.Date(myDate.getTime());
                    jestZmiana=true;
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(CarKontroler.class.getName()).log(Level.SEVERE, null, ex);
                    nowyKoniecOc=null;
                }
                    
                
                if(jestZmiana )
                {
                jestZmiana=false;    
                tmp=wszystkieOplaty.get(i);
                tmp.setRozpoczecieOc(nowyPoczatekOc);
                tmp.setZakonczenieOc(nowyKoniecOc);
                    try {
                        oplatydao.zmienDateOC(tmp.getIdOplaty(), tmp.getRozpoczecieOc(), tmp.getZakonczenieOc());
                    } catch (SQLException ex) {
                        Logger.getLogger(CarKontroler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
            
            listaOplat=oplatydao.getAllFee();
            listaSamochodow=dao.getAllCars();
            
            for (int i=0;i<listaOplat.size();i++)
            {
                listaOplat.get(i).setTmpMarkaSamochodu(listaSamochodow.get(i).getMarka());
                listaOplat.get(i).setTmpModelSamochodu(listaSamochodow.get(i).getModel());
                listaOplat.get(i).setTmpRejestracjaSamochodu(listaSamochodow.get(i).getRejestracja());
                //listaOplat.get(i).setTmpRejestracjaSamochodu("asd");
            }
            
            request.setAttribute("listaOC", listaOplat);
            view = request.getRequestDispatcher(panelPracownika);
        }
        
        
        String zatwierdzZmianaAC = request.getParameter("zatwierdzZmianaAC");
        if(zatwierdzZmianaAC!=null)
        {
            List<Oplaty> wszystkieOplaty = new ArrayList<Oplaty>();
            Oplaty tmp = new Oplaty();
            String test=new String();
            wszystkieOplaty=oplatydao.getAllFee();
            DateFormat dateFrm = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date myDate = new java.util.Date();
            java.sql.Date nowyPoczatekAc=null;
            java.sql.Date nowyKoniecAc=null;
            boolean jestZmiana=false;
            List<Oplaty> listaOplat = new ArrayList<Oplaty>();
            List<Car> listaSamochodow = new ArrayList<Car>();
            
            
            for (int i = 0; i < wszystkieOplaty.size(); i++)
            {
                try {
                    myDate=dateFrm.parse(request.getParameter("pocz"+wszystkieOplaty.get(i).getIdOplaty()));
                    nowyPoczatekAc = new java.sql.Date(myDate.getTime());
             
                } catch (ParseException ex ) {
                    Logger.getLogger(CarKontroler.class.getName()).log(Level.SEVERE, null, ex);
                    nowyPoczatekAc=null;
                }
                
                try {
                    test=request.getParameter("kon"+wszystkieOplaty.get(i).getIdOplaty());
                    if(!test.isEmpty())
                    {
                    myDate=dateFrm.parse(test);
                    nowyKoniecAc = new java.sql.Date(myDate.getTime());
                    jestZmiana=true;
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(CarKontroler.class.getName()).log(Level.SEVERE, null, ex);
                    nowyKoniecAc=null;
                }
                    
                
                if(jestZmiana)
                {
                jestZmiana=false;    
                tmp=wszystkieOplaty.get(i);
                tmp.setRozpoczecieAc(nowyPoczatekAc);
                tmp.setZakonczenieAc(nowyKoniecAc);
                    try {
                        oplatydao.zmienDateAC(tmp.getIdOplaty(), tmp.getRozpoczecieAc(), tmp.getZakonczenieAc());
                    } catch (SQLException ex) {
                        Logger.getLogger(CarKontroler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
            
            listaOplat=oplatydao.getAllFee();
            listaSamochodow=dao.getAllCars();
            
            for (int i=0;i<listaOplat.size();i++)
            {
                listaOplat.get(i).setTmpMarkaSamochodu(listaSamochodow.get(i).getMarka());
                listaOplat.get(i).setTmpModelSamochodu(listaSamochodow.get(i).getModel());
                listaOplat.get(i).setTmpRejestracjaSamochodu(listaSamochodow.get(i).getRejestracja());
                //listaOplat.get(i).setTmpRejestracjaSamochodu("asd");
            }
            
            request.setAttribute("listaAC", listaOplat);
            view = request.getRequestDispatcher(panelPracownika);
        }
        
        
        
        
        view.forward(request, response);
    }
  
}

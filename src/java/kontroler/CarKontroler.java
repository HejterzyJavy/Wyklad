package kontroler;

import dao.CarDao;
import dao.RentDao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import model.Car;
import model.Rent;
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

    public CarKontroler() {

        super();

        dao = new CarDao();

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
        List<Car> cars = new ArrayList<Car>();
        RequestDispatcher view = request.getRequestDispatcher("/panelPracownika.jsp");
       
        String zatwierdzSamochod = request.getParameter("zatwierdzSamochod");
        if (zatwierdzSamochod != null) {

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
            
            String daneZPliku="";
            InputStream isr = filePart.getInputStream();
            int x;
  
           car.setZdjecie(isr);
       
            dao.addCar(car);

        }

        String dodajSamochod = request.getParameter("dodaj");
        if (dodajSamochod != null) {
            view = request.getRequestDispatcher(DODAWANIE);
            //  view.forward(request, response); 
        }

        
         String wypozyczenie = request.getParameter("wypozyczenie");
        if(wypozyczenie !=null)
        {
                     cars = dao.getAllCars();
                     request.setAttribute("Cars", cars);
                     view = request.getRequestDispatcher("/Samochody.jsp");
        }
         
         
        
        String usunSamochod = request.getParameter("usun");
        if (usunSamochod != null) {
            cars = dao.getAllCars();
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
                    dao.deleteCar(Integer.parseInt(index));
                }

            }
            cars = dao.getAllCars();
            request.setAttribute("Cars", cars);
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
            try 
            {
            czyZalogowany = session.getAttribute("czyZalogowany1").toString();
            idZalogowany = session.getAttribute("jakieId").toString();
            }
            catch(NullPointerException e)
            {
             czyZalogowany="0";
             idZalogowany="0";
            }
            
             try 
            {
            ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            }
            catch(NullPointerException e)
            {
             ktoZalogowany="-1";
            }
            
            cars = dao.getAllCars();
            request.setAttribute("Cars", cars);
            request.setAttribute("czyZalogowany", czyZalogowany);
            request.setAttribute("ktoZalogowany", ktoZalogowany);
            request.setAttribute("idZalogowany", idZalogowany);
            request.setAttribute("wyslanoEmail", 0);
            request.setAttribute("Marki", dao.getMarki());
            view = request.getRequestDispatcher("/Samochody.jsp");
        }
        
        
        String przyjmijSamochody = request.getParameter("przyjmijSamochody");
        if (przyjmijSamochody != null) {
            int wyswietlPrzyjmij=0;
            
            cars = dao.getDontReturnedCar();
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
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
            try 
            {
            czyZalogowany = session.getAttribute("czyZalogowany1").toString();
            idZalogowany = session.getAttribute("jakieId").toString();
            }
            catch(NullPointerException e)
            {
             czyZalogowany="0";
             idZalogowany="0";
            }
            
             try 
            {
            ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            }
            catch(NullPointerException e)
            {
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
        String wyswietlRok = request.getParameter("rocznik");
        if (wyswietlRok != null) {
            Integer rokOd = Integer.parseInt(request.getParameter("rokOd"));
            Integer rokDo = Integer.parseInt(request.getParameter("rokDo"));
            cars = dao.getCarByYearInterval(rokOd, rokDo);
            
            
            
            String czyZalogowany=new String();
            String ktoZalogowany=new String();
            String idZalogowany=new String();
            HttpSession session = request.getSession(true);
            try 
            {
            czyZalogowany = session.getAttribute("czyZalogowany1").toString();
            idZalogowany = session.getAttribute("jakieId").toString();
            }
            catch(NullPointerException e)
            {
             czyZalogowany="0";
             idZalogowany="0";
            }
            
             try 
            {
            ktoZalogowany = session.getAttribute("ktoZalogowany").toString();
            }
            catch(NullPointerException e)
            {
             ktoZalogowany="-1";
            }

            
            request.setAttribute("Cars", cars);
            request.setAttribute("czyZalogowany", czyZalogowany);
            request.setAttribute("ktoZalogowany", ktoZalogowany);
            request.setAttribute("idZalogowany", idZalogowany);
            request.setAttribute("wyslanoEmail", 0);
            view = request.getRequestDispatcher("/Samochody.jsp");
        }

        view.forward(request, response);

    }

}

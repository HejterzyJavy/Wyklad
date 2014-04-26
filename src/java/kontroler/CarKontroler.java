package kontroler;

import dao.CarDao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
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
            car.setSciezkaZdjecie(request.getParameter("sciezka"));
            car.setCenaDoba(Integer.parseInt(request.getParameter("cenaDoba")));
            final Part filePart = request.getPart("pliczek");
            
            String daneZPliku="";
            InputStream isr = filePart.getInputStream();
            int x;
            /*do{
                x=isr.read();
                if (x==-1) {
                    break;
                } else
                {
                    daneZPliku+=String.valueOf((char)x);
                }
            }while(true);
            */
           car.setZdjecie(isr);
       
            dao.addCar(car);

        }

        String dodajSamochod = request.getParameter("dodaj");
        if (dodajSamochod != null) {
            view = request.getRequestDispatcher(DODAWANIE);
            //  view.forward(request, response); 
        }

        String usunSamochod = request.getParameter("usun");
        if (usunSamochod != null) {
            cars = dao.getAllCars();
            request.setAttribute("Cars", cars);
            view = request.getRequestDispatcher(panelPracownika);
            //  view.forward(request, response); 
        }

        String Edytuj = request.getParameter("edit");
        if (Edytuj != null) {

            cars = dao.getAllCars();
            request.setAttribute("Edit", cars);
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

                        dao.update(test.get(i).getId(), test.get(i));
                   // dao.updateCar(test.get(i));
                        // dao.updatePrzebieg(test.get(i).getId(), Integer.parseInt(przebieg));

                    }
                }
            }

            cars = dao.getAllCars();
            request.setAttribute("Edit", cars);
            view = request.getRequestDispatcher(panelPracownika);
        }

        String wyswietlOferte = request.getParameter("oferta");
        if (wyswietlOferte != null) {
           // Integer czyZalogowany1=Integer.parseInt(request.getParameter("czyZalogowany1"));
            //if(czyZalogowany1==null)
              //  czyZalogowany1=0;
            String czyZalogowany=new String();
            HttpSession session = request.getSession(true);
            try 
            {
            czyZalogowany = session.getAttribute("czyZalogowany1").toString();
            }
            catch(NullPointerException e)
            {
             czyZalogowany="0";
            }
            
            cars = dao.getAllCars();
            request.setAttribute("Cars", cars);
            request.setAttribute("czyZalogowany", czyZalogowany);
            view = request.getRequestDispatcher("/Samochody.jsp");
        }
        
        
        String wyswietlMarke = request.getParameter("marka");
        if (wyswietlMarke != null) {
            String marka = request.getParameter("pole");
            cars = dao.getCarByBrand(marka);
            request.setAttribute("Cars", cars);
            view = request.getRequestDispatcher(OFERTA);
        }
        String wyswietlRok = request.getParameter("rocznik");
        if (wyswietlRok != null) {
            Integer rokOd = Integer.parseInt(request.getParameter("rokOd"));
            Integer rokDo = Integer.parseInt(request.getParameter("rokDo"));

            cars = dao.getCarByYearInterval(rokOd, rokDo);
            request.setAttribute("Cars", cars);
            view = request.getRequestDispatcher(OFERTA);
        }

        view.forward(request, response);

    }

}

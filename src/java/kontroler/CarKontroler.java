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
import javax.servlet.http.Part;
import model.Car;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB                                              // specifies servlet takes multipart/form-data
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
            
             // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
         
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            System.out.println(">>>"+fileName);
            part.write(savePath + File.separator + fileName);
        }
 
        System.out.println("Upload has been done successfully!");

           
   
           
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
            cars = dao.getAllCars();
            request.setAttribute("Cars", cars);
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

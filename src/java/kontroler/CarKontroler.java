package kontroler;

import java.io.IOException;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import dao.CarDao;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;

import model.Car;
import static sun.rmi.transport.TransportConstants.Return;

public class CarKontroler extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static String INSERT_OR_EDIT = "/user.jsp";

    private static String LIST_USER = "/listUser.jsp";
    
    private static String INDEX = "/index.html";
    
    private static String ZALOGOWANY = "/Zalogowany.jsp";
    
    private static String OFERTA="/Oferta.jsp";

    private CarDao dao;

    private boolean czyZalogowany=false;
    
    
    public CarKontroler() {

        super();

        dao = new CarDao();

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
        RequestDispatcher view=request.getRequestDispatcher(OFERTA);
        
      
        
        String wyswietlOferte=request.getParameter("oferta");
        if(wyswietlOferte!=null)
        {
           cars=dao.getAllCars();
           
        }
        String wyswietlMarke=request.getParameter("marka");
        if(wyswietlMarke!=null)
        {
           String marka=request.getParameter("pole");
           cars=dao.getCarByBrand(marka);
           
        }
        String wyswietlRok=request.getParameter("rocznik");
        if(wyswietlRok!=null)
        {
           Integer rokOd=Integer.parseInt(request.getParameter("rokOd")) ;
           Integer rokDo=Integer.parseInt(request.getParameter("rokDo")) ;
           
           cars=dao.getCarByYearInterval(rokOd, rokDo);
        }
        
        
        request.setAttribute("Cars", cars);
        view.forward(request, response);

    }

}

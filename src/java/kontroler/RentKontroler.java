/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kontroler;

import dao.CarDao;
import dao.RentDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import model.Rent;

/**
 *
 * @author Adrian
 */
public class RentKontroler extends HttpServlet {

    
     private static String WYPOZYCZENIE="/Wypozyczanie.jsp";
    
     private CarDao cardao;
     
     private RentDao rentdao;
     
     
        public RentKontroler() {
        super();
        cardao = new CarDao();
        rentdao= new RentDao();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Car car = new Car();
        Rent rent=new Rent();
        Date data=new Date();
        List<Car> cars = new ArrayList<Car>();
        RequestDispatcher view=request.getRequestDispatcher(WYPOZYCZENIE);
        
            String wypozyczSamochod=request.getParameter("wypozyczenie");
        if(wypozyczSamochod!=null)
        {
          cars=cardao.getAllCars();
          request.setAttribute("Cars", cars);
          view=request.getRequestDispatcher(WYPOZYCZENIE);
          rent.setIdWypozyczenie(5);
          rent.setIdUser(1);
          rent.setIdSamochod(1);
          data.setYear(1111);
          data.setMonth(07);
          data.setDate(11);
          rent.setDataWypozyczenia(data);
         /* data.setYear(2014);
          data.setMonth(06);
          data.setDate(22);
          */
          rent.setDataZwrotu(data);
          rent.setStatus("oczekujace na akceptacje");
          rentdao.addRent(rent);
        //  view.forward(request, response); 
        }
        
        
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

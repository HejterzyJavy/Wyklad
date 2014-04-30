/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kontroler;

import dao.CarDao;
import dao.RentDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import model.Rent;
import model.User;

/**
 *
 * @author Adrian
 */
public class RentKontroler extends HttpServlet {

    
     private static String WYPOZYCZENIE="/Wypozyczanie.jsp";
    
     private static String panelPracownika="/panelPracownika.jsp";
     
     private static String wypozyczanieSamochodu="/wypozyczanieSamochodu.jsp";
     
     private CarDao cardao;
     
     private RentDao rentdao;
     
     private UserDao userdao;
     
        public RentKontroler() {
        super();
        cardao = new CarDao();
        rentdao= new RentDao();
        userdao=new UserDao();
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
        List<Rent> rents = new ArrayList<Rent>();
        List<User> users = new ArrayList<User>();
        RequestDispatcher view=request.getRequestDispatcher(panelPracownika);
        
       
        String akceptujWypozyczenia=request.getParameter("akceptujWypozyczenia");
        if(akceptujWypozyczenia!=null)
        {
            Integer wyswietlZatwierdzAkceptacja=0; 
            cars=cardao.getAllCars();
            rents=rentdao.getDontAcceptRents();
            users=userdao.getAllUsers();
                 if(rents.size()>0)
                wyswietlZatwierdzAkceptacja=1;
            if(rents.isEmpty())
                wyswietlZatwierdzAkceptacja=0;
            request.setAttribute("wyswietlanieAkceptacja", wyswietlZatwierdzAkceptacja);
            request.setAttribute("Rents", rents);
            request.setAttribute("Cars2", cars);
            request.setAttribute("Users", users);
            view=request.getRequestDispatcher(panelPracownika);
       
        }
        
        
        String wypozycSamochod=request.getParameter("wypozyczSamochod");
        if(wypozycSamochod!=null)
        {
            Rent wypozyczenie=new Rent();
            
            wypozyczenie.setIdSamochod(Integer.SIZE);
        }
        
        
        String jakiSamochod=request.getParameter("jakiSamochod");
        if(jakiSamochod!=null)
        {
            Car wypozyczanySamochod=cardao.getCarById(Integer.parseInt(jakiSamochod));
            Calendar calendar= Calendar.getInstance();
            Integer dzien=calendar.get(Calendar.DATE);
            Integer miesiac=calendar.get(Calendar.MONTH);
            Integer rok=calendar.get(Calendar.YEAR);
            String aktualnaData=new String();
            
            if(miesiac>9 && dzien>9)
            aktualnaData=rok+"-"+miesiac+"-"+dzien;
            if(miesiac<10)
            aktualnaData=rok+"-0"+miesiac+"-"+dzien;    
            if(dzien<10)
            aktualnaData=rok+"-"+miesiac+"-0"+dzien;  
            if(dzien<10 && miesiac<10)
            aktualnaData=rok+"-0"+miesiac+"-0"+dzien;  
            
            
            request.setAttribute("ostatniId", rentdao.getLastId());
            request.setAttribute("idSamochodu", wypozyczanySamochod.getId());
            request.setAttribute("aktualnaData", aktualnaData);
           
            request.setAttribute("wypozyczanySamochod", wypozyczanySamochod);
            view=request.getRequestDispatcher(wypozyczanieSamochodu);
        }
        
        
        String obliczKwote=request.getParameter("obliczKwote");
        if(obliczKwote!=null)
        {
            String dataWypozyczenia=request.getParameter("dataWypozyczenia");
            Integer rokWypozyczenie=Integer.parseInt(dataWypozyczenia.substring(0, 3));
            Integer miesiacWypozyczenie=Integer.parseInt(dataWypozyczenia.substring(5, 6));
            Integer dzienWypozyczenie=Integer.parseInt(dataWypozyczenia.substring(8, 9));
            
            Date dataPoczatek=new Date();
            dataPoczatek.setDate(dzienWypozyczenie);
            dataPoczatek.setMonth(miesiacWypozyczenie);
            dataPoczatek.setYear(rokWypozyczenie);
            
            
              String dataZwrotu=request.getParameter("dataZwrotu");
            Integer rokZwrotu=Integer.parseInt(dataZwrotu.substring(0, 3));
            Integer miesiacZwrotu=Integer.parseInt(dataZwrotu.substring(5, 6));
            Integer dzienZwrotu=Integer.parseInt(dataZwrotu.substring(8, 9));
            
            Date dataKoniec=new Date();
            dataKoniec.setDate(dzienZwrotu);
            dataKoniec.setMonth(miesiacZwrotu);
            dataKoniec.setYear(rokZwrotu);
            
            
            
        }
        
        
        
        String zatwierdzAkceptuj=request.getParameter("akceptuj");
                if(zatwierdzAkceptuj!=null)
                {
             List<Rent> test = new ArrayList<Rent>();
             Rent tmp = new Rent();
             test=rentdao.getAllRents();
             String status="",opis="";
             
             for (int i=0;i<test.size();i++)
             {
                 status=request.getParameter("akc"+test.get(i).getIdWypozyczenie());
                 if(status!=null && !status.equals(test.get(i).getStatus()))
                 {
                    opis=request.getParameter(test.get(i).getIdWypozyczenie().toString()); 
                    tmp=test.get(i);
                    tmp.setStatus(status);
                    tmp.setOpis(opis);
                    rentdao.updateRent(tmp);
                 }
             }
            Integer wyswietlZatwierdzAkceptacja=0; 
             
            
            
            cars=cardao.getAllCars();
            rents=rentdao.getDontAcceptRents();
            if(rents.size()>0)
                wyswietlZatwierdzAkceptacja=1;
            if(rents.isEmpty())
                wyswietlZatwierdzAkceptacja=0;
            
            users=userdao.getAllUsers();
            request.setAttribute("wyswietlanieAkceptacja", wyswietlZatwierdzAkceptacja);
            request.setAttribute("Rents", rents);
            request.setAttribute("Cars2", cars);
            request.setAttribute("Users", users);
            view=request.getRequestDispatcher(panelPracownika);
                }
        
        
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

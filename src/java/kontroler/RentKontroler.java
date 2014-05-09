/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kontroler;

import dao.CarDao;
import dao.RentDao;
import dao.UserDao;
import email.Email;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.Rent;
import model.User;
import pdf.GenerowaniePdf;

/**
 *
 * @author Adrian
 */
public class RentKontroler extends HttpServlet {

    
     private static String WYPOZYCZENIE="/Wypozyczanie.jsp";
    
     private static String panelPracownika="/panelPracownika.jsp";
     
     private static String wypozyczanieSamochodu="/wypozyczanieSamochodu.jsp";
     
     private static String OFERTA="/Samochody.jsp";
     
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
            users=userdao.getAllUsers();
            rents=rentdao.getAcceptRents(cars,users);
            
                 if(rents.size()>0)
                wyswietlZatwierdzAkceptacja=1;
            if(rents.isEmpty())
                wyswietlZatwierdzAkceptacja=0;
            request.setAttribute("wyswietlanieAkceptacja", wyswietlZatwierdzAkceptacja);
            
            
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 1);
            
            request.setAttribute("Rents", rents);
            request.setAttribute("Cars2", cars);
            request.setAttribute("Users", users);
            view=request.getRequestDispatcher(panelPracownika);
       
        }
        
    
        
        
        
        String wypozyczSamochod=request.getParameter("wypozyczSamochod");
        if(wypozyczSamochod!=null)
        {
            HttpSession session = request.getSession(true);
            Rent wypozyczenie=new Rent();
            String idUser=session.getAttribute("jakieId").toString();
            String idSamochod=session.getAttribute("idSamochodu").toString();
            DateFormat dateFrm = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date myDate = new java.util.Date();
            java.sql.Date dataWypozyczenia;
            java.sql.Date dataZwrotu;
            
           
            
               try
               {
               myDate = dateFrm.parse(request.getParameter("dataWypozyczenia"));
               dataWypozyczenia = new java.sql.Date(myDate.getTime());
               myDate = dateFrm.parse(request.getParameter("dataZwrotu"));
               dataZwrotu=new java.sql.Date(myDate.getTime());
               }
               catch (Exception e)
               {
               dataWypozyczenia = null;
               dataZwrotu = null;
               }
            
               long roznica = Math.abs(dataWypozyczenia.getTime() - dataZwrotu.getTime());
               long wynik=(roznica / ((long) (1000 * 60 * 60 * 24)))*cardao.getCarById(Integer.parseInt(idSamochod)).getCenaDoba();
               
            
            wypozyczenie.setIdWypozyczenie(rentdao.getLastId());
            wypozyczenie.setIdUser(Integer.parseInt(idUser));
            wypozyczenie.setIdSamochod(Integer.parseInt(idSamochod));
            wypozyczenie.setDoZaplaty(wynik);
            wypozyczenie.setDataWypozyczenia(dataWypozyczenia);
            wypozyczenie.setDataZwrotu(dataZwrotu);
            wypozyczenie.setStatus("oczekujace");
            wypozyczenie.setOpis("");
            wypozyczenie.setZakonczono(0);
          
            rentdao.addRent(wypozyczenie);

            request.setAttribute("wyslanoEmail", 1);
            
            view=request.getRequestDispatcher(OFERTA);
        }
        
        
        String jakiSamochod=request.getParameter("jakiSamochod");
        if(jakiSamochod!=null)
        {
            Car wypozyczanySamochod=cardao.getCarById(Integer.parseInt(jakiSamochod));
            Integer obliczanieKwoty=0;
            Calendar calendar= Calendar.getInstance();
            Integer dzien=calendar.get(Calendar.DATE);
            Integer miesiac=calendar.get(Calendar.MONTH);
            Integer rok=calendar.get(Calendar.YEAR);
            String aktualnaData=new String();
            HttpSession session = request.getSession(true);
            miesiac++;
            String userid=session.getAttribute("jakieId").toString();
            ///////////////////////
            User klient=userdao.getUserById(Integer.parseInt(userid));
            ////////////////////
            if(miesiac>9 && dzien>9)
            aktualnaData=rok+"-"+miesiac+"-"+dzien;
            if(miesiac<10)
            aktualnaData=rok+"-0"+miesiac+"-"+dzien;    
            if(dzien<10)
            aktualnaData=rok+"-"+miesiac+"-0"+dzien;  
            if(dzien<10 && miesiac<10)
            aktualnaData=rok+"-0"+miesiac+"-0"+dzien;  
            
            request.setAttribute("obliczanieKwoty", obliczanieKwoty);
            request.setAttribute("ostatniId", rentdao.getLastId());
            request.setAttribute("daneKlient", klient);
            request.setAttribute("daneSamochodu", wypozyczanySamochod);
            session.setAttribute("idSamochodu", wypozyczanySamochod.getId());
            request.setAttribute("aktualnaData", aktualnaData);
            
            
            request.setAttribute("wypozyczanySamochod", wypozyczanySamochod);
            view=request.getRequestDispatcher(wypozyczanieSamochodu);
        }
        
        

        
        
        String obliczKwote=request.getParameter("obliczKwote");
        if(obliczKwote!=null)
        {
            HttpSession session = request.getSession(true);
            String idSamochod=session.getAttribute("idSamochodu").toString();
            DateFormat dateFrm = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date myDate = new java.util.Date();
            java.sql.Date dataWypozyczenia;
            java.sql.Date dataZwrotu;
            long wynik=0;
            Integer obliczanieKwoty=1;
            Car samochod=new Car();
            
            String tmpDataWyp=new String(),tmpDataZak=new String();
            String userid=session.getAttribute("jakieId").toString();
            String carid=session.getAttribute("idSamochodu").toString();
            ///////////////////////
            User klient=userdao.getUserById(Integer.parseInt(userid));
            
               try
               {
               myDate = dateFrm.parse(request.getParameter("dataWypozyczenia"));
               dataWypozyczenia = new java.sql.Date(myDate.getTime());
               tmpDataWyp=dataWypozyczenia.toString();
               myDate = dateFrm.parse(request.getParameter("dataZwrotu"));
               dataZwrotu=new java.sql.Date(myDate.getTime());
               tmpDataZak=dataZwrotu.toString();
               }
               catch (Exception e)
               {
               dataWypozyczenia = null;
               dataZwrotu = null;
               }
             
               long roznica = Math.abs(dataWypozyczenia.getTime() - dataZwrotu.getTime());
                wynik=(roznica / ((long) (1000 * 60 * 60 * 24)))*cardao.getCarById(Integer.parseInt(idSamochod)).getCenaDoba();
               request.setAttribute("daneKlient", klient);
               request.setAttribute("obliczanieKwoty", obliczanieKwoty);
               request.setAttribute("doZaplaty", wynik);
               samochod=cardao.getCarById(Integer.parseInt(carid));
               request.setAttribute("wypozyczanySamochod", samochod);
               request.setAttribute("dataWypozyczenia", tmpDataWyp);
               request.setAttribute("dataZwrotu", tmpDataZak);
               
               view=request.getRequestDispatcher(wypozyczanieSamochodu);
            
        }
        
         String wyswietlNieZwrocone=request.getParameter("nieZwrocone");
                if(wyswietlNieZwrocone!=null)
                {
            Integer wyswietlZatwierdzAkceptacja=0; 
            cars=cardao.getAllCars();
            users=userdao.getAllUsers();
            rents=rentdao.getAllHistory(cars,users);
            
                 if(rents.size()>0)
                wyswietlZatwierdzAkceptacja=1;
            if(rents.isEmpty())
                wyswietlZatwierdzAkceptacja=0;
            request.setAttribute("wyswietlanieAkceptacja", wyswietlZatwierdzAkceptacja);
            
            
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 0);
            
            request.setAttribute("Historia", rents);
            request.setAttribute("Cars2", cars);
            request.setAttribute("Users", users);
            view=request.getRequestDispatcher(panelPracownika);
                }
        
        
        
        
        String zatwierdzAkceptuj=request.getParameter("akceptuj");
                if(zatwierdzAkceptuj!=null)
                {
             List<Rent> test = new ArrayList<Rent>();
             Rent tmp = new Rent();
             GenerowaniePdf umowa=new GenerowaniePdf();
             test=rentdao.getAllRents();
             String status="",opis="";
              Email email=new Email();
             int idWypozyczenia=0;
             User klient=new User();
             Car samochod=new Car();
             
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
                    
                    if(tmp.getStatus().equalsIgnoreCase("zaakceptowane"))
                    {
                        
                           tmp=test.get(i);
                           umowa.generujUmowe(cardao.getCarById(tmp.getIdSamochod())
                           ,userdao.getUserById(tmp.getIdUser()),rentdao.getRentById(tmp.getIdWypozyczenie()));
                        
                        klient=userdao.getUserById(tmp.getIdUser());
                        email.wyslijAkceptacja("zaakceptowane",klient.getEmail());
                          
                            try {
                            cardao.wypozyczSamochod(tmp.getIdSamochod());
                            } catch (SQLException ex) {
                            Logger.getLogger(RentKontroler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                    }
                    
                    if(tmp.getStatus().equalsIgnoreCase("odrzucone"))
                    {
                       
                        tmp=test.get(i);
                        samochod=cardao.getCarById(tmp.getIdSamochod());
                        klient=userdao.getUserById(tmp.getIdUser());
                        email.wyslijOdrzucenie(tmp.getOpis(),klient.getEmail(),samochod.getMarka(),samochod.getModel());
                    }
                    
                    
                 }
             }
            Integer wyswietlZatwierdzAkceptacja=0; 
            
        
            cars=cardao.getAllCars();
            users=userdao.getAllUsers();
            rents=rentdao.getAcceptRents(cars,users);
            
            if(rents.size()>0)
                wyswietlZatwierdzAkceptacja=1;
            if(rents.isEmpty())
                wyswietlZatwierdzAkceptacja=0;
            
            
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlanieAkceptacja", 1);
            request.setAttribute("wyswietlanieAkceptacja", wyswietlZatwierdzAkceptacja);
            request.setAttribute("Rents", rents);
            request.setAttribute("Cars2", cars);
            request.setAttribute("Users", users);
            view=request.getRequestDispatcher(panelPracownika);
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

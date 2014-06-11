package kontroler;

import dao.UserDao;
import email.Email;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserKontroler extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static String INSERT_OR_EDIT = "/user.jsp";

    private static String LIST_USER = "/listUser.jsp";
    
    private static String INDEX = "/index.html";
    
    private static String ZALOGOWANY = "/Oferta.jsp";
    
    private static String LOGOWANIE="/Log.jsp";
    
    private static String REJESTRACJA="/Rej.jsp";
    
    private static String zalogowanyPRACOWNIK="/panelPracownika.jsp";
    
    private static String OFERTA = "/Oferta.jsp";

    private UserDao dao;

    private boolean czyZalogowany=false;
    
    private Integer logowanie=new Integer(0);
    
    private Pattern pattern;
    
    private Matcher matcher;
    
    private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    
    public UserKontroler() {

        super();

        dao = new UserDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int userId = Integer.parseInt(request.getParameter("userId"));

            dao.deleteUser(userId);

            forward = LIST_USER;

            request.setAttribute("users", dao.getAllUsers());

        } else if (action.equalsIgnoreCase("edit")) {

            forward = INSERT_OR_EDIT;

            int userId = Integer.parseInt(request.getParameter("userId"));

            User user = dao.getUserById(userId);

            request.setAttribute("user", user);

        } else if (action.equalsIgnoreCase("listUser")) {

            forward = LIST_USER;

            request.setAttribute("users", dao.getAllUsers());

        } else {

            forward = INSERT_OR_EDIT;

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        
        
        
        String login = request.getParameter("login");
        if (login == null || login.trim().isEmpty()) {
            messages.put("login", "To pole nie może być puste");
        } else if (!login.matches("\\p{Alnum}+")) {
            messages.put("login", "Tylko litery");
        }
        
        User user = new User();
        
        RequestDispatcher view=request.getRequestDispatcher(INDEX);

        
        
        String wylogowanie= request.getParameter("wylogowanie");
        if(wylogowanie!=null)
        {
            logowanie=0;
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlPrzyjmij", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlListeKoniec", 0);
            
            HttpSession session = request.getSession(true);
            session.setAttribute("czyZalogowany1", logowanie);
            view = request.getRequestDispatcher(LOGOWANIE);
        }
        
        
        String SprawdzOferte=request.getParameter("Oferta");
        if(SprawdzOferte!=null && czyZalogowany)
        {
            view = request.getRequestDispatcher(OFERTA);
            System.out.print("wcisnieta oferta");
            
        }
        String Promocje=request.getParameter("Promocje");
        if(Promocje!=null && czyZalogowany)
        {
            System.out.print("wcisnieta Promocje");
            
        }
        String Sprzedaz=request.getParameter("Sprzedaz");
          if(Sprzedaz!=null && czyZalogowany)
        {
            System.out.print("wcisnieto Sprzedaz");
          
        }
          
              String panelKlienta=request.getParameter("panelKlienta");
          if(panelKlienta!=null)
        {
            view = request.getRequestDispatcher(ZALOGOWANY);

        }
          
             String panelPracownika=request.getParameter("panelPracownika");
          if(panelPracownika!=null)
        {
            view = request.getRequestDispatcher(zalogowanyPRACOWNIK);
             request.setAttribute("wyswietlanieAkceptacja", 0);
            
            
            request.setAttribute("wyswietlEdycje", 0);
            request.setAttribute("wyswietlUsun", 0);
            request.setAttribute("wyswietlPrzyjmij", 0);
            request.setAttribute("wyswietlanieRozliczenia", 0);
            request.setAttribute("wyswietlZmianaOC", 0);
            request.setAttribute("wyswietlListeOC", 0);
            request.setAttribute("wyswietlListeAC", 0);
            request.setAttribute("wyswietlZmianaAC", 0);
            request.setAttribute("wyswietlListeKoniec", 0);
        }
          
          
           String powrotLogowanie=request.getParameter("powrotLogowanie");
        if(powrotLogowanie!=null)
        {
            view = request.getRequestDispatcher(LOGOWANIE);
        }
          
          
        String zapomnialemHasla=request.getParameter("zapomnialemHasla");
        if(zapomnialemHasla!=null)
        {
            Email email=new Email();
            String hasloWysylka=new String();
            String podanyLogin=new String();
            String podanyEmail=new String();
            podanyLogin=request.getParameter("podanyLogin");
            podanyEmail=request.getParameter("podanyEmail");
            if(dao.sprawdzLogin(podanyLogin) && dao.sprawdzEmail(podanyEmail))
            {
                hasloWysylka=dao.getPasswordByLogin(podanyLogin);
                email.przypomnijHaslo(podanyEmail, hasloWysylka);
                request.setAttribute("komunikatPrzypomnienie", "Haslo zostało wysłane na adres e-mail");
            }
            else
            {
             request.setAttribute("komunikatPrzypomnienie", "Błędny login lub e-mail");   
            }
            view = request.getRequestDispatcher("zapomnialemHasla.jsp");
        }
          
        
        String Rejestruj=request.getParameter("Rejestruj");
        if(Rejestruj!=null)
        {
            
            List<String> bledyRejestracja = new ArrayList<String>();
            boolean danePoprawne=true;
            String powtorzHaslo=new String();
            pattern = Pattern.compile(EMAIL_PATTERN);
            
        user.setLogin(request.getParameter("login"));
        user.setHaslo(request.getParameter("haslo"));
        powtorzHaslo=request.getParameter("powtorzHaslo");
        user.setAdres(request.getParameter("adres"));
        user.setKodPocztowy(request.getParameter("kodPocztowy"));
        user.setTelefon(request.getParameter("telefon"));
        user.setImie(request.getParameter("imie"));
        user.setNazwisko(request.getParameter("nazwisko"));
        user.setPesel(request.getParameter("pesel"));
            
            
            System.out.println("\n AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
        try {

            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));

            user.setDob(dob);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        user.setEmail(request.getParameter("email"));
        String userid = request.getParameter("userid");
        matcher = pattern.matcher(user.getEmail());
        
        if(user.getImie().length()<=2)
        {
            danePoprawne=false;
            bledyRejestracja.add("Imie jest za krótkie");
        }
        if(user.getNazwisko().length()<=2)
        {
            danePoprawne=false;
            bledyRejestracja.add("Nazwisko jest za krótkie");
        }
        if(!user.getHaslo().equals(powtorzHaslo))
        {
            danePoprawne=false;
            bledyRejestracja.add("Hasla różnią się od siebie");
        }
        if(!matcher.matches())
        {
            danePoprawne=false;
            bledyRejestracja.add("Niepoprawny Adres E-mail");
        }
        if(dao.sprawdzLogin(user.getLogin()))
        {
            danePoprawne=false;
            bledyRejestracja.add("Konto z podanym Loginem juz istnieje");
        }
         if(dao.sprawdzHaslo(user.getHaslo()))
        {
            danePoprawne=false;
            bledyRejestracja.add("Konto z podanym Haslem juz istnieje");
        }
        
                
        if(danePoprawne)
        {
        if (userid == null || userid.isEmpty()) {
            dao.addUser(user);
        } else {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
        view = request.getRequestDispatcher(LOGOWANIE);
        }
        else if(!danePoprawne)
        {
            request.setAttribute("bledyRejestracja", bledyRejestracja);
            view = request.getRequestDispatcher(REJESTRACJA);
        }
        
        
        }
        //}
        
        
        String Zaloguj=request.getParameter("Logowanie");
        if (Zaloguj != null) {
            
            HttpSession session = request.getSession(true);
            
            user.setLogin(request.getParameter("login"));
            user.setHaslo(request.getParameter("haslo"));

            System.out.println("logowanie");
            if (dao.zaloguj(user.getLogin(), user.getHaslo())==0) {
                czyZalogowany = true;
                logowanie=1;
                System.out.println("zalogowany");
                session.setAttribute("czyZalogowany1", logowanie);
                session.setAttribute("ktoZalogowany", 0);
                session.setAttribute("jakieId", dao.jakieId(user.getLogin(), user.getHaslo()));
                view = request.getRequestDispatcher(ZALOGOWANY);
            }
            if (dao.zaloguj(user.getLogin(), user.getHaslo())==1) {
                czyZalogowany = true;
                logowanie=1;
                System.out.println("zalogowany");
                session.setAttribute("czyZalogowany1", logowanie);
                session.setAttribute("ktoZalogowany", 1);
                session.setAttribute("jakieId", dao.jakieId(user.getLogin(), user.getHaslo()));
                request.setAttribute("wyswietlEdycje", 0);
                request.setAttribute("wyswietlUsun", 0);
                request.setAttribute("wyswietlPrzyjmij", 0);
                request.setAttribute("wyswietlanieRozliczenia", 0);
                request.setAttribute("wyswietlZmianaOC", 0);
                request.setAttribute("wyswietlListeOC", 0);
                request.setAttribute("wyswietlListeAC", 0);
                request.setAttribute("wyswietlZmianaAC", 0);
                request.setAttribute("wyswietlListeKoniec", 0);
                request.setAttribute("wyswietlanieAkceptacja", 0);
                
                
                view = request.getRequestDispatcher(zalogowanyPRACOWNIK);
            } 
            else if (dao.zaloguj(user.getLogin(), user.getHaslo())==-1) {
                System.out.println("niezalogowany");
                logowanie=0;
                System.out.println("zalogowany");
                session.setAttribute("czyZalogowany1", logowanie);
                czyZalogowany = false;
                messages.put("loginHaslo", "Niepoprawny login lub haslo");
                messages.put("pokaz", "false");
                view = request.getRequestDispatcher("/Log.jsp");
            }
        }
        
        
         
       // request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pakiet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrian
 */
public class Rejestracja extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
         
            Integer jak=new Integer(2);
            /*String imie = request.getParameter( "imie" );
            String nazwisko = request.getParameter( "nazwisko" );
            String login = request.getParameter( "login" );
            String haslo = request.getParameter( "haslo" );
            String adres = request.getParameter( "adres" );
            String Nrdowodu=request.getParameter( "Nrdowodu" );
            String email = request.getParameter( "email" );*/
            
            Osoba osoba=new Osoba (request.getParameter( "parametr1" ),request.getParameter( "parametr2" ),
            request.getParameter( "parametr3" ),request.getParameter( "parametr4" ),request.getParameter( "parametr5" ),
               request.getParameter( "parametr6" ),request.getParameter( "parametr7" ));
            
DodajOsobe dodaj = new DodajOsobe();

String wynik = dodaj.sprawdzDane(osoba);
request.setAttribute("jak", jak);
request.setAttribute( "styles", wynik );
RequestDispatcher view = request.getRequestDispatcher("wyniki.jsp" );
view.forward( request, response );
            
        } finally {
            out.close();
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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

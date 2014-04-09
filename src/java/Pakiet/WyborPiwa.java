/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pakiet;

import dao.UserDao;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.User;
import org.apache.catalina.connector.Request;

public class WyborPiwa extends HttpServlet {

    private UserDao dao;

    public WyborPiwa() {
        super();
        dao = new UserDao();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Integer jak = new Integer(1);
        String login = request.getParameter("login");
        String haslo = request.getParameter("haslo");

        User user = new User();
        user = dao.getUserById(1);  
        String wynik = "nie";
        if(user.getNazwisko().equals(haslo)) wynik = "tak";
        request.setAttribute("jak", jak);
        request.setAttribute("styles", wynik);
        RequestDispatcher view = request.getRequestDispatcher("wyniki.jsp");
        view.forward(request, response);
    }
}

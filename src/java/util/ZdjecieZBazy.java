package util;

import dao.CarDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karol
 */

public class ZdjecieZBazy extends HttpServlet {
     private CarDao dao;
    
     public ZdjecieZBazy() {
        super();
        dao = new CarDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Blob imageToReturn = dao.getCarImage(id);
        System.out.println(imageToReturn);
                response.setContentType("image/jpg");
                InputStream in = null;
                OutputStream out = null;
                try {
                        response.setContentLength((int) imageToReturn.length());
                        in = imageToReturn.getBinaryStream();
                        out = response.getOutputStream(); 
                        byte[] buf = new byte[1024];
                        int count = 0;
                        while ((count = in.read(buf)) >= 0) {
                                out.write(buf, 0, count);
                        }
                } catch (SQLException e) {
                        // do something useful when reading image from DB fails
                } finally {
                
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

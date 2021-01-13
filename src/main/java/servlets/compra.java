/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class compra extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String paginaSiguiente;
            paginaSiguiente = request.getParameter("pasoSiguiente");
            Cookie cookie = new Cookie("paginaSiguiente", paginaSiguiente);
            paginaSiguiente = cookie.getValue();
            Cookie[] cookies_recb = request.getCookies();
            if (cookies_recb != null && paginaSiguiente == null) {
                for (int i = 0; i < cookies_recb.length; i++) {
                    if(cookies_recb[i].getValue().equals("2")){
                        cookie.setMaxAge(1440);
                        cookie.setValue("2");
                        response.addCookie(cookie);
                        paginaSiguiente = "2";
                        break;
                    }else if(cookies_recb[i].getValue().equals("3")){
                        cookie.setMaxAge(1440);
                        cookie.setValue("3");
                        response.addCookie(cookie);
                        paginaSiguiente = "3";
                        break;
                    }else if(cookies_recb[i].getValue().equals("4")){
                        cookie.setMaxAge(1440);
                        cookie.setValue("4");
                        response.addCookie(cookie);
                        paginaSiguiente = "4";
                        break;
                    }else if(cookies_recb[i].getValue().equals("0")){
                        cookie.setMaxAge(-1);
                        paginaSiguiente = "0";
                        break;
                    }
                }
            }
        if (paginaSiguiente == null && cookie.getValue() == null) {
            cookie.setMaxAge(1440);
            response.addCookie(cookie);
            response.sendRedirect("paso1.html");
        } else if (paginaSiguiente.equals(2) || cookie.getValue().equals("2")) {
            cookie.setMaxAge(1440);
            response.addCookie(cookie);
            response.sendRedirect("paso2.html");
        } else if (paginaSiguiente.equals(3) || cookie.getValue().equals("3")) {
            cookie.setMaxAge(1440);
            response.addCookie(cookie);
            response.sendRedirect("paso3.html");
        } else if (paginaSiguiente.equals(4) || cookie.getValue().equals("4")) {
            cookie.setMaxAge(1440);
            response.addCookie(cookie);
            response.sendRedirect("paso4.html");
        } else if (paginaSiguiente.equals(0) || cookie.getValue().equals("0")) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.sendRedirect("index.jsp");
        }

    }

    
        finally {
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

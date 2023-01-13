package com.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})//set in web.xml
public class LogoutController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pwOut = response.getWriter();

        //remove session
        HttpSession session = request.getSession(false);
        session.invalidate();

        //print confirmation message and redirect to home page
        pwOut.print("You have successfully logged out");
        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
        view.include(request, response);
        pwOut.close();
    }
}

package com.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;
import com.model.LoginModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"}) //set in web.xml
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String EDITPG = "/edit.jsp";
    private static String ADMINPG = "/admin.jsp";
    private static String WELCMPG = "/welcome.jsp";
    //private static String REGISTPG= "/registration.jsp";
    private UserDao dao;

    public LoginController() {
        super();
        dao = new UserDao();//create new data object to interact with database
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectPage = "/index.jsp"; //default page
        String action = request.getParameter("action");

        //Removes user account from table and reloads table
        if (action.equalsIgnoreCase("remove")) {
            String username = request.getParameter("username").trim();
            dao.deleteAccount(username);
            redirectPage = ADMINPG;
            request.setAttribute("users", dao.listUsers());
        } //Loads Admin page with database data in table
        else if (action.equalsIgnoreCase("listUsers")) {
            redirectPage = ADMINPG;
            request.setAttribute("users", dao.listUsers());
        } //Finds user by ID and updates database and table with new data.
        else if (action.equalsIgnoreCase("edit")) {
            redirectPage = EDITPG;
            String username = request.getParameter("username").trim(); //get this objects id
            LoginModel user = dao.getUserByUserName(username); //user object
            request.setAttribute("user", user); //sends user data to jsp
        }

        RequestDispatcher view = request.getRequestDispatcher(redirectPage);
        view.forward(request, response); //forward response to request
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pwOut = response.getWriter();
        //get input from jsp		
        String em = request.getParameter("username");
        String pw = request.getParameter("psword");

        //Validate Login with input
        if (dao.validateLogin(em, pw)) {
            //create session and store variables
            LoginModel user = dao.userSession(em);
            HttpSession session = request.getSession(false);
            session.setAttribute("username", em);
            session.setAttribute("fullname", user.getFullName());

            //load welcome page with session data
            RequestDispatcher view = request.getRequestDispatcher(WELCMPG);
            
            view.forward(request, response);

        } //if input is not stored in database print error message and reload page
        else {
            pwOut.print("<p style=\"color:red\">Incorrect Username or Password!</p>");
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.include(request, response);

        }

        pwOut.close();

    }
}

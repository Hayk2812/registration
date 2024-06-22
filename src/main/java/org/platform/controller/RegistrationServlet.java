package org.platform.controller;

import org.platform.enams.Status;
import org.platform.exception.userExceptions.UserAlreadyExistException;
import org.platform.exception.userExceptions.UserValidationException;
import org.platform.model.User;
import org.platform.repozitory.UserRepozitory;
import org.platform.service.impl.UserServiceImpl;
import org.platform.util.TokenGeneration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String year = request.getParameter("year");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user =null;
        String errorMessagee = null;

       try {
           user = userService.createUser(name,surname,year,email,password);
       }catch (Exception e){
           if (e instanceof UserAlreadyExistException){
               errorMessagee =e.getMessage();
           } else if (e instanceof UserValidationException) {
               errorMessagee = e.getMessage();


           }
       }
       request.setAttribute("errorMessage",errorMessagee);
       if (user != null) {
           request.setAttribute("verification_code", user.getVerificationCode());
       }
       if (errorMessagee == null){
           request.getRequestDispatcher("/verification-page.jsp").forward(request,response);
       }else {
           request.getRequestDispatcher("/registration.jsp").forward(request,response);
       }
    }
}

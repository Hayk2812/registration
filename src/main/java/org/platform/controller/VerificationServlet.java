package org.platform.controller;

import org.platform.exception.userExceptions.UserNotFoundException;
import org.platform.exception.userExceptions.UserValidationException;
import org.platform.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerificationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String email = request.getParameter("email");
        String verificationCode = request.getParameter("verify-code");
        String errorMessage = null;
        try {
            userService.verification(email,verificationCode);
        }catch (Exception e){
            if (e instanceof UserNotFoundException || e instanceof UserValidationException){
              errorMessage = e.getMessage();
            }
        }
        if (errorMessage == null){
            response.sendRedirect("/home-page.jsp");

        }else {
            request.setAttribute("errorMessage",errorMessage);
            request.getRequestDispatcher("/verification-page.jsp").forward(request,response);
        }
    }
}

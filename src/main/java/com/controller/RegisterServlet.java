package com.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import com.controller.DBConnection;

@WebServlet("/registerForm")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String userEmail = req.getParameter("userEmail");
        String userPass = req.getParameter("userPassword");
        String userMob = req.getParameter("userMob");

        if(name == null || userEmail == null || userPass == null || userMob == null ||
           name.isEmpty() || userEmail.isEmpty() || userPass.isEmpty() || userMob.isEmpty()) {

            req.setAttribute("errorMsg", "All values must be filled!");
            RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
            rd.forward(req, resp);
            return;
        }

        try {

            Connection con = DBConnection.getConnection();
            
            if(con == null) {
                resp.getWriter().println("Database connection failed!");
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                "insert into users (user_name, user_password, user_email, user_mobile) values (?, ?, ?, ?)");

            ps.setString(1, name);
            ps.setString(2, userPass);
            ps.setString(3, userEmail);
            ps.setString(4, userMob);

            int rowAffected = ps.executeUpdate();

            if(rowAffected > 0) {
                req.setAttribute("successMsg", "Registration Successful!");
            }

            RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
            rd.forward(req, resp);

        } catch(Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Database Error: " + e.getMessage());
        }
    }
}

package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/loginForm")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");

        try {

            Connection con = DBConnection.getConnection();

            if(con == null) {
                resp.getWriter().println("Database connection failed!");
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                "select * from users where user_name = ? and user_password = ?");

            ps.setString(1, userName);
            ps.setString(2, userPassword);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                resp.sendRedirect("https://arya28105.github.io/portfolio/");
            }
            else {
                req.setAttribute("msg", "Wrong Username and Password!");
                RequestDispatcher rd =
                        req.getRequestDispatcher("login.jsp");
                rd.forward(req, resp);
            }

        } catch(Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}

package com.mycompany.mavenproject3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registation")
public class registation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Assuming you have appropriate form parameters in your HTML form
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");

            // Database connection and insertion logic
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ebank", "root", "");
                 PreparedStatement pst = con.prepareStatement("insert into registration(fname, lname, address, phone) values(?,?,?,?)");
                 PreparedStatement pst1 = con.prepareStatement("select max(id) from registration");
                 ResultSet rs = pst1.executeQuery()) {

                pst.setString(1, fname);
                pst.setString(2, lname);
                pst.setString(3, address);
                pst.setString(4, phone);
                pst.executeUpdate();

                rs.next();

                int regno = rs.getInt(1);

                out.println("Thank you for your Registration");
                out.println("Your Registration No is: " + regno);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grocerypos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*; // adding for database connection classes
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author alcan
 */
public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> items = new ArrayList<>();

        try {
            // load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // connect to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/grocerydb", "root", "Password1!");

            // execute SQL query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM items");

            // process results
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                items.add(name + " - $" + price);
            }

            // close connections
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // forward data to JSP
        request.setAttribute("items", items);
        RequestDispatcher dispatcher = request.getRequestDispatcher("items.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Retrieves grocery items from MySQL database.";
    }
}

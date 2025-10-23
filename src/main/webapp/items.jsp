<%-- 
    Document   : items
    Created on : Oct 18, 2025, 12:35:18 PM
    Author     : alcan
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grocery Items</title>
    </head>
    <body>
        <h1>Grocery List</h1>
        <ul>
            <%
                List<String> items = (List<String>) request.getAttribute("items");
                for (String item : items) {
            %>
            <li><%= item%></li>
                <%  }%>
        </ul>
    </body>
</html>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Grocery Items</title>
</head>
<body>
    <h1>Grocery List</h1>
    <ul>
        <%
            List<String> items = (List<String>) request.getAttribute("items");
            if (items != null && !items.isEmpty()) {
                for (String item : items) {
        %>
            <li><%= item %></li>
        <%
                }
            } else {
        %>
            <li>No items found. Check DB or servlet connection.</li>
        <%
            }
        %>
    </ul>
</body>
</html>

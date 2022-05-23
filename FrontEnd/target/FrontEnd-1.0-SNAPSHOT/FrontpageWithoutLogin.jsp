<%-- 
    Document   : FrontpageWithoutLogin
    Created on : Apr 13, 2022, 12:50:13 AM
    Author     : student
--%>

<%@page import="ESHOP.FrontEndService.Helper.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ESHOP.com</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
        body{
            background-color:#85c1e9  
        }
        </style>
    </head>
    <body>
        <div style ="position:absolute; left:800px; top:20px;">
                <form action="FrontEnd" method="post">
                <input type="hidden" name="pageName" value="login"/>
                <input type="text" placeholder="Username" name="username">
                <input type="password" placeholder="Password" name="psw">
                <button type="submit">Login</button>
                </form>
        </div>
        <div style ="position:absolute; left:525px; top:400px;font-size: 25px">
            Search Products here:
        </div>
        <div style ="position:absolute; left:525px; top:450px;font-size: 25px">
            <form action="FrontEnd" method="post">
            <input type="hidden" name="pageName" value="search"/>
            <input type="text" name='query'>
            <input type='submit' value='Enter'>
        </form>
        </div>
        <%
            ProductsXML products= (ProductsXML)request.getAttribute("ProductResults");
            if (products!=null){
        %>
        <a href="index.html" target="_self"><img src='resources/ESHOP.png' alt="ESHOP" style='width:150px'></a>
        <centre><h1>Results for <%=request.getAttribute("query")%>:</h1></centre>
        <form action="AddCart" method="post">
        <table border="2" align="center" cellpadding="5" cellspacing="5">
        <tr>
        <th> Product Name </th>
        <th> Price </th>
        <th> Add to Cart </th>
        <% for(ProductInfo product: products.getProducts()){
        %>
        <tr>
        <td> <%=product.getName()%></td>
        <td> <%=product.getPrice()%></td>
        <%}}%>
    </body>
</html>

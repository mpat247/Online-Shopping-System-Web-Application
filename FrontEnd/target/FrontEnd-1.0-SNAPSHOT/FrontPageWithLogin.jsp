<%-- 
    Document   : FrontPageWithLogin
    Created on : Mar 31, 2022, 10:20:51 PM
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
        <a href="index.html" target="_self"><img src='resources/ESHOP.png' alt="ESHOP" style='width:150px'></a>
        <h1>Hello <%=request.getAttribute("username")%></h1>
        
        <div style ="position:absolute; left:525px; top:400px;font-size: 25px">
            Search Products here:
        </div>
        <div style ="position:absolute; left:525px; top:450px;font-size: 25px">
            <form action="FrontEnd" method="post">
            <input type="hidden" name="pageName" value="search"/>
            <input type="hidden" name="token" value=<%=request.getAttribute("token")%>/>
            <input type="text" name='query'>
            <input type='submit' value='Enter'>
        </form>
        </div>
        <%
        ProductsXML products= (ProductsXML)request.getAttribute("ProductResults");
        if (products!=null){
        %>
        
        <form action="FrontEnd" method="post">
        <input type="hidden" name="pageName" value="purchase"/>
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
        <td><input type="submit" value="Purchase"> 
        </td>
        <%}}%>
    </tr>
    </table>
    </form>
        </tr>
    </body>
</html>

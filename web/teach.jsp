<%-- 
    Document   : teach
    Created on : Apr 22, 2017, 6:10:58 PM
    Author     : lijin
--%>

<%@page import="Classes.Document"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hi</h1>
        <jsp:useBean id="HW4" class="irMain.HW4Main"></jsp:useBean>
        <%
            List<Document> rs = HW4.Bookcategory();
//            Iterator iter = rs.iterator();
            for(Document doc:rs){
//            While(iter.hasNext()){
 //               doc = (Document) iter.next();
        
        %>
        <div>
            <table>
                <tr><td><%= doc.docno()%></td></tr>

            </table>
        </div>
        <%
            }
        %>
    </body>
</html>

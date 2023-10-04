<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.conn.Connec"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Uploder</title>
<%@include file="allcss.jsp" %>

<style type="text/css">
#f{
width:700px;
margin: auto;
margin-top: 30px;
box-shadow: 0px 0px 10px gray;
border-radius: 5px;
padding: 18px;

}
#ui{
text-align: center;
}
#fa{
width: 90%;
margin: auto;
margin-top: 30px;

border-radius: 5px;
padding: 18px;

}
</style>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />


</head>
<body>


<div id="f">
	<h3>Upload Your Images &nbsp <i class="fa-solid fa-cloud-arrow-up fa-2xl"></i></h3>
	
	<%
	 String suc = (String)session.getAttribute("up");
	if(suc!=null){%>
		
		
	<%}
	%>
	
	
	<form action="upload" method="post" enctype="multipart/form-data">
	  
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Image</label>
	    <input type="file" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="upimg">
	
	  </div>
	  
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Image Name</label>
	    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="imname">
	
	  </div>
	  <div style="width: 400px; margin: auto;">
	  <button type="Upload" class="btn btn-primary" style="width: 400px; margin: auto;"> <i class="fa-solid fa-upload"></i>Upload</button>
	</div>
	</form>


</div>



<div id="fa">
<h3 id="ui">Uploded Images</h3>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Files</th>
       <th scope="col">Action</th>
      <th scope="col">Names</th>
      
    </tr>
  </thead>
  <tbody>
  
  <% Connection con= Connec.getco();
    PreparedStatement ps= con.prepareStatement("select * from images");
    ResultSet rs = ps.executeQuery();
    while(rs.next()){%>
    	 <tr>
      <th scope="row">
      <%if(rs.getString(2).endsWith(".pdf")){%>
    	
        <img alt="images" src="images/he.pdf" style="width: 200px;">
     
      <%}else if(rs.getString(2).endsWith(".txt")){%>
    	  <img alt="images" src="images/download (1).png" style="width: 200px;">
      <%}else if(rs.getString(2).endsWith(".docx")){%>
        <img alt="images" src="images/show.pdf.png" style="width: 200px;">
      <%}else{%>
    	  <img alt="images" src="images/<%=rs.getString(2)%>" style="width: 200px" >
     
     <% }%>
       </th>
       
      <td><a href="xyz?v=<%=rs.getString(2)%>"><img alt="imh" src="data:image/jpeg;base64,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" width="50px" height="50px"></a></td>
		      
      <td><%=rs.getString(3) %></td>
     
    </tr>
   <%}
  %>
   
   
  </tbody>
</table>
</div>



</body>
</html>
package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.Part;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/upload")
@MultipartConfig
public class UserImg  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		jakarta.servlet.http.Part p= req.getPart("upimg");
		String filename=p.getSubmittedFileName();
		String name=req.getParameter("imname");
		 HttpSession hs = req.getSession();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Sankha325#@");
			PreparedStatement ps =con.prepareStatement("insert into images (filename,imgname) values(?,?)");
			ps.setString(2, name);
			ps.setString(1, filename);
			int a = ps.executeUpdate();
			if(a==1) {
				String path= getServletContext().getRealPath("")+"images";
				java.io.File fi = new java.io.File(path);
				p.write(path+fi.separator+filename);
				System.out.println(path);
				System.out.println("yes");
				hs.setAttribute("up", "uploded Successfully....");
				resp.sendRedirect("index.jsp");
			}else {
				System.out.println("no");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	
		
		
	
		System.out.print(filename+" "+name);
	}

}

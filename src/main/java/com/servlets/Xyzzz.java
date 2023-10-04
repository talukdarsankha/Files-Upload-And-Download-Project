package com.servlets;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/xyz")
public class Xyzzz extends HttpServlet{
   public int size=1024*1000;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filname= req.getParameter("v");
		String path = req.getServletContext().getRealPath("")+"images"+File.separator+filname;
		File fio = new File(path);
		OutputStream os=null;
		FileInputStream fui = null;
		
		try {
		if(fio.exists()) {
			resp.setHeader("Content-Disposition",String.format("attachment;filename=\"%s\"",fio.getName()) );
			resp.setContentType("application/octet-stream");
			os=resp.getOutputStream();
			fui=new FileInputStream(fio);
			byte[] ar = new byte[size];
			int re=-1	;
			while((re=fui.read(ar))!=-1) {
				os.write(ar,0,re);
			}
		}else {
			resp.setContentType("text/html");
			PrintWriter pw= resp.getWriter();
			pw.print("not found "+filname);
		}
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			if(fui!=null) {
				fui.close();
			}
			os.flush();
			if(os!=null) {
				os.close();
			}
		}
	   
		
	}
	
	

}
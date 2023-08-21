package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.BookDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		BookDAO dao= new BookDAO(DBConnect.getConn());
		boolean f=dao.deleteBook(id);
		
		 HttpSession session=req.getSession();
		   	    
		    if(f)
		    {
		    	session.setAttribute("sucMSG","Book details deleted succesfully.....");
		    	resp.sendRedirect("index.jsp");
		    	//System.out.println("Book details stored succesfully.....");
		    }
		    else
		    {
		    	session.setAttribute("errorMSG","Book not deleted so....Unsuccesfull");
		    	resp.sendRedirect("index.jsp");
		    	//System.out.println("Something wrong on server.....");
		    }
		
	}
	

}

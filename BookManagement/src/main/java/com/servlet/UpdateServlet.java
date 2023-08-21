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
import com.entity.Book;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookname=req.getParameter("name");
		String doi=req.getParameter("doi");
		String authorname=req.getParameter("author");
	    String price=req.getParameter("price");
	    int id=Integer.parseInt(req.getParameter("id"));
	    
	    Book book = new Book(id,bookname,doi,authorname,price);
	    
	    BookDAO dao = new BookDAO(DBConnect.getConn());
	    
	    HttpSession session=req.getSession();
	    boolean f=dao.updateBook(book);
	    if(f)
	    {
	    	session.setAttribute("sucMSG","Book details Updated succesfully.....");
	    	resp.sendRedirect("index.jsp");
	    	//System.out.println("Book details stored succesfully.....");
	    }
	    else
	    {
	    	session.setAttribute("errorMSG","Book details not updated so....Unsuccesfull");
	    	resp.sendRedirect("index.jsp");
	    	//System.out.println("Something wrong on server.....");
	    }
	}

}

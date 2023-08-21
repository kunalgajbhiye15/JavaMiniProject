package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book;

public class BookDAO {
	
	private Connection conn;
	
	public BookDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addBook(Book book)
	{
		boolean f=false;
		
		try {
			String sql="insert into book(bookname,doi,authorname,Price) values(?,?,?,?)";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getDoi());
			ps.setString(3, book.getAuthorName());
			ps.setString(4, book.getPrice());
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Book>getAllBook()
	{
		List<Book> list =new ArrayList<Book>();
		
		Book s= null;
		try
		{
			String sql ="select * from book";
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				s = new Book();
				s.setId(rs.getInt(1));
				s.setBookName(rs.getString(2));
				s.setDoi(rs.getString(3));
				s.setAuthorName(rs.getString(4));
				s.setPrice(rs.getString(5));
				list.add(s);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public Book getBookById(int id)
	{
		Book s = null;
		try
		{
			String sql ="select * from book where id=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				s = new Book();
				s.setId(rs.getInt(1));
				s.setBookName(rs.getString(2));
				s.setDoi(rs.getString(3));
				s.setAuthorName(rs.getString(4));
				s.setPrice(rs.getString(5));
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
	public boolean updateBook(Book book)
	{
		boolean f=false;
		
		try {
			String sql="update book set bookname=?,doi=?,authorname=?,Price=? WHERE id=?";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getDoi());
			ps.setString(3, book.getAuthorName());
			ps.setString(4, book.getPrice());
			ps.setInt(5,book.getId());
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
		
	}	
	
	public boolean deleteBook(int id)
	{
		boolean f =false;
		try
		{
			String sql ="delete from book where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
}

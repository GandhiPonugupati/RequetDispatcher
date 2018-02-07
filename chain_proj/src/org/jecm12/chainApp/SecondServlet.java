package org.jecm12.chainApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*@WebServlet("/ss")*/

public class SecondServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		String fname=(String)req.getAttribute("fname");
		String lname=(String)req.getAttribute("lname");

		PrintWriter out=resp.getWriter();
		out.println("<html><body>" +
				"<h1 align='center'>FirstName and LastName is "+fname+" "+lname+"</h1>" +
				"</body></html>");
		out.flush();
		out.close();

		Random rand = new Random();
		int  n = rand.nextInt(10000) + 1000;

		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into jecm12.product values(?,?,?)";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("forname");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
			//System.out.println("getconnection");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, n);
			pstmt.setString(2, fname);
			//System.out.println("fname "+fname);
			pstmt.setString(3, lname);
			//System.out.println("lname "+lname);
			int i=pstmt.executeUpdate();
			//System.out.println("execute()"+i);

		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

			}
}

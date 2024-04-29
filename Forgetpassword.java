package InnovationGroup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forgetpassword
 */
@WebServlet("/Forgetpassword")
public class Forgetpassword extends HttpServlet {
	public String url="jdbc:mysql://localhost:3306/techa-52?user=root&password=12345";
	private static final long serialVersionUID = 1L;
       
    public Forgetpassword() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String phno=request.getParameter("phno");
		String password=request.getParameter("pass");
		try {
			String query="update inovation_restarant.sign_in set Password='"+password+"'where PhoneNumber='"+phno+"'";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement stm=con.prepareStatement(query);
			int i=stm.executeUpdate();
			System.out.println("sucessfull");
			response.sendRedirect("Login.html");
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

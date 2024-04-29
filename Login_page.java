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
 * Servlet implementation class Login_page
 */
@WebServlet("/Login_page")
public class Login_page extends HttpServlet {
	public String url="jdbc:mysql://localhost:3306/techa-52?user=root&password=12345";
	private static final long serialVersionUID = 1L;
    
    public Login_page() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String gmail=request.getParameter("email");
		String password=request.getParameter("pass");
		try {
			String query="select * from inovation_restarant.sign_in where Email='"+gmail+"'and Password='"+password+"'";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			Statement stm=con.createStatement();
			ResultSet res=stm.executeQuery(query);
			if(res.next()) {
				response.sendRedirect("Login_sucess.html");
			}
			else {
				response.sendRedirect("Logn_in_Failed.html");
			}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

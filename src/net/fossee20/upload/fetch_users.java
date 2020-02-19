package net.fossee20.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



//import com.opencsv.CSVReader;


@WebServlet(name = "fetch_uers", urlPatterns = { "/fetch_uers" })
@MultipartConfig
public class fetch_users extends HttpServlet {
	private String dbURL = "jdbc:mysql://localhost:3306/users?useSSL=false";
	private String dbUser = "root";
	private String dbPass = "password";

    public fetch_users() {
        super();
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       

        /*CSVReader reader;
        Iterator<String[]> iterator;*/
        ResultSet resultSet = null;
        Connection conn = null;	// connection to the database
        String message2="Sorry,Currently the Databse is Empty :(";   //Success or failure Message to client sent back
		String message = "";// added users info will be sent back to client in case of succcess
		
        try {
        	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
			String sql="SELECT * from contacts";
			PreparedStatement statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
			if(message=="") {
				message="<tr><th>I.D.</th><th>Name</th><th>Email</th><th>Phone Number</th><th></tr>";//first Time table Header
				message2=""; //Database is not Empty.. 
			}
			message += "<tr>"+"<td>"+resultSet.getString("contact_id")+"</td>"+"<td>"+resultSet.getString("name")+"</td>"+"<td>"+resultSet.getString("email")+"</td>"+"<td>"+resultSet.getString("phone")+ "</tr>";
			}

            

        }catch(Exception ex) {
        	message2 = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
        	
        }finally {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			// sets the message in request scope
			request.setAttribute("Message", message);
			request.setAttribute("Message2", message2);
			
			// forwards to the message page
			getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
		}

        

    }

}
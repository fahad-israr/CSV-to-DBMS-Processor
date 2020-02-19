package net.fossee20.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.HashMap;
import java.util.Iterator;
//import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import au.com.bytecode.opencsv.CSVReader;

//import com.opencsv.CSVReader;


@WebServlet(name = "upload", urlPatterns = { "/upload" })
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private String dbURL = "jdbc:mysql://localhost:3306/users?useSSL=false";
	private String dbUser = "root";
	private String dbPass = "password";

    public UploadServlet() {
        super();
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("file"); 
        InputStream fileContent = filePart.getInputStream();

        Reader in = new InputStreamReader(fileContent);

        CSVReader reader;
        Iterator<String[]> iterator;
        Connection conn = null;	// connection to the database
        String message2=null;   //Success or failure Message to client sent back
		String message = "";// added users info will be sent back to client in case of succcess
		
        try {
        	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);


            reader = new CSVReader(new InputStreamReader(fileContent));
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
            	String sql = "INSERT INTO contacts (name, email,phone) values (?, ?,?)";
    			PreparedStatement statement = conn.prepareStatement(sql);
    			statement.setString(1, nextRecord[0]);
    			statement.setString(2, nextRecord[1]);
    			statement.setString(3, nextRecord[2]);
    			int row = statement.executeUpdate();
    			if (row > 0) {
    				if(message=="")message="<tr><th>Name:</th><th>Email:</th><th>Phone:</th><th></tr>";//first Time table Header
    				message += "<tr>"+"<td>"+nextRecord[0]+"</td>"+"<td>"+nextRecord[1]+"</td>"+"<td>"+nextRecord[2]+"</td>"+ "</tr>";
    				message2="Above users were Successfully Added!!";
    			}
                System.out.println("First Name : " + nextRecord[0]);
                System.out.println("Email : " + nextRecord[1]);
                System.out.println("Phone : " + nextRecord[2]);
                
                System.out.println("==========================");
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
			getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
		}

        in.close();

    }

}
package doun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MariaConn {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String query="select * from FDSUSER";

	public void MaraiConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.52:3306/bluewalnut", "fds", "illootechrnd");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void select() {
		this.MaraiConnection();
		
		try {
			pstmt= conn.prepareStatement(query);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String userid=rs.getString("USERID");
				
				System.out.println(userid);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

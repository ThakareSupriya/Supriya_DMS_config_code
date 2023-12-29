package webCommonFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class DatabaseConnectivity { 
	
public static void connection(String url, String username, String password, String query) {  
		
		try{
		
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection(url, username, password); 
			Thread.sleep(3000);
			Statement stmt = con.createStatement(); 
			
			ResultSet rslt = stmt.executeQuery(query);
		
		if(con != null) {
			System.out.println("Connection established");
			
			while(rslt.next()){
				System.out.println("Query Output: " + rslt.getString(1));
			}
			con.close();
		}	
		}catch (Exception e) { 
			 System.out.println(e); 
		} 
	   
	}
	 
	
	public static void main(String[] args) {
		DatabaseConnectivity.connection("jdbc:mysql://192.168.0.92/dmacq_v9_new_rajan", "root", "123456", 
				"SELECT Count(*) FROM project_documents WHERE title like 'Excel doc%' AND category_id = 33 AND file_name like '%xlsx' AND log_datetime like '2023-09-22 %' AND doc_delete = 0 ;" );
	}
	
}

package org.soa.ws.tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebService;

@WebService(endpointInterface = "org.soa.ws.tp.WebServiceCRUD")
public class WebServiceCRUDImpl implements WebServiceCRUD {
	
	    // JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		static final String DB_URL = "jdbc:mysql://localhost:3306/Products";
		// Database credentials
		static final String USER = "root";
		static final String PASS = "";
		
		
		

	@Override
	public String readCategProduct(String id) {	
		
	       String  categProd = "null";
	       
		   Connection conn = null;
		   Statement stmt = null;
		   try{
			   
		      //STEP 1: Register JDBC driver			      
		      Class.forName("com.mysql.jdbc.Driver").newInstance();						      
		      
		      //STEP 2: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		      //STEP 3: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT categ FROM produit WHERE id=" + id;
		      ResultSet rs = stmt.executeQuery(sql);
		
		      //STEP 4: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         categProd = rs.getString("categ");			        		         
		
		         //Display values
		         System.out.print("Category: " + categProd);
		         
		      }
		      
		      //STEP 5: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		      
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		   System.out.println("Goodbye!");
		   
		   return categProd;       
		     
	}

}

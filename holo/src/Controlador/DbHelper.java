package Controlador;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbHelper {
	 static final String DB_URL = "jdbc:mysql://localhost/interfaces";
	 static final String USER = "Cristian";
	 static final String PASS = "31310";
	
	public static void main (String []args) {
		
	}
	
	public void createDb() {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {		      
		         String sql = "CREATE DATABASE LoginInterfaces";
		         stmt.executeUpdate(sql);
		         System.out.println("Database created successfully...");   	  
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	}
	
	public void dropDb() {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {		      
		         String sql = "DROP DATABASE LoginInterfaces";
		         stmt.executeUpdate(sql);
		         System.out.println("Database dropped successfully...");   	  
		 } catch (SQLException e) {
		         e.printStackTrace();
		 } 
	}
	
	public void createTable () {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			) {
				String sql = "CREATE TABLE USERS"+
							"(id_nickname VARCHAR(255) not NULL, "+
							"nombre VARCHAR(255), "+
							"apellidos VARCHAR(255), "+
							"contrasena VARCHAR(255), "+
							"email VARCHAR(255), "+
							"PRIMARY KEY(id_nickname));";
				stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String nickname) {
		
		//ArrayList<String> listUser = new ArrayList<>();
		//int i = 0;
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         
		      ) {
			      String sql = "DELETE FROM USERS WHERE id_nickname = '"+nickname+"'";
			      stmt.execute(sql);
		         
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	}
	
	public void dropTable(String nickname) {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				) {
					String sql = "DROP TABLE IF EXISTS USERS";
					stmt.executeUpdate(sql);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public ArrayList<String> selectTodo(String nickname) {
		String QUERY = "SELECT * FROM USERS WHERE id_nickname = '"+nickname+"'";
		ArrayList<String> listUser = new ArrayList<>();
		int i = 0;
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		            //Display values
		        	 i = rs.getRow();
		        	 listUser.add(rs.getString("id_nickname"));
		        	 listUser.add(rs.getString("nombre"));
		        	 listUser.add(rs.getString("apellidos"));
		        	 listUser.add(rs.getString("email"));
		        	 
		        	
		             System.out.print("Nick: " + rs.getString("id_nickname"));
		             System.out.print(", Name " + rs.getString("nombre"));
		             System.out.print(", apellidos" + rs.getString("apellidos"));
		             System.out.println(", email" + rs.getString("email"));
		         }
		         //listUser.add(String.valueOf(i));
		         
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		return listUser;
	}
	
	
	public ArrayList<String> selectIdNickname() {
		String QUERY = "SELECT * FROM USERS";
		ArrayList<String> listUser = new ArrayList<>();
		int i = 0;
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		            //Display values
		        	 i = rs.getRow();
		        	 listUser.add(rs.getString("id_nickname"));
		        	 //listUser.add(rs.getString("nombre"));
		        	 //listUser.add(rs.getString("apellidos"));
		        	 //listUser.add(rs.getString("email"));
		        	 
		        	
		           //System.out.print("Nick: " + rs.getString("id_nickname"));
		            //System.out.print(", Name " + rs.getString("nombre"));
		            //System.out.print(", apellidos" + rs.getString("apellidos"));
		            //sSystem.out.println(", email" + rs.getString("email"));
		         }
		         //listUser.add(String.valueOf(i));
		         
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		return listUser;
	}
	
	public ArrayList<String> selectNombre() {
		String QUERY = "SELECT * FROM USERS";
		ArrayList<String> listUser = new ArrayList<>();
		int i = 0;
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		            //Display values
		        	 i = rs.getRow();
		        	 listUser.add(rs.getString("nombre"));
		         }
		         
		         
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		return listUser;
	}
	
	public ArrayList<String> selectApellidos() {
		String QUERY = "SELECT * FROM USERS";
		ArrayList<String> listUser = new ArrayList<>();
		int i = 0;
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		            //Display values
		        	 i = rs.getRow();
		        	 listUser.add(rs.getString("apellidos"));
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		return listUser;
	}
	
	public ArrayList<String> selectEmail() {
		String QUERY = "SELECT * FROM USERS";
		ArrayList<String> listUser = new ArrayList<>();
		int i = 0;
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		            //Display values
		        	 i = rs.getRow();
		        	 listUser.add(rs.getString("email"));
		        	 
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		return listUser;
	}
	
	public boolean conUser(String nick, String contraseña) {
		
		boolean bol = false;
		String QUERY = "SELECT id_nickname, contrasena FROM USERS WHERE id_nickname = '"+nick+"'"+" AND contrasena = "+"'"+contraseña+"'";
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		            //Display values
		        	 
		        	 if(rs.getString(1).equals(nick) && rs.getString(2).equals(contraseña)) {
		        		 System.out.println("existe usuario 1");
		        		 bol = true;
			         }
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		return bol;
		
	}
	
	public void insert(String nombre, String nickname, String apellidos, String contraseña, String email) {
		 try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {		      
		         System.out.println("Inserting records into the table...");          
		         String sql = "INSERT INTO USERS VALUES (" + "'" + nickname + "'" + "," + "'"+nombre+"'" + "," + "'"+apellidos+"'" + "," + "'"+contraseña+"'" + "," + "'"+email+"'" + ")";
		         stmt.executeUpdate(sql);
		           	  
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	}
	
	public void update(String nombre, String nickname, String apellidos, String contraseña, String email, String id) {
		 try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {		      
		         System.out.println("Inserting records into the table...");          
		         String sql = "UPDATE USERS SET id_nickname = '"+nickname+"', "+"nombre = '"+nombre+"', "+"apellidos = '"+apellidos+"', "+"contrasena = '"+contraseña+"', "+"email = '"+email+"' WHERE id_nickname = '"+id+"'";
		         stmt.executeUpdate(sql);
		           	  
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	}
	
	public boolean existTable() {
		
		boolean exist = true;
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null, null, "USERS", null);
			if(tables.next()) {
				exist = true;
			}else {
				exist = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}

}

package com.onion.home.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn  {
	
	
	public DBConn() {

	}

	//getConn 
	//
	public static Connection getConn() throws Exception {
		//1. 연결 정보
		String user = "user01";
		
		String pw = "user01";
		
		String url = "jdbc:oracle:thin:@192.168.1.138:1521/xe";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. Driver를 메모리에 로딩
		Class.forName(driver);
		
		return DriverManager.getConnection(url, user, pw); 		
	}
	
	public static void disConnection(PreparedStatement ps, Connection conn) throws Exception{
		ps.close();
		conn.close();
	}
	
	public static void disConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception {
		rs.close();
		ps.close();
		conn.close();
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = getConn();
			System.out.println(conn != null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

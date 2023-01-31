package com.onion.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.onion.home.util.DBConn;

public class MemberDAO  {
	//setAddMember
	
	public int setAddMember(MemberDTO memberDTO) throws Exception{
		
		Connection conn = DBConn.getConn();	
		
		String sql = "INSERT INTO MEMBER VALUES(? ,? ,? ,? ,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, memberDTO.getId());
		ps.setString(2, memberDTO.getPw());
		ps.setString(3, memberDTO.getPhone());
		ps.setString(4, memberDTO.getEmail());
		ps.setString(5, memberDTO.getName());
		
		int result = ps.executeUpdate();
		
		DBConn.disConnection(ps, conn);
	
		
		return result;
	}
	
	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("qwdfd");
		memberDTO.setPw("joo365187");
		memberDTO.setPhone("01054395555");
		memberDTO.setName("석주");
		memberDTO.setEmail("qwdfd@@aer.com");
		
		
		try {
			int result = memberDAO.setAddMember(memberDTO);
			System.out.println(result != 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

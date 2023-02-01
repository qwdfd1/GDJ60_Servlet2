package com.onion.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onion.home.product.ProductOptionDTO;
import com.onion.home.util.DBConn;

public class ProductDAO {
	

	
	public Long getProductNum() throws Exception{
		
		Connection conn = DBConn.getConn();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL NUMMAX FROM DUAL";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Long max = rs.getLong("NUMMAX");
		
		DBConn.disConnection(rs, ps, conn);
		
		return max;
	}
	
	public List<ProductOptionDTO> getProductOptionList () throws Exception {
		List<ProductOptionDTO> productOptionDTOs = new ArrayList<ProductOptionDTO>();
		
		Connection conn = DBConn.getConn();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getLong("OPTIONNUM"));
			productOptionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getInt("OPTIONPRICE"));
			productOptionDTO.setOptionStock(rs.getInt("OPTIONSTOCK"));
		}
		
		DBConn.disConnection(rs, ps, conn);
		
		return productOptionDTOs;
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		
		Connection conn = DBConn.getConn();
		ArrayList<ProductDTO> productDTOs = new ArrayList<ProductDTO>(); 
		
		String sql = "SELECT PRODUCTNUM, PRODUCTNAME, PRODUCTJUMSU"
				+ " FROM PRODUCT ORDER BY PRODUCTNUM DESC";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			productDTOs.add(productDTO);
		}
		
		DBConn.disConnection(rs, ps, conn);
		
		return productDTOs;
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		
		Connection conn = DBConn.getConn();
		
		String sql ="SELECT * FROM PRODUCT WHERE PRODUCTNUM = ?";
		
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setLong(1, productDTO.getProductNum());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			productDTO.setProductDetail(rs.getString("PRODUCTDETAIL"));
		}
		else {
			productDTO = null;
		}
	
		
		DBConn.disConnection(rs, ps, conn);
		
		return productDTO;
		
		
	}
	
	public int setAddProduct (ProductDTO productDTO) throws Exception  {
		Connection conn = DBConn.getConn();
		
		String sql = "INSERT INTO PRODUCT (PRODUCTNUM,"
				+ " PRODUCTNAME, PRODUCTDETAIL, PRODUCTJUMSU) VALUES (?, ?, ?, 0.0)" ;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setLong(1, productDTO.getProductNum());
		ps.setString(2, productDTO.getProductName());
		ps.setString(3, productDTO.getProductDetail());
		
		int result = ps.executeUpdate();
		
		DBConn.disConnection(ps, conn);		
				
		return result;
	}
	
	public int setAddProductOption (ProductOptionDTO productOptionDTO) throws Exception {
		Connection conn = DBConn.getConn();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME,"
				+ " OPTIONPRICE, OPTIONSTOCK) VALUES ("
				+ "PRODUCTOPTION_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		

		ps.setLong(1, productOptionDTO.getProductNum());
		ps.setString(2, productOptionDTO.getOptionName());
		ps.setInt(3, productOptionDTO.getOptionPrice());
		ps.setInt(4, productOptionDTO.getOptionStock());
			
		int result = ps.executeUpdate();
		
		DBConn.disConnection(ps, conn);
		
		return result;
	}
	
	public static void main(String[] args) {
//		ProductDAO productDAO = new ProductDAO();
//		
////		List<ProductDTO> productList = null;
////		try {
////			productList = productDAO.getProductList();
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		System.out.println(productList.size() != 0);
//		
//		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
//		productOptionDTO.setProductNum(1L);
//		productOptionDTO.setOptionName("몰라");
//		productOptionDTO.setOptionPrice(34000);
//		productOptionDTO.setOptionStock(3);
//		
//		try {
//			int result = productDAO.setAddProductOption(productOptionDTO);
//			System.out.println(result != 0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
				
		
	}
}

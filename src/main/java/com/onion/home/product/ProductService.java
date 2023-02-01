package com.onion.home.product;

import java.util.List;

import com.onion.home.product.ProductOptionDTO;

public class ProductService {
	//의존도가 높은 강한 결합
	//1. 선언과 동시에 객체 생성
	private ProductDAO productDAO = new ProductDAO();
	
	//2. 인스턴스 블럭을 사용한 객체 생성
	{
		this.productDAO = new ProductDAO();
	}
	
	
	//3. 생성자를 이용한 객체 생성
	public ProductService() {
		productDAO = new ProductDAO();
	}
	
	//의존도가 낮은 약한 결합
	//4. Setter를 이용한 객체 생성
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getProductDetail(productDTO);
		
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		return productDAO.getProductList();
	}

	public int setAddProduct(ProductDTO productDTO, List<ProductOptionDTO> productOptionDTOs) throws Exception {
		//product , option
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		
		int result = productDAO.setAddProduct(productDTO);
		
		for (ProductOptionDTO productOptionDTO : productOptionDTOs) {
			productOptionDTO.setProductNum(productNum);
			result = productDAO.setAddProductOption(productOptionDTO);
		}
		
		return result;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductDAO productDAO = new ProductDAO(); 
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("product1");
		productDTO.setProductDetail("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		productOptionDTO.setOptionName("optionName1");
		productOptionDTO.setOptionPrice(4000);
		productOptionDTO.setOptionStock(10);
		
		
		ProductOptionDTO productOptionDTO2 = new ProductOptionDTO();
		productOptionDTO.setOptionName("optionName2");
		productOptionDTO.setOptionPrice(200);
		productOptionDTO.setOptionStock(20);
		productOptionDTO.setProductNum(null);
		
		try {
			Long num = productDAO.getProductNum();
			productDTO.setProductNum(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptionDTO.setProductNum(num);
			
			if(result>0) {
				productDAO.setAddProductOption(productOptionDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


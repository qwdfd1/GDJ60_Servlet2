package com.onion.home.product;

public class ProductOptionDTO {
	private Long optionNum;
	private Long productNum;
	private String optionName;
	private Integer optionPrice;
	private Integer optionStock;
	
	public ProductOptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getOptionNum() {
		return optionNum;
	}

	public void setOptionNum(Long optionNum) {
		this.optionNum = optionNum;
	}

	public Long getProductNum() {
		return productNum;
	}

	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Integer getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(Integer optionPrice) {
		this.optionPrice = optionPrice;
	}

	public Integer getOptionStock() {
		return optionStock;
	}

	public void setOptionStock(Integer optionStock) {
		this.optionStock = optionStock;
	}
	
	
	
	
}

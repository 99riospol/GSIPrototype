package com.tecnocampus.GSI.application;

import java.util.List;

import com.tecnocampus.GSI.application.DTO.ProductDTO;

public interface ProductDAO {
	
	public List<ProductDTO> getProducts();

	public ProductDTO getProduct(String id);
}

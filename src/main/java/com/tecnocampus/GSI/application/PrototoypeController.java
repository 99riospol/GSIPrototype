package com.tecnocampus.GSI.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tecnocampus.GSI.application.DTO.ProductDTO;

@Service
public class PrototoypeController {
	private ProductDAO productDAO;
	
	public PrototoypeController(ProductDAO productDAO) {
		this.productDAO=productDAO;
	}
	
	public ProductDTO getProduct(String id) {
		return productDAO.getProduct(id);
	}

	public List<ProductDTO> getProducts() {
		return productDAO.getProducts();
	}
}

package com.tecnocampus.GSI.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.tecnocampus.GSI.application.PrototoypeController;
import com.tecnocampus.GSI.application.DTO.ProductDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PrototypeRestController {
	private PrototoypeController prototypeController;
	
	//private PrototypeController prototypeController;
	
	public PrototypeRestController(PrototoypeController prototypeController) {
		this.prototypeController=prototypeController;
	}
	
	@GetMapping("/product/{product_id}")
	public ProductDTO getProduct(@PathVariable String id) throws Exception {
		ProductDTO product;
		product=prototypeController.getProduct(id);
		return product;
	}
	
	@GetMapping("/products")
	public List<ProductDTO> getProduct1() throws Exception {
		return prototypeController.getProducts();
	}
}

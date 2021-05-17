package com.tecnocampus.GSI.application.DTO;

public class ProductDTO {
	
	private String id;
	
	private String lote_id;
	
	public ProductDTO() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public String getLote() {
		return lote_id;
	}
	
	public void setLote(String lote_id) {
		this.lote_id=lote_id;
	}
	
}

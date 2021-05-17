package com.tecnocampus.GSI.domain;

public class Product {
private String id;
	
	private String lote_id;
	
	public Product() {
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

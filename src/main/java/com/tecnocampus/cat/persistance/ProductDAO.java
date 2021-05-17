package com.tecnocampus.cat.persistance;

import java.util.List;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.simpleflatmapper.jdbc.spring.RowMapperImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tecnocampus.GSI.application.DTO.ProductDTO;
import com.tecnocampus.GSI.application.exception.ProductNotFoundException;



@Repository
public class ProductDAO implements com.tecnocampus.GSI.application.ProductDAO {

	private JdbcTemplate jdbcTemplate;
	
	private final RowMapper<ProductDTO> productRowMapperLazy = (resultSet, i) -> {
		ProductDTO product = new ProductDTO();

		product.setId(resultSet.getString("product_id"));
		product.setLote(resultSet.getString("lote_id"));
		return product;
	};
	
	ResultSetExtractorImpl<ProductDTO> productsRowMapper =
			JdbcTemplateMapperFactory
					.newInstance()
					.addKeys("id")
					.newResultSetExtractor(ProductDTO.class);

	RowMapperImpl<ProductDTO> productRowMapper =
			JdbcTemplateMapperFactory
					.newInstance()
					.addKeys("id")
					.newRowMapper(ProductDTO.class);
	
	public ProductDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<ProductDTO> getProducts() {
		final String res = "select product_id, lote_id from product";
		return jdbcTemplate.query(res, productRowMapperLazy);
	}

	@Override
	public ProductDTO getProduct(String id) {
		final String res = "select product_id, lote_id from product where product_id=?";
		try {
			return jdbcTemplate.queryForObject(res, productRowMapperLazy, id);
		} catch (EmptyResultDataAccessException e) {
			throw new ProductNotFoundException(id);
		}
	}

	
	
}

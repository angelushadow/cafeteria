package co.cafeteria.services;

import java.util.List;

import co.cafeteria.dto.ProductDto;

public interface ProductService {

	public List<ProductDto> findAll();

	public ProductDto save(ProductDto dto);

	public ProductDto update(ProductDto dto);

	public ProductDto findById(Long id);

	public void delete(Long id);
	
	public ProductDto biggestStock();

}

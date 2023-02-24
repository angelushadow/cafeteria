package co.cafeteria.services.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.cafeteria.dto.ProductDto;
import co.cafeteria.dto.mappers.ProductMapper;
import co.cafeteria.dto.mappers.VentaMapper;
import co.cafeteria.exceptions.NotFound;
import co.cafeteria.repositories.ProductRepository;
import co.cafeteria.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<ProductDto> findAll() {
		return ProductMapper.INSTANCE.entityToDto(repository.findAll());
	}

	@Override
	@Transactional
	public ProductDto save(ProductDto dto) {

		return ProductMapper.INSTANCE.entityToDto(repository.save(ProductMapper.INSTANCE.dtoToEntity(dto)));

	}

	@Override
	@Transactional
	public ProductDto update(ProductDto dto) {
		if (repository.existsById(dto.getId()))

			return ProductMapper.INSTANCE.entityToDto(repository.save(ProductMapper.INSTANCE.dtoToEntity(dto)));

		throw new NotFound("Producto no encontrada, revisar id");
	}

	@Override
	public ProductDto findById(Long id) {
		if (repository.existsById(id))

			return ProductMapper.INSTANCE.entityToDto(repository.findById(id).get());

		throw new NotFound("Producto no encontrada, revisar id");
	}

	@Override
	public void delete(Long id) {
		if (repository.existsById(id))
			repository.deleteById(id);

		throw new NotFound("Producto no encontrada, revisar id");
	}

	@Override
	public ProductDto biggestStock() {
		return ProductMapper.INSTANCE.entityToDto(repository.findAll(Sort.by(Sort.Direction.DESC, "stock")).get(0));

	}

}

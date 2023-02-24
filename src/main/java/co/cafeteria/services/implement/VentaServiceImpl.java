package co.cafeteria.services.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.cafeteria.dto.ProductDto;
import co.cafeteria.dto.VentaDto;
import co.cafeteria.dto.mappers.ProductMapper;
import co.cafeteria.dto.mappers.VentaMapper;
import co.cafeteria.exceptions.NotFound;
import co.cafeteria.repositories.VentaRepository;
import co.cafeteria.services.ProductService;
import co.cafeteria.services.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository repository;

	@Autowired
	private ProductService productService;

	private ProductDto productDto;

	@Override
	@Transactional
	public VentaDto save(VentaDto dto) {

		productDto = productService.findById(dto.getIdProduct());
		// verificacion del stock
		if (productDto.getStock().compareTo(dto.getCantidad()) < 0) {
			
			System.out.println("No hay suficientes cantidad de " + productDto.getNombreProducto());
			throw new NotFound("No hay suficientes cantidad de " + productDto.getNombreProducto());
		}

		// Descuento del stock
		productDto.setStock(productDto.getStock() - dto.getCantidad());
		productService.update(productDto);
		
		dto.setTotal(Math.multiplyExact( productDto.getPrecio(),dto.getCantidad()));

		return VentaMapper.INSTANCE.entityToDto(repository.save(VentaMapper.INSTANCE.dtoToEntity(dto)));

	}

	@Override
	public List<VentaDto> findAll() {
		return VentaMapper.INSTANCE.entityToDto(repository.findAll());
	}

	@Override
	public VentaDto mejorVenta() {
		return null;
	}

}

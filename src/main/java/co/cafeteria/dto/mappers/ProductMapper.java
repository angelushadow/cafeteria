package co.cafeteria.dto.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.cafeteria.dto.ProductDto;
import co.cafeteria.entities.ProductEntity;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	ProductDto entityToDto(ProductEntity entity);

	ProductEntity dtoToEntity(ProductDto dto);

	List<ProductDto> entityToDto(List<ProductEntity> entity);

	List<ProductEntity> dtoToEntity(List<ProductDto> dto);

}

package co.cafeteria.dto.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.cafeteria.dto.VentaDto;
import co.cafeteria.entities.VentaEntity;

@Mapper
public interface VentaMapper {

	VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

	VentaDto entityToDto(VentaEntity entity);

	VentaEntity dtoToEntity(VentaDto dto);

	List<VentaDto> entityToDto(List<VentaEntity> entity);

	List<VentaEntity> dtoToEntity(List<VentaDto> dto);
}

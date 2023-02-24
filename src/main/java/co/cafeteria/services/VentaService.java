package co.cafeteria.services;

import java.util.List;

import co.cafeteria.dto.VentaDto;

public interface VentaService {
	
	public VentaDto mejorVenta();
	
	public VentaDto save(VentaDto dto);
	
	public List<VentaDto> findAll();

}

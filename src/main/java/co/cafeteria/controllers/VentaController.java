package co.cafeteria.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.cafeteria.dto.VentaDto;
import co.cafeteria.services.VentaService;
import io.swagger.annotations.ApiOperation;

@RestController
public class VentaController {
	
	
	@Autowired
	private VentaService service;

	public static final String URL_RESOURCE = "/venta";
	public static final String URL_ID_PATH = "/{id}";

	@GetMapping(value = URL_RESOURCE)
	@ApiOperation(value = "Consulta todas las ventas registradas")
	public ResponseEntity<List<VentaDto>> getProduct() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = URL_RESOURCE)
	@ApiOperation(value = "Guarda una venta en base de datos")
	public ResponseEntity<VentaDto> save(@Valid @RequestBody VentaDto dto) {
		return new ResponseEntity(service.save(dto), HttpStatus.OK);
	}

}

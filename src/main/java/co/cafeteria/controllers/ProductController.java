package co.cafeteria.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.cafeteria.dto.ProductDto;
import co.cafeteria.services.ProductService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	public static final String URL_RESOURCE = "/product";
	public static final String URL_ID_PATH = "/{id}";

	@GetMapping(value = URL_RESOURCE)
	@ApiOperation(value = "Consulta todas los productos registradas")
	public ResponseEntity<List<ProductDto>> getProduct() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = URL_RESOURCE)
	@ApiOperation(value = "Guarda un producto en base de datos")
	public ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto dto) {
		return new ResponseEntity(service.save(dto), HttpStatus.OK);
	}

	@PutMapping(value = URL_RESOURCE)
	@ApiOperation(value = "Actualiza un producto en base de datos")
	public ResponseEntity<ProductDto> update(@Valid @RequestBody ProductDto dto) {
		return new ResponseEntity(service.update(dto), HttpStatus.OK);
	}

	@GetMapping(value = URL_RESOURCE + URL_ID_PATH)
	@ApiOperation(value = "Encuentra un producto en base de datos por Id")
	public ResponseEntity<ProductDto> findById(@PathVariable("id") Long id) {
		return new ResponseEntity(service.findById(id), HttpStatus.OK);
	}

	@DeleteMapping(value = URL_RESOURCE + URL_ID_PATH)
	@ApiOperation(value = "Elimina un producto en base de datos por Id")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(value = URL_RESOURCE + "/stock")
	@ApiOperation(value = "Consulta el producto con mas stock")
	public ResponseEntity<ProductDto> getMejorVenta() {
		return new ResponseEntity(service.biggestStock(), HttpStatus.OK);
	}

}

package co.cafeteria.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto implements Serializable {

	private Long id;

	@NotNull
	private String nombreProducto;

	@NotNull
	private String referencia;

	@NotNull
	private Integer precio;

	@NotNull
	private Integer peso;

	@NotNull
	private String categoria;

	@NotNull
	private Integer stock;

	private Date creacion;

}

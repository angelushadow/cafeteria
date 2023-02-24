package co.cafeteria.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VentaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long idProduct;
	
	private Integer cantidad;
	
	private Integer total;

}

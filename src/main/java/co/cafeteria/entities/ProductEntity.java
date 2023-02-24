package co.cafeteria.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nombreProducto;

	@Column(nullable = false)
	private String referencia;

	@Column(nullable = false)
	private Integer precio;

	@Column(nullable = false)
	private Integer peso;

	@Column(nullable = false)
	private String categoria;

	@Column(nullable = false)
	private Integer stock;

	@CreationTimestamp
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creacion;

}

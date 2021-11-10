package com.jofagaca69.NCL.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the lineas_marcas database table.
 * 
 */
@Entity
@Table(name="lineas_marcas")
@NamedQuery(name="LineasMarca.findAll", query="SELECT l FROM LineasMarca l")
public class LineasMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createdAt;

	private String nombre;

	private String version;

	//bi-directional many-to-one association to MarcasVehiculo
	@ManyToOne
	@JoinColumn(name="marcas_vehiculos_id")
	private MarcasVehiculo marcasVehiculo;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="lineasMarca")
	private List<Vehiculo> vehiculos;

	public LineasMarca() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public MarcasVehiculo getMarcasVehiculo() {
		return this.marcasVehiculo;
	}

	public void setMarcasVehiculo(MarcasVehiculo marcasVehiculo) {
		this.marcasVehiculo = marcasVehiculo;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setLineasMarca(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setLineasMarca(null);

		return vehiculo;
	}

}
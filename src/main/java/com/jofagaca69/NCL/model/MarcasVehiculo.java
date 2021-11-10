package com.jofagaca69.NCL.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marcas_vehiculos database table.
 * 
 */
@Entity
@Table(name="marcas_vehiculos")
@NamedQuery(name="MarcasVehiculo.findAll", query="SELECT m FROM MarcasVehiculo m")
public class MarcasVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-one association to LineasMarca
	@OneToMany(mappedBy="marcasVehiculo")
	private List<LineasMarca> lineasMarcas;

	public MarcasVehiculo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LineasMarca> getLineasMarcas() {
		return this.lineasMarcas;
	}

	public void setLineasMarcas(List<LineasMarca> lineasMarcas) {
		this.lineasMarcas = lineasMarcas;
	}

	public LineasMarca addLineasMarca(LineasMarca lineasMarca) {
		getLineasMarcas().add(lineasMarca);
		lineasMarca.setMarcasVehiculo(this);

		return lineasMarca;
	}

	public LineasMarca removeLineasMarca(LineasMarca lineasMarca) {
		getLineasMarcas().remove(lineasMarca);
		lineasMarca.setMarcasVehiculo(null);

		return lineasMarca;
	}

}
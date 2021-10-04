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
@NamedQuery(name="MarcaVehiculo.findAll", query="SELECT m FROM MarcaVehiculo m")
public class MarcaVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-one association to LineaMarca
	@OneToMany(mappedBy="marcaVehiculo")
	private List<LineaMarca> lineasMarcas;

	public MarcaVehiculo() {
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

	public List<LineaMarca> getLineasMarcas() {
		return this.lineasMarcas;
	}

	public void setLineasMarcas(List<LineaMarca> lineasMarcas) {
		this.lineasMarcas = lineasMarcas;
	}

	public LineaMarca addLineasMarca(LineaMarca lineasMarca) {
		getLineasMarcas().add(lineasMarca);
		lineasMarca.setMarcaVehiculo(this);

		return lineasMarca;
	}

	public LineaMarca removeLineasMarca(LineaMarca lineasMarca) {
		getLineasMarcas().remove(lineasMarca);
		lineasMarca.setMarcaVehiculo(null);

		return lineasMarca;
	}

}
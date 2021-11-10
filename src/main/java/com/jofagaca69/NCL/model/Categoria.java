package com.jofagaca69.NCL.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to ClasesVehiculo
	@ManyToOne
	@JoinColumn(name="clases_vehiculo_id")
	private ClasesVehiculo clasesVehiculo;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="categoria")
	private List<Item> items;

	//bi-directional many-to-many association to Revision
	@ManyToMany(mappedBy="categorias")
	private List<Revision> revisiones;

	public Categoria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ClasesVehiculo getClasesVehiculo() {
		return this.clasesVehiculo;
	}

	public void setClasesVehiculo(ClasesVehiculo clasesVehiculo) {
		this.clasesVehiculo = clasesVehiculo;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setCategoria(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setCategoria(null);

		return item;
	}

	public List<Revision> getRevisiones() {
		return this.revisiones;
	}

	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
	}

}
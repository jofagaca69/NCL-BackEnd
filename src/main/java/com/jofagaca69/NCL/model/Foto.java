package com.jofagaca69.NCL.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fotos database table.
 * 
 */
@Entity
@Table(name="fotos")
@NamedQuery(name="Foto.findAll", query="SELECT f FROM Foto f")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	@Column(name="ruta_almacenamiento")
	private String rutaAlmacenamiento;

	private String tipo;

	//bi-directional many-to-one association to Revision
	@OneToMany(mappedBy="foto")
	private List<Revision> revisiones;

	public Foto() {
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

	public String getRutaAlmacenamiento() {
		return this.rutaAlmacenamiento;
	}

	public void setRutaAlmacenamiento(String rutaAlmacenamiento) {
		this.rutaAlmacenamiento = rutaAlmacenamiento;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Revision> getRevisiones() {
		return this.revisiones;
	}

	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
	}

	public Revision addRevisione(Revision revisione) {
		getRevisiones().add(revisione);
		revisione.setFoto(this);

		return revisione;
	}

	public Revision removeRevisione(Revision revisione) {
		getRevisiones().remove(revisione);
		revisione.setFoto(null);

		return revisione;
	}

}
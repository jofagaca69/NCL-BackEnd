package com.jofagaca69.NCL.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa_transportes database table.
 * 
 */
@Entity
@Table(name="empresa_transportes")
@NamedQuery(name="EmpresaTransporte.findAll", query="SELECT e FROM EmpresaTransporte e")
public class EmpresaTransporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String celular;

	private String direccion;

	private String email;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="empresaTransporte")
	private List<Vehiculo> vehiculos;

	public EmpresaTransporte() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setEmpresaTransporte(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setEmpresaTransporte(null);

		return vehiculo;
	}

}
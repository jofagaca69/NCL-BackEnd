package com.jofagaca69.NCL.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehiculos database table.
 * 
 */
@Entity
@Table(name="vehiculos")
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String placa;

	@Column(name="anio_modelo")
	private int anioModelo;

	private int capacidad;

	private int cilindraje;

	private String color;

	private String combustible;

	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="marca_vehiculo")
	private int marcaVehiculo;

	@Column(name="numero_interno_empresa")
	private int numeroInternoEmpresa;

	//bi-directional many-to-one association to Revision
	@OneToMany(mappedBy="vehiculo")
	private List<Revision> revisiones;

	//bi-directional many-to-one association to ClasesVehiculo
	@ManyToOne
	@JoinColumn(name="clase_vehiculo_id")
	private ClasesVehiculo clasesVehiculo;

	//bi-directional many-to-one association to EmpresaTransporte
	@ManyToOne
	@JoinColumn(name="empresa_transportes_id")
	private EmpresaTransporte empresaTransporte;

	//bi-directional many-to-one association to LineasMarca
	@ManyToOne
	@JoinColumn(name="lineas_marcas_id")
	private LineasMarca lineasMarca;

	//bi-directional many-to-many association to Propietario
	@ManyToMany
	@JoinTable(
		name="propietarios_has_vehiculos"
		, joinColumns={
			@JoinColumn(name="vehiculo_placa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="propietario_cedula")
			}
		)
	private List<Propietario> propietarios;

	public Vehiculo() {
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAnioModelo() {
		return this.anioModelo;
	}

	public void setAnioModelo(int anioModelo) {
		this.anioModelo = anioModelo;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCilindraje() {
		return this.cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCombustible() {
		return this.combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getMarcaVehiculo() {
		return this.marcaVehiculo;
	}

	public void setMarcaVehiculo(int marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	public int getNumeroInternoEmpresa() {
		return this.numeroInternoEmpresa;
	}

	public void setNumeroInternoEmpresa(int numeroInternoEmpresa) {
		this.numeroInternoEmpresa = numeroInternoEmpresa;
	}

	public List<Revision> getRevisiones() {
		return this.revisiones;
	}

	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
	}

	public Revision addRevisione(Revision revisione) {
		getRevisiones().add(revisione);
		revisione.setVehiculo(this);

		return revisione;
	}

	public Revision removeRevisione(Revision revisione) {
		getRevisiones().remove(revisione);
		revisione.setVehiculo(null);

		return revisione;
	}

	public ClasesVehiculo getClasesVehiculo() {
		return this.clasesVehiculo;
	}

	public void setClasesVehiculo(ClasesVehiculo clasesVehiculo) {
		this.clasesVehiculo = clasesVehiculo;
	}

	public EmpresaTransporte getEmpresaTransporte() {
		return this.empresaTransporte;
	}

	public void setEmpresaTransporte(EmpresaTransporte empresaTransporte) {
		this.empresaTransporte = empresaTransporte;
	}

	public LineasMarca getLineasMarca() {
		return this.lineasMarca;
	}

	public void setLineasMarca(LineasMarca lineasMarca) {
		this.lineasMarca = lineasMarca;
	}

	public List<Propietario> getPropietarios() {
		return this.propietarios;
	}

	public void setPropietarios(List<Propietario> propietarios) {
		this.propietarios = propietarios;
	}

}
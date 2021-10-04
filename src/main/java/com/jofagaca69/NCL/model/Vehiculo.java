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

	@Column(name="nombre_propietario")
	private String nombrePropietario;

	@Column(name="numero_interno_empresa")
	private int numeroInternoEmpresa;

	//bi-directional many-to-one association to Revision
	@OneToMany(mappedBy="vehiculo")
	private List<Revision> revisiones;

	//bi-directional many-to-one association to ClaseVehiculo
	@ManyToOne
	@JoinColumn(name="clase_vehiculo_id")
	private ClaseVehiculo claseVehiculo;

	//bi-directional many-to-many association to Conductor
	@ManyToMany
	@JoinTable(
		name="conductores_has_vehiculos"
		, joinColumns={
			@JoinColumn(name="vehiculo_placa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="conductor_cedula")
			}
		)
	private List<Conductor> conductores;

	//bi-directional many-to-one association to EmpresaTransporte
	@ManyToOne
	@JoinColumn(name="empresa_transportes_id")
	private EmpresaTransporte empresaTransporte;

	//bi-directional many-to-one association to LineaMarca
	@ManyToOne
	@JoinColumn(name="lineas_marcas_id")
	private LineaMarca lineaMarca;

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

	public String getNombrePropietario() {
		return this.nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
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

	public ClaseVehiculo getClaseVehiculo() {
		return this.claseVehiculo;
	}

	public void setClaseVehiculo(ClaseVehiculo claseVehiculo) {
		this.claseVehiculo = claseVehiculo;
	}

	public List<Conductor> getConductores() {
		return this.conductores;
	}

	public void setConductores(List<Conductor> conductores) {
		this.conductores = conductores;
	}

	public EmpresaTransporte getEmpresaTransporte() {
		return this.empresaTransporte;
	}

	public void setEmpresaTransporte(EmpresaTransporte empresaTransporte) {
		this.empresaTransporte = empresaTransporte;
	}

	public LineaMarca getLineaMarca() {
		return this.lineaMarca;
	}

	public void setLineaMarca(LineaMarca lineaMarca) {
		this.lineaMarca = lineaMarca;
	}

}
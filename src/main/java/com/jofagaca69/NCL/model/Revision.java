package com.jofagaca69.NCL.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the revisiones database table.
 * 
 */
@Entity
@Table(name="revisiones")
@NamedQuery(name="Revision.findAll", query="SELECT r FROM Revision r")
public class Revision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_prueba")
	private Date fechaPrueba;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;

	private int kilometraje;

	@Column(name="num_ficha")
	private int numFicha;

	@Temporal(TemporalType.DATE)
	@Column(name="periodo_gracia")
	private Date periodoGracia;

	//bi-directional many-to-one association to Certificado
	@OneToMany(mappedBy="revision")
	private List<Certificado> certificados;

	//bi-directional many-to-many association to Categoria
	@ManyToMany
	@JoinTable(
		name="revisiones_has_categorias"
		, joinColumns={
			@JoinColumn(name="revisiones_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="categorias_id")
			}
		)
	private List<Categoria> categorias;

	//bi-directional many-to-one association to Foto
	@ManyToOne
	@JoinColumn(name="fotos_id")
	private Foto foto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	private Vehiculo vehiculo;

	public Revision() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaPrueba() {
		return this.fechaPrueba;
	}

	public void setFechaPrueba(Date fechaPrueba) {
		this.fechaPrueba = fechaPrueba;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public int getNumFicha() {
		return this.numFicha;
	}

	public void setNumFicha(int numFicha) {
		this.numFicha = numFicha;
	}

	public Date getPeriodoGracia() {
		return this.periodoGracia;
	}

	public void setPeriodoGracia(Date periodoGracia) {
		this.periodoGracia = periodoGracia;
	}

	public List<Certificado> getCertificados() {
		return this.certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}

	public Certificado addCertificado(Certificado certificado) {
		getCertificados().add(certificado);
		certificado.setRevision(this);

		return certificado;
	}

	public Certificado removeCertificado(Certificado certificado) {
		getCertificados().remove(certificado);
		certificado.setRevision(null);

		return certificado;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Foto getFoto() {
		return this.foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
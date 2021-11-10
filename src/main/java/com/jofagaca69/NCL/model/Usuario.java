package com.jofagaca69.NCL.model;

import java.io.Serializable;
import javax.persistence.*;

import org.json.JSONObject;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String apellidos;

	private int celular;

	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createdAt;

	private String email;

	private String estado;

	private String nombres;

	@Column(name="numero_dni")
	private int numeroDni;

	private String password;

	@Column(name="tipo_dni")
	private String tipoDni;

	//bi-directional many-to-one association to Certificado
	@OneToMany(mappedBy="usuario")
	private List<Certificado> certificados;

	//bi-directional many-to-one association to Revision
	@OneToMany(mappedBy="usuario")
	private List<Revision> revisiones;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="roles_id")
	private Rol rol;

	public Usuario() {
	}
	
	public Usuario(String username, String nombres, String apellidos, String tipoDni, int numeroDni, String password,
			String email, int celular, Rol rol) {
		super();
		this.username = username;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoDni = tipoDni;
		this.numeroDni = numeroDni;
		this.password = password;
		this.email = email;
		this.celular = celular;
		this.rol = rol;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getCelular() {
		return this.celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getNumeroDni() {
		return this.numeroDni;
	}

	public void setNumeroDni(int numeroDni) {
		this.numeroDni = numeroDni;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoDni() {
		return this.tipoDni;
	}

	public void setTipoDni(String tipoDni) {
		this.tipoDni = tipoDni;
	}

	public List<Certificado> getCertificados() {
		return this.certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}

	public Certificado addCertificado(Certificado certificado) {
		getCertificados().add(certificado);
		certificado.setUsuario(this);

		return certificado;
	}

	public Certificado removeCertificado(Certificado certificado) {
		getCertificados().remove(certificado);
		certificado.setUsuario(null);

		return certificado;
	}

	public List<Revision> getRevisiones() {
		return this.revisiones;
	}

	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
	}

	public Revision addRevisione(Revision revisione) {
		getRevisiones().add(revisione);
		revisione.setUsuario(this);

		return revisione;
	}

	public Revision removeRevisione(Revision revisione) {
		getRevisiones().remove(revisione);
		revisione.setUsuario(null);

		return revisione;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "Usuario {username=" + username + ", nombres=" + nombres + ", apellidos=" + apellidos + ", tipoDni="
				+ tipoDni + ", numeroDni=" + numeroDni + ", password=" + password + ", email=" + email + ", celular="
				+ celular + ", rol=" + rol + ", createdAt=" + createdAt + ", certificados=" + certificados
				+ ", revisiones=" + revisiones + "}";
	}
	
	public JSONObject toJson() {
		JSONObject usuarioJson = new JSONObject();
		usuarioJson.put("username", this.getUsername());
		usuarioJson.put("nombres", this.getNombres());
		usuarioJson.put("apellidos", this.getApellidos());
		usuarioJson.put("rol", this.getRol().getNombre());
		return usuarioJson;
	}
	
	public String toInfoBasica() {
		JSONObject usuarioJson = new JSONObject();
		usuarioJson.put("username", this.getUsername());
		usuarioJson.put("nombres", this.getNombres());
		usuarioJson.put("apellidos", this.getApellidos());
		usuarioJson.put("tipoDni", this.getTipoDni());
		usuarioJson.put("numeroDni", this.getNumeroDni());
		usuarioJson.put("email", this.getEmail());
		usuarioJson.put("celular", this.getCelular());
		usuarioJson.put("rol", this.getRol().getId());
		return usuarioJson.toString();
	}

}
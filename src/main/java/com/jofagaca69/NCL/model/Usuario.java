package com.jofagaca69.NCL.model;

import java.io.Serializable;
import java.time.LocalDate;

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
	@Column(name="username")
	private String username;
	
	private String nombres;
	
	private String apellidos;

	private String tipoDni;
	
	private int numeroDni;
	
	private String password;
	
	private String email;
	
	private int celular;
	
	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="roles_id")
	private Rol rol;

	@Column(name="created_at", columnDefinition = "DATE")
	private LocalDate createdAt;
	
	//bi-directional many-to-one association to Certificado
	@OneToMany(mappedBy="usuario")
	private List<Certificado> certificados;
		
	//bi-directional many-to-one association to Revision
	@OneToMany(mappedBy="usuario")
	private List<Revision> revisiones;	
	
	public Usuario() {
	}
	

	public Usuario(String username, String nombres, String apellidos, String tipoDni, int numeroDni, String password,
			String email, int celular, Rol rol, LocalDate createdAt) {
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
		this.createdAt = createdAt;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoDni() {
		return tipoDni;
	}

	public void setTipoDni(String tipoDni) {
		this.tipoDni = tipoDni;
	}

	public int getNumeroDni() {
		return numeroDni;
	}

	public void setNumeroDni(int numeroDni) {
		this.numeroDni = numeroDni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public List<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}

	public List<Revision> getRevisiones() {
		return revisiones;
	}

	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
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
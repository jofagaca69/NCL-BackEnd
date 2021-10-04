package com.jofagaca69.NCL.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofagaca69.NCL.controller.UsuarioController;
import com.jofagaca69.NCL.model.Rol;
import com.jofagaca69.NCL.model.Usuario;
import com.jofagaca69.NCL.repository.IRolRepository;
import com.jofagaca69.NCL.repository.IUsuarioRepository;
import com.jofagaca69.NCL.service.IUsuarioService;


@Service
public class UsuarioService implements IUsuarioService{
	
	private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private IUsuarioRepository usuarioRepo;
	
	@Autowired
	private IRolRepository rolRepo;
	
	@Override
	public Usuario autenticacion(String username, String password) {
		try {
			
			Usuario aux = usuarioRepo.getOne(username);
			logger.info(aux.toString());
			if (aux.getPassword().equals(password)) {
				logger.info("Credenciales correctas");
				return aux;
			} else {
				logger.warn("Credenciales incorrectas");
				return null;
			}
		} catch (Exception e) {
			logger.error(e.toString());
			logger.error("No existe usuario");
			return null;
		}
	}

	@Override
	public boolean crearUsuario(JSONObject usuarioNuevoInfo) {
		
		try {
			Rol rol = rolRepo.getOne(usuarioNuevoInfo.getInt("rol"));
			LocalDate fechaActual = LocalDate.now();
			Usuario usuarioNuevo = new Usuario(usuarioNuevoInfo.getString("username"), usuarioNuevoInfo.getString("nombres"), usuarioNuevoInfo.getString("apellidos"), 
					usuarioNuevoInfo.getString("tipoDni"), usuarioNuevoInfo.getInt("numeroDni"), usuarioNuevoInfo.getString("password"), usuarioNuevoInfo.getString("email"), usuarioNuevoInfo.getInt("celular"), 
					rol, fechaActual);
			
			if (usuarioRepo.save(usuarioNuevo) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error(e.toString());
			return false;
		}
	}

	@Override
	public String buscarUsuarios() {
		JSONArray usuarios = new JSONArray();
		List<Usuario> usuariosLista = new ArrayList();
		usuariosLista = usuarioRepo.findAll();
		for (Usuario usuario : usuariosLista) {
			usuarios.put(usuario.toJson());
		}
		return usuarios.toString();
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		try {
			Usuario usuario = usuarioRepo.getOne(username);
			if (usuario != null) {
				return usuario;
			}
			return null;
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		}
	}

	@Override
	public boolean actualizarUsuario(JSONObject usuarioNuevoInfo) {
		// TODO Auto-generated method stub
		return false;
	}

}

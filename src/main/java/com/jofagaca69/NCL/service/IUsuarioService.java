package com.jofagaca69.NCL.service;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.jofagaca69.NCL.model.Usuario;

public interface IUsuarioService {

	Usuario autenticacion(String username, String password);

	boolean crearUsuario(JSONObject usuarioNuevoInfo);

	String buscarUsuarios();

	Usuario obtenerUsuario(String username);

	boolean actualizarUsuario(JSONObject usuarioNuevoInfo);

}

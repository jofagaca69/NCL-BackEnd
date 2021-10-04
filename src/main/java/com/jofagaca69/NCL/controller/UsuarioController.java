package com.jofagaca69.NCL.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jofagaca69.NCL.controller.UsuarioController;
import com.jofagaca69.NCL.model.Usuario;
import com.jofagaca69.NCL.security.SecurityService;
import com.jofagaca69.NCL.service.IUsuarioService;
import com.jofagaca69.NCL.service.UsuarioService;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuarioController {
	
	private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/login")
	public String login(@RequestBody String credenciales) {
		
		JSONObject respuesta = new JSONObject();
		JSONObject cred = new JSONObject(credenciales);
		Usuario userLogin = usuarioService.autenticacion(cred.get("username").toString(), cred.get("password").toString());
		
		if (userLogin != null) {
			respuesta.put("username", userLogin.getUsername());
			String token = securityService.getJWTToken(cred.get("username").toString());
			respuesta.put("token", token);
			respuesta.put("value", "True");
			return respuesta.toString();
		} else {
			respuesta.put("value", "False");
			return respuesta.toString();
		}
		
	}
	
	@GetMapping("/hello")
	public String hello() {
		try {
			return "Hello world";
		} catch (Exception e) {
			return e.toString();
		}
	}

	@PostMapping("/crearUsuario")
	public String crearUsuario(@RequestBody String usuarioData){
		JSONObject respuesta = new JSONObject();
		JSONObject usuarioNuevoInfo = new JSONObject(usuarioData);
		
		if (usuarioService.crearUsuario(usuarioNuevoInfo)) {
			respuesta.put("value", "true");
			return respuesta.toString();
		}
		
		respuesta.put("value", "false");
		return respuesta.toString();
		
	}
	
	@GetMapping("/consultarUsuarios")
	public String consultarUsuarios(){
		
		JSONObject respuesta = new JSONObject();
		if ( usuarioService.buscarUsuarios() != null) {
			return usuarioService.buscarUsuarios();
		}
		respuesta.put("value", "false");
		return respuesta.toString();
		
	}
	
	@PostMapping("/obtenerUsuario")
	public String obtenerUsuario(@RequestBody String username){
		JSONObject respuesta = new JSONObject();
		JSONObject usuarioNuevoInfo = new JSONObject(username);
		Usuario usuarioInfo = usuarioService.obtenerUsuario(usuarioNuevoInfo.getString("username"));
		
		if (usuarioInfo != null) {
			
			return usuarioInfo.toInfoBasica();
		}
		
		respuesta.put("value", "false");
		return respuesta.toString();
		
	}
	
	@PutMapping("/actualizarUsuario")
	public String actualizarUsuario(@RequestBody String usuarioData){
		JSONObject respuesta = new JSONObject();
		JSONObject usuarioNuevoInfo = new JSONObject(usuarioData);
		
		if (usuarioService.actualizarUsuario(usuarioNuevoInfo)) {
			respuesta.put("value", "true");
			return respuesta.toString();
		}
		
		respuesta.put("value", "false");
		return respuesta.toString();
		
	}
}

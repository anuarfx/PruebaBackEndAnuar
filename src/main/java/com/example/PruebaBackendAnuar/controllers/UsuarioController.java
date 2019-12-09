package com.example.PruebaBackendAnuar.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.PruebaBackendAnuar.entity.Usuario;
import com.example.PruebaBackendAnuar.model.Procesado;
import com.example.PruebaBackendAnuar.repository.UsuarioRepositorio;



@Controller
public class UsuarioController {

	// Se crea una variable de la clase UsuarioRepositorio para poder utilizar los metodos
	// del crud de el modelo Usuario
	@Autowired
	UsuarioRepositorio repositorio;
	
	/* se crea la url raiz de nuestra pagina web y creamos un metodo index que le pasamos
	 * un objeto de la clase Model para agregar atributos a nuestra vista y enviar los
	 * datos que tiene nuestro modelo usuario 
	 */
	@GetMapping("/")
	public String Index(Model modelo) {
		modelo.addAttribute("usuarios",repositorio.findAll());
		return "index";
	}
	
	/* se crea la url para poder visualizar el formulario para crear un nuevo usuario
	 * y un metodo que retornara el formulario
	 */
	@GetMapping("/crearusuario")
	public String CrearUsuario(Model modelo, Usuario usuario) {
		modelo.addAttribute("usuario",new Usuario());
		
		return "crear";
	}
	
	/* url para guardar los datos que se agregaron en el formulario 
	 * y se creo el metodo que recibe los datos y se guarda en H2 Database
	 */
	@PostMapping("/guardarusuario")
	public String GuardarUsuario(Model modelo, Usuario usuario) {
		repositorio.save(usuario);
		modelo.addAttribute("usuarios",repositorio.findAll());
		return "redirect:/";
	}
	
	/* se crea la url para actualizar el estado del registro de no procesado a procesado
	 * aqui recibe los parametros, por medio de ajax se realiza la solicitud para obtener 
	 * los multiples registros seleccionado en la pagina web 
	 */
	@PostMapping("/procesarusuario")
	public String ProcesarUsuario(@RequestBody List<Procesado> procesado,Model modelo) {
		modelo.addAttribute("usuarios",repositorio.findAll());
		
	         for (Procesado data :procesado) {
	        	 Usuario usuario = repositorio.findById(data.getId()).get();
	        	 usuario.setProcesado(data.isProcesado());
	        	 repositorio.save(usuario);
	         }
	    
		return "index";
	}
	
}

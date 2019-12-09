package com.example.PruebaBackendAnuar.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.PruebaBackendAnuar.entity.Usuario;
/*2.	Posterior a esto se crea una clase llamada UsuarioRepositorio que va a 
 * extender de la clase CrudRepository que por defecto crea algunos métodos que 
 * nos ayuda a crear un Crud para un modelo.*/
public interface UsuarioRepositorio extends CrudRepository<Usuario,Long> {

}

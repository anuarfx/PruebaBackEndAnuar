package com.example.PruebaBackendAnuar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
/*De acuerdo al ejercicio planteado se debía crear una base de datos en H2 Database 
 * para almacenar los dados creados en el formulario, se creó una clase llamada
 *  Usuario donde se le agrego una anotación de la clase entity con el fin de crear 
 *  la tabla en H2 Database, en esa clase se incluyen todos los campos que irán en la 
 *  tabla con sus constuctores y métodos getter y setter.*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String apellido;
	private boolean procesado;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nombre, String apellido, Boolean procesado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.procesado = procesado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Boolean getProcesado() {
		return procesado;
	}

	public void setProcesado(Boolean procesado) {
		this.procesado = procesado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", procesado=" + procesado + "]";
	}
	
	
}

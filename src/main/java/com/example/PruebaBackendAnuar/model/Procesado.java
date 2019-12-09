package com.example.PruebaBackendAnuar.model;

public class Procesado {
/* esta clase se creo para recibir los parametros de ajax y obtener los valores para poder 
 * ser utilizado y actualizar nuestro registro
 * */
	private long id;
	private boolean procesado;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isProcesado() {
		return procesado;
	}
	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}
	
	
}

package sv.com.telefonica.model.dto;

import java.io.Serializable;

public class ActCustomClienteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idCliente;
	private String nombreCliente;
	private String tipoPersona;
	private String telefono;
	private String email;
	private String creadoPor;
	private String fechaCreado;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getFechaCreado() {
		return fechaCreado;
	}

	public void setFechaCreado(String fechaCreado) {
		this.fechaCreado = fechaCreado;
	}
	
	

}

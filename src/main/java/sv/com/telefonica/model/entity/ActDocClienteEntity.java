package sv.com.telefonica.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "act_doc_cliente")
public class ActDocClienteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_doc_cliente", nullable = false)
	private Integer id;

	@Column(name = "numero_documento", length = 30, nullable = false)
	private String numeroDocumento;
	
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
	@ManyToOne(optional = false)
	private ActClienteEntity actClienteEntity;

	@JoinColumn(name = "id_doc_tipo_persona", referencedColumnName = "id_doc_tipo_persona", nullable = false)
	@ManyToOne(optional = false)
	private ActDocTipoPersonaEntity actDocTipoPersonaEntity;
	
	@Column(name = "creado_por", length = 100)
	private String creadoPor;

	@Column(name = "modificado_por", length = 100)
	private String modificadoPor;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreado;

	@Column(name = "fecha_modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ActClienteEntity getActClienteEntity() {
		return actClienteEntity;
	}

	public void setActClienteEntity(ActClienteEntity actClienteEntity) {
		this.actClienteEntity = actClienteEntity;
	}

	public ActDocTipoPersonaEntity getActDocTipoPersonaEntity() {
		return actDocTipoPersonaEntity;
	}

	public void setActDocTipoPersonaEntity(ActDocTipoPersonaEntity actDocTipoPersonaEntity) {
		this.actDocTipoPersonaEntity = actDocTipoPersonaEntity;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public Date getFechaCreado() {
		return fechaCreado;
	}

	public void setFechaCreado(Date fechaCreado) {
		this.fechaCreado = fechaCreado;
	}

	public Date getFechaModificado() {
		return fechaModificado;
	}

	public void setFechaModificado(Date fechaModificado) {
		this.fechaModificado = fechaModificado;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	

}

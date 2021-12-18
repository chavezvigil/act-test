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
@Table(name = "act_doc_tipo_persona")
public class ActDocTipoPersonaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_doc_tipo_persona", nullable = false)
	private Integer id;

	@JoinColumn(name = "id_tipo_persona", referencedColumnName = "id_tipo_persona", nullable = false)
	@ManyToOne(optional = false)
	private ActTipoPersonaEntity actTipoPersonaEntity;

	@JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento", nullable = false)
	@ManyToOne(optional = false)
	private ActTipoDocumentoEntity actTipoDocumentoEntity;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ActTipoPersonaEntity getActTipoPersonaEntity() {
		return actTipoPersonaEntity;
	}

	public void setActTipoPersonaEntity(ActTipoPersonaEntity actTipoPersonaEntity) {
		this.actTipoPersonaEntity = actTipoPersonaEntity;
	}

	public ActTipoDocumentoEntity getActTipoDocumentoEntity() {
		return actTipoDocumentoEntity;
	}

	public void setActTipoDocumentoEntity(ActTipoDocumentoEntity actTipoDocumentoEntity) {
		this.actTipoDocumentoEntity = actTipoDocumentoEntity;
	}
	
	

}

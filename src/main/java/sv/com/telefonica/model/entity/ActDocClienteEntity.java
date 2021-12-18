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
public class ActDocClienteEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_doc_cliente", nullable = false)
	private Integer id;
	
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
	@ManyToOne(optional = false)
	private ActClienteEntity actClienteEntity;
	
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
	
	
	
	
	
}

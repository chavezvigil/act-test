package sv.com.telefonica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sv.com.telefonica.model.entity.ActDocTipoPersonaEntity;

public interface ActDocTipoPersonaRepository extends JpaRepository<ActDocTipoPersonaEntity, Long>{

	
	@Query("SELECT u FROM ActDocTipoPersonaEntity u WHERE u.actTipoPersonaEntity.id = ?1")
	public List<ActDocTipoPersonaEntity> findByIdTipoPersona(Integer idTipoPersona);
}

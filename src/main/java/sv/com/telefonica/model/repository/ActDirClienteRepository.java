package sv.com.telefonica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sv.com.telefonica.model.entity.ActDirClienteEntity;

public interface ActDirClienteRepository extends JpaRepository<ActDirClienteEntity, Long> {

	@Query("SELECT u FROM ActDirClienteEntity u WHERE u.actClienteEntity.id = ?1")
	public List<ActDirClienteEntity> findByIdCliente(Integer idCliente);
	
}

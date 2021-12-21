package sv.com.telefonica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sv.com.telefonica.model.entity.ActDocClienteEntity;

public interface ActDocClienteRepository extends JpaRepository<ActDocClienteEntity, Long> {

	
	@Query("SELECT u FROM ActDocClienteEntity u WHERE u.actClienteEntity.id = ?1")
	public List<ActDocClienteEntity> findByIdCliente(Integer idCliente);
}

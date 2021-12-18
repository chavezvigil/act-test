package sv.com.telefonica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sv.com.telefonica.model.entity.ActUsuarioEntity;

public interface ActUsuarioRepository extends JpaRepository<ActUsuarioEntity, Long> {

	@Query("SELECT u FROM ActUsuarioEntity u WHERE u.email = ?1")
	public ActUsuarioEntity findByEmail(String email);

}

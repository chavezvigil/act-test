package sv.com.telefonica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.com.telefonica.model.entity.ActClienteEntity;

public interface ActClienteRepository extends JpaRepository<ActClienteEntity, Long> {

	List<ActClienteEntity> findById(Integer id);
}

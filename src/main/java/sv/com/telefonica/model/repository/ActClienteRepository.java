package sv.com.telefonica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.com.telefonica.model.entity.ActClienteEntity;

public interface ActClienteRepository extends JpaRepository<ActClienteEntity, Long> {

}

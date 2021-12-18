package sv.com.telefonica;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import sv.com.telefonica.model.entity.ActClienteEntity;
import sv.com.telefonica.model.entity.ActTipoPersonaEntity;
import sv.com.telefonica.model.repository.ActClienteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ActClientesTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ActClienteRepository repo;

	@Test
	public void testCreateUser() {
		ActClienteEntity cliente = new ActClienteEntity();
		ActTipoPersonaEntity tipoPer = entityManager.find(ActTipoPersonaEntity.class, 1);
		
		cliente.setActTipoPersonaEntity(tipoPer);
		cliente.setNombreCliente("Luis Josué Chávez Vigil");
		cliente.setEmail("ljosue.chavez@gmail.com");
		cliente.setTelefono("7617-2548");
		cliente.setFechaCreado(new Date());
		cliente.setFechaModificado(new Date());
		cliente.setCreadoPor("lchavez");
		cliente.setModificadoPor("lchavez");

		ActClienteEntity savedCliente = repo.save(cliente);
		ActClienteEntity existCliente = entityManager.find(ActClienteEntity.class, savedCliente.getId());
		assertThat(cliente.getEmail()).isEqualTo(existCliente.getEmail());

	}
}

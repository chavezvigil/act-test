package sv.com.telefonica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import sv.com.telefonica.model.entity.ActTipoPersonaEntity;
import sv.com.telefonica.model.repository.ActTipoPersonaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ActTipoPersonaTests {

	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ActTipoPersonaRepository repo;

	@Test
	public void testCreateUser() {
		ActTipoPersonaEntity tipoPersona = new ActTipoPersonaEntity();
		tipoPersona.setDescripcion("Persona Jurídica");

		ActTipoPersonaEntity savedTpi = repo.save(tipoPersona);
		ActTipoPersonaEntity existTpe = entityManager.find(ActTipoPersonaEntity.class, savedTpi.getId());
		assertThat(tipoPersona.getDescripcion()).isEqualTo(existTpe.getDescripcion());

	}
}

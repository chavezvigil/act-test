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
		
		ActTipoPersonaEntity natural = new ActTipoPersonaEntity();
		natural.setDescripcion("Persona Natural");
		natural.setFechaCreado(new Date());
		natural.setFechaModificado(new Date());
		natural.setCreadoPor("lchavez");
		natural.setModificadoPor("lchavez");

		ActTipoPersonaEntity savedNat = repo.save(natural);
		ActTipoPersonaEntity existNat = entityManager.find(ActTipoPersonaEntity.class, savedNat.getId());
		assertThat(natural.getDescripcion()).isEqualTo(existNat.getDescripcion());
		
		ActTipoPersonaEntity juridica = new ActTipoPersonaEntity();
		juridica.setDescripcion("Persona Jurídica");
		juridica.setFechaCreado(new Date());
		juridica.setFechaModificado(new Date());
		juridica.setCreadoPor("lchavez");
		juridica.setModificadoPor("lchavez");

		ActTipoPersonaEntity savedJur = repo.save(juridica);
		ActTipoPersonaEntity existJur = entityManager.find(ActTipoPersonaEntity.class, savedJur.getId());
		assertThat(juridica.getDescripcion()).isEqualTo(existJur.getDescripcion());
		
		


	}
}

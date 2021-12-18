package sv.com.telefonica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import sv.com.telefonica.model.entity.ActTipoDocumentoEntity;
import sv.com.telefonica.model.repository.ActTipoDocumentoRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ActTipoDocumentoTests {

	//Lchavez g
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ActTipoDocumentoRepository repo;

	@Test
	public void testCreateUser() {
		ActTipoDocumentoEntity tipoDocumento = new ActTipoDocumentoEntity();
		tipoDocumento.setNombre("NIT");
		tipoDocumento.setMascara("9999-999999-999-9");

		ActTipoDocumentoEntity savedTdo = repo.save(tipoDocumento);
		ActTipoDocumentoEntity existTdo = entityManager.find(ActTipoDocumentoEntity.class, savedTdo.getId());
		assertThat(tipoDocumento.getNombre()).isEqualTo(existTdo.getNombre());

	}
	
}

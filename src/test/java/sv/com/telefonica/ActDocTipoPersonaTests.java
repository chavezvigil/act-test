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

import sv.com.telefonica.model.entity.ActDocTipoPersonaEntity;
import sv.com.telefonica.model.entity.ActTipoDocumentoEntity;
import sv.com.telefonica.model.entity.ActTipoPersonaEntity;
import sv.com.telefonica.model.repository.ActDocTipoPersonaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ActDocTipoPersonaTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ActDocTipoPersonaRepository repo;

	@Test
	public void testCreateUser() {
		ActDocTipoPersonaEntity docTpe = new ActDocTipoPersonaEntity();
		ActTipoDocumentoEntity tipoDoc = entityManager.find(ActTipoDocumentoEntity.class, 2);
		ActTipoPersonaEntity tipoPer = entityManager.find(ActTipoPersonaEntity.class, 1);

		docTpe.setActTipoDocumentoEntity(tipoDoc);
		docTpe.setActTipoPersonaEntity(tipoPer);
		docTpe.setFechaCreado(new Date());
		docTpe.setFechaModificado(new Date());
		docTpe.setCreadoPor("lchavez");
		docTpe.setModificadoPor("lchavez");

		ActDocTipoPersonaEntity savedEntity = repo.save(docTpe);
		ActDocTipoPersonaEntity existEntity = entityManager.find(ActDocTipoPersonaEntity.class, savedEntity.getId());
		assertThat(docTpe.getActTipoPersonaEntity().getId()).isEqualTo(existEntity.getActTipoPersonaEntity().getId());

	}
}

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
import sv.com.telefonica.model.entity.ActTipoDocumentoEntity;
import sv.com.telefonica.model.repository.ActTipoDocumentoRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ActTipoDocumentoTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ActTipoDocumentoRepository repo;

	@Test
	public void testCreateUser() {
		ActTipoDocumentoEntity dui = new ActTipoDocumentoEntity();
		dui.setNombre("DUI");
		dui.setMascara("99999999-9");
		dui.setFechaCreado(new Date());
		dui.setFechaModificado(new Date());
		dui.setCreadoPor("lchavez");
		dui.setModificadoPor("lchavez");

		ActTipoDocumentoEntity savedTdo = repo.save(dui);
		ActTipoDocumentoEntity existTdo = entityManager.find(ActTipoDocumentoEntity.class, savedTdo.getId());
		assertThat(dui.getNombre()).isEqualTo(existTdo.getNombre());
		
		ActTipoDocumentoEntity nit = new ActTipoDocumentoEntity();
		nit.setNombre("NIT");
		nit.setMascara("9999-999999-999-9");
		nit.setFechaCreado(new Date());
		nit.setFechaModificado(new Date());
		nit.setCreadoPor("lchavez");
		nit.setModificadoPor("lchavez");

		ActTipoDocumentoEntity savedNit = repo.save(nit);
		ActTipoDocumentoEntity existNit = entityManager.find(ActTipoDocumentoEntity.class, savedNit.getId());
		assertThat(nit.getNombre()).isEqualTo(existNit.getNombre());

	}
	
}

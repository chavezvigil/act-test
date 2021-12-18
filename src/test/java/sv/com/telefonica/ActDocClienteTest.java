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
import sv.com.telefonica.model.entity.ActDocClienteEntity;
import sv.com.telefonica.model.entity.ActDocTipoPersonaEntity;
import sv.com.telefonica.model.repository.ActDocClienteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ActDocClienteTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ActDocClienteRepository repo;

	@Test
	public void testCreateUser() {
		ActDocClienteEntity doc = new ActDocClienteEntity();
		
		ActClienteEntity cliente = entityManager.find(ActClienteEntity.class, 1);
		
		ActDocTipoPersonaEntity docTpe = entityManager.find(ActDocTipoPersonaEntity.class, 1);
		
		doc.setActClienteEntity(cliente);
		doc.setActDocTipoPersonaEntity(docTpe);
		doc.setNumeroDocumento("0210-211090-106-7");
		doc.setFechaCreado(new Date());
		doc.setFechaModificado(new Date());
		doc.setCreadoPor("lchavez");
		doc.setModificadoPor("lchavez");

		ActDocClienteEntity savedDocCliente = repo.save(doc);
		ActDocClienteEntity existDocCliente = entityManager.find(ActDocClienteEntity.class, savedDocCliente.getId());
		assertThat(doc.getActClienteEntity().getNombreCliente()).isEqualTo(existDocCliente.getActClienteEntity().getNombreCliente());

	}
}

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
import sv.com.telefonica.model.entity.ActDirClienteEntity;
import sv.com.telefonica.model.repository.ActDirClienteRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ActDirClienteTests {

	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ActDirClienteRepository repo;

	@Test
	public void testCreateUser() {
		ActDirClienteEntity dir = new ActDirClienteEntity();
		ActClienteEntity cliente = entityManager.find(ActClienteEntity.class, 1);
		
		dir.setActClienteEntity(cliente);
		dir.setDireccion("Santa Ana");
		dir.setFechaCreado(new Date());
		dir.setFechaModificado(new Date());
		dir.setCreadoPor("lchavez");
		dir.setModificadoPor("lchavez");

		ActDirClienteEntity savedDirCliente = repo.save(dir);
		ActDirClienteEntity existDirCliente = entityManager.find(ActDirClienteEntity.class, savedDirCliente.getId());
		assertThat(dir.getActClienteEntity().getNombreCliente()).isEqualTo(existDirCliente.getActClienteEntity().getNombreCliente());

	}
	
}

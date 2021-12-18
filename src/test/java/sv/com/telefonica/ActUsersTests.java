package sv.com.telefonica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import sv.com.telefonica.model.entity.ActUsuarioEntity;
import sv.com.telefonica.model.repository.ActUsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ActUsersTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ActUsuarioRepository repo;

	@Test
	public void testCreateUser() {
		ActUsuarioEntity user = new ActUsuarioEntity();
		user.setEmail("ljosue.chavez@gmail.com");
		user.setPassword("Pa$$w0rd");
		user.setFirstName("Luis");
		user.setLastName("Chavez");

		ActUsuarioEntity savedUser = repo.save(user);
		ActUsuarioEntity existUser = entityManager.find(ActUsuarioEntity.class, savedUser.getId());
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

	}
}

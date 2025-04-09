package secretaria.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import secretaria.graphql.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
}

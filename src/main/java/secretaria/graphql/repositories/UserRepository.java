package secretaria.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import secretaria.graphql.entities.User;
import secretaria.graphql.enums.Role;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Query("SELECT u.role FROM User u WHERE u.username = :nombre")
    Role findRoleByUsername(String nombre);

}

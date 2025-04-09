package secretaria.graphql.services;

import org.springframework.stereotype.Service;
import secretaria.graphql.entities.User;
import secretaria.graphql.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(Integer id){
        return userRepository.findById(id);
    }
}

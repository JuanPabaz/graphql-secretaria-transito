package secretaria.graphql.services;

import org.springframework.stereotype.Service;
import secretaria.graphql.entities.Registration;
import secretaria.graphql.repositories.RegistrationRepository;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Registration save(Registration registration) {
        return registrationRepository.save(registration);
    }
}

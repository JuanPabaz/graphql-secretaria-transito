package secretaria.graphql.services;

import org.springframework.stereotype.Service;
import secretaria.graphql.dto.VehicleRequestDTO;
import secretaria.graphql.dto.VehicleResponseDTO;
import secretaria.graphql.entities.Registration;
import secretaria.graphql.entities.User;
import secretaria.graphql.entities.Vehicle;
import secretaria.graphql.exceptions.BadCreateRequest;
import secretaria.graphql.maps.VehicleMapper;
import secretaria.graphql.repositories.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final UserService userService;
    private final RegistrationService registrationService;

    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper, UserService userService, RegistrationService registrationService) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
        this.userService = userService;
        this.registrationService = registrationService;
    }

    public Optional<Vehicle> getVehicleByVehicleId(Long vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    public List<VehicleResponseDTO> getVehicleByOwnerOwnerId(Integer ownerId) {
        return vehicleMapper.mapVehicleList(vehicleRepository.findVehicleByUser(ownerId));
    }

    public VehicleResponseDTO saveVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Optional<User> userOptional = userService.findUserById(vehicleRequestDTO.getUserId());
        if (userOptional.isEmpty()) {
            throw new BadCreateRequest("No se encontró el propietario.");
        }

        Registration registration = new Registration();
        registration.setUser(userOptional.get());
        registration.setRegistrationDate(vehicleRequestDTO.getRegistrationDate());
        registration.setBrand(vehicleRequestDTO.getBrand());
        registration.setLicensePlate(vehicleRequestDTO.getLicensePlate());

        Registration registrationSaved = registrationService.save(registration);

        Vehicle vehicle = new Vehicle();
        vehicle.setRegistration(registrationSaved);
        vehicle.setVehicleType(vehicleRequestDTO.getVehicleType());

        return vehicleMapper.mapVehicle(vehicleRepository.save(vehicle));
    }
}

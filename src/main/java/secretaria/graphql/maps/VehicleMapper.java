package secretaria.graphql.maps;

import org.springframework.stereotype.Component;
import secretaria.graphql.dto.VehicleResponseDTO;
import secretaria.graphql.entities.Vehicle;

import java.util.List;

@Component
public class VehicleMapper {

    public VehicleResponseDTO mapVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }

        VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();
        vehicleResponseDTO.setVehicleId(vehicle.getVehicleId());
        vehicleResponseDTO.setVehicleType(vehicle.getVehicleType());
        vehicleResponseDTO.setBrand(vehicle.getRegistration().getBrand());
        vehicleResponseDTO.setLicensePlate(vehicle.getRegistration().getLicensePlate());
        vehicleResponseDTO.setRegistrationDate(vehicle.getRegistration().getRegistrationDate());
        vehicleResponseDTO.setOwnerName(vehicle.getRegistration().getUser().getFullName());

        return vehicleResponseDTO;
    }

    public List<VehicleResponseDTO> mapVehicleList(List<Vehicle> vehicleList) {
        return vehicleList.stream()
                .map(this::mapVehicle)
                .toList();
    }

}

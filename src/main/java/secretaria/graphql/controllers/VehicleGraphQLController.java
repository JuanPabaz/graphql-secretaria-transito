package secretaria.graphql.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import secretaria.graphql.dto.VehicleRequestDTO;
import secretaria.graphql.dto.VehicleResponseDTO;
import secretaria.graphql.services.VehicleService;

import java.util.List;

@Controller
public class VehicleGraphQLController {

    private final VehicleService vehicleService;

    public VehicleGraphQLController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @QueryMapping
    public List<VehicleResponseDTO> getVehicleByOwnerId(@Argument Integer ownerId) {
        return vehicleService.getVehicleByOwnerOwnerId(ownerId);
    }

    @MutationMapping
    public VehicleResponseDTO saveVehicle(@Argument VehicleRequestDTO vehicleRequest) {
        return vehicleService.saveVehicle(vehicleRequest);
    }
}


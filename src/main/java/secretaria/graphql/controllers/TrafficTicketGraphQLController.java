package secretaria.graphql.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import secretaria.graphql.dto.TrafficTicketResponseDTO;
import secretaria.graphql.services.TrafficTicketService;

import java.util.List;

@Controller
public class TrafficTicketGraphQLController {

    private final TrafficTicketService trafficTicketService;

    public TrafficTicketGraphQLController(TrafficTicketService trafficTicketService) {
        this.trafficTicketService = trafficTicketService;
    }

    @QueryMapping(name = "getTrafficTicketByUserId")
    public List<TrafficTicketResponseDTO> getTrafficTicketsByUser(@Argument(name = "userId") Integer userId) {
        return trafficTicketService.getTrafficTicketByUserId(userId);
    }

    @QueryMapping(name = "getTrafficTicketByVehicleId")
    public List<TrafficTicketResponseDTO> getTrafficTicketsByVehicle(@Argument(name = "vehicleId") Long vehicleId) {
        return trafficTicketService.getTrafficTicketByVehicleId(vehicleId);
    }

    @MutationMapping(name = "generateInvoicePdf")
    public String generateInvoicePdf(@Argument("userId") Integer idUser, @Argument("trafficTicketId") Long idTrafficTicket) {
        return trafficTicketService.generateInvoicePdf(idUser, idTrafficTicket);
    }
}


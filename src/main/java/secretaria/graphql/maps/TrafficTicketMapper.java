package secretaria.graphql.maps;

import org.springframework.stereotype.Component;
import secretaria.graphql.dto.TrafficTicketResponseDTO;
import secretaria.graphql.entities.TrafficTicket;


import java.util.List;

@Component
public class TrafficTicketMapper {

    public TrafficTicketResponseDTO mapTrafficTicket(TrafficTicket trafficTicket) {
        if (trafficTicket == null) {
            return null;
        }

        TrafficTicketResponseDTO trafficTicketResponseDTO = new TrafficTicketResponseDTO();
        trafficTicketResponseDTO.setVehicleId(trafficTicket.getVehicle().getVehicleId());
        trafficTicketResponseDTO.setUserId(trafficTicket.getVehicle().getRegistration().getUser().getIdUser());
        trafficTicketResponseDTO.setTrafficTicketId(trafficTicket.getTrafficTicketId());
        trafficTicketResponseDTO.setDate(trafficTicket.getDate());
        trafficTicketResponseDTO.setTrafficAgentName(
                (trafficTicket.getTrafficAgent() != null && trafficTicket.getTrafficAgent().getTrafficAgentId() != null)
                        ? trafficTicket.getTrafficAgent().getName()
                        : "N/A"
        );
        trafficTicketResponseDTO.setDescription(trafficTicket.getDescription());
        trafficTicketResponseDTO.setLicensePlate(trafficTicket.getVehicle().getRegistration().getLicensePlate());
        trafficTicketResponseDTO.setCameraLocation(
                (trafficTicket.getDetectionCamera() != null && trafficTicket.getDetectionCamera().getCameraId() != null)
                        ? trafficTicket.getDetectionCamera().getLocation() : "N/A"
        );
        trafficTicketResponseDTO.setPrice(trafficTicket.getPrice());

        return trafficTicketResponseDTO;
    }

    public List<TrafficTicketResponseDTO> mapTrafficTicketList(List<TrafficTicket> trafficTicketList) {
        return trafficTicketList.stream()
                .map(this::mapTrafficTicket)
                .toList();
    }
}

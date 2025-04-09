package secretaria.graphql.services;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import secretaria.graphql.dto.TrafficTicketResponseDTO;
import secretaria.graphql.entities.TrafficTicket;
import secretaria.graphql.entities.User;
import secretaria.graphql.entities.Vehicle;
import secretaria.graphql.exceptions.BadCreateRequest;
import secretaria.graphql.maps.TrafficTicketMapper;
import secretaria.graphql.repositories.TrafficTicketRepository;
import secretaria.graphql.utils.InvoiceDetail;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrafficTicketService {

    private final TrafficTicketRepository trafficTicketRepository;
    private final VehicleService vehicleService;
    private final TrafficTicketMapper trafficTicketMapper;
    private final UserService userService;

    public TrafficTicketService(TrafficTicketRepository trafficTicketRepository, VehicleService vehicleService, TrafficTicketMapper trafficTicketMapper, UserService userService) {
        this.trafficTicketRepository = trafficTicketRepository;
        this.vehicleService = vehicleService;
        this.trafficTicketMapper = trafficTicketMapper;
        this.userService = userService;
    }

    public List<TrafficTicketResponseDTO> getTrafficTicketByVehicleId(Long vehicleId) {
        Optional<Vehicle> vehicleOptional = vehicleService.getVehicleByVehicleId(vehicleId);
        if (vehicleOptional.isEmpty()) {
            throw new BadCreateRequest("El vehiculo no existe.");
        }
        return trafficTicketMapper.mapTrafficTicketList(trafficTicketRepository.findTrafficTicketByVehicleVehicleId(vehicleId));
    }

    public List<TrafficTicketResponseDTO> getTrafficTicketByUserId(Integer userId) {
        Optional<User> userOptional = userService.findUserById(userId);
        if (userOptional.isEmpty()) {
            throw new BadCreateRequest("El propietario no existe.");
        }
        return trafficTicketMapper.mapTrafficTicketList(trafficTicketRepository.findTrafficTicketByUser(userId));
    }

    public String generateInvoicePdf(Integer idUser, Long idTrafficTicket) {
        Optional<User> userOptional = userService.findUserById(idUser);
        if (userOptional.isEmpty()) {
            throw new BadCreateRequest("El usuario no existe.");
        }
        User user = userOptional.get();

        Optional<TrafficTicket> trafficTicketOptional = trafficTicketRepository.findById(idTrafficTicket);
        if (trafficTicketOptional.isEmpty()) {
            throw new BadCreateRequest("La infracción no existe.");
        }
        TrafficTicket trafficTicket = trafficTicketOptional.get();

        String jasperFilePath = "src/main/resources/jasperInvoiceReport/pago.jasper";
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);

            InvoiceDetail invoiceDetail = new InvoiceDetail();
            invoiceDetail.setIdNumber(user.getIdNumber());
            invoiceDetail.setName(user.getFullName());
            invoiceDetail.setItem(trafficTicket.getTrafficAgent() != null ? "Parte" : "Fotomulta");
            invoiceDetail.setDescription(trafficTicket.getDescription());
            invoiceDetail.setVehicleLicensePlate(trafficTicket.getVehicle().getRegistration().getLicensePlate());
            invoiceDetail.setVehicleBrandName(trafficTicket.getVehicle().getRegistration().getBrand());
            invoiceDetail.setValue(trafficTicket.getPrice());
            invoiceDetail.setDate(new Date());

            List<InvoiceDetail> invoiceDetailList = List.of(invoiceDetail);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoiceDetailList);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFilePath, null, dataSource);

            // Convertir el PDF a un array de bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            byte[] pdfBytes = outputStream.toByteArray();

            // Codificar el PDF a Base64
            return Base64.getEncoder().encodeToString(pdfBytes);
        } catch (JRException e) {
            throw new RuntimeException("Error al generar el PDF", e);
        }
    }

}

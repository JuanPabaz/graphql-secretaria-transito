package secretaria.graphql.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "traffic_agent")
public class TrafficAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "traffic_agent_id")
    private Long trafficAgentId;

    @Column(name = "name")
    private String name;

    @Column(name = "idNumber")
    private String idNumber;

    @OneToMany(targetEntity = TrafficTicket.class, fetch = FetchType.LAZY, mappedBy = "trafficAgent")
    private List<TrafficTicket> trafficTickets;

    public TrafficAgent() {
    }

    public TrafficAgent(Long trafficAgentId, String name, String idNumber, List<TrafficTicket> trafficTickets) {
        this.trafficAgentId = trafficAgentId;
        this.name = name;
        this.idNumber = idNumber;
        this.trafficTickets = trafficTickets;
    }

    public Long getTrafficAgentId() {
        return trafficAgentId;
    }

    public void setTrafficAgentId(Long trafficAgentId) {
        this.trafficAgentId = trafficAgentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<TrafficTicket> getTrafficTickets() {
        return trafficTickets;
    }

    public void setTrafficTickets(List<TrafficTicket> trafficTickets) {
        this.trafficTickets = trafficTickets;
    }
}

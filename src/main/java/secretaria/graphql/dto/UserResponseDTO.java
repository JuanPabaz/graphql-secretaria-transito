package secretaria.graphql.dto;

import secretaria.graphql.enums.Role;

public class UserResponseDTO {

    private Integer idUser;
    private String fullName;
    private Role role;
    private String username;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Integer idUser, String fullName, Role role, String username) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.role = role;
        this.username = username;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

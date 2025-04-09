package secretaria.graphql.dto;


import secretaria.graphql.enums.Role;

public class AuthResponseDTO {

    private String accessToken;
    private String refreshToken;
    private Role role;

    public AuthResponseDTO() {
    }

    public AuthResponseDTO(String accessToken, String refreshToken, Role role) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.role = role;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

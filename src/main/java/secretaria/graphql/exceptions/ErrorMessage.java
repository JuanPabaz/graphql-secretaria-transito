package secretaria.graphql.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    private Integer statusCode;
    private HttpStatus status;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(Integer statusCode, HttpStatus status, String message) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package secretaria.graphql.exceptions;

public class ExpiredRefreshTokenException extends RuntimeException{

    public ExpiredRefreshTokenException(String message){
        super(message);
    }

}

package fr.gopartner.authentification.core.exception;

import fr.gopartner.authentification.core.rest.Codes;
import lombok.Getter;

@Getter
public class AuthenticateException extends RuntimeException {

    private Codes codes;

    public AuthenticateException(Codes codes) {
        super(codes.getMessage());
        this.codes = codes;
    }

    public AuthenticateException(String message, Codes codes) {
        super(message);
        this.codes = codes;
    }

    public AuthenticateException(String message, Throwable cause, Codes codes) {
        super(message, cause);
        this.codes = codes;
    }

    public AuthenticateException(Throwable cause, Codes codes) {
        super(cause);
        this.codes = codes;
    }

    public AuthenticateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Codes codes) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.codes = codes;
    }
}

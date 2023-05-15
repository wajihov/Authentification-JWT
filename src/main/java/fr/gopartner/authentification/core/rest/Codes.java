package fr.gopartner.authentification.core.rest;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Codes {

    ERR_AUTH_NOT_FOUND("AUTH NOT FOUND", HttpStatus.NOT_FOUND),
    ERR_AUTHS_NOT_FOUND("AUTHS NOT FOUND", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;

    Codes(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
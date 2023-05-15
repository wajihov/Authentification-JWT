package fr.gopartner.authentification.core.exception;

import fr.gopartner.authentification.core.rest.ServerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AuthenticateHandler {

    @ExceptionHandler(AuthenticateException.class)
    public ResponseEntity<ServerResponse> handlerException(AuthenticateException e) {
        ServerResponse serverResponse = ServerResponse.builder()
                .timeStamp(LocalDateTime.now())
                .message(e.getCodes().getMessage())
                .build();
        return new ResponseEntity<>(serverResponse, e.getCodes().getHttpStatus());
    }
}
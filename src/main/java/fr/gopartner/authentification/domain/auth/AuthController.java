package fr.gopartner.authentification.domain.auth;

import fr.gopartner.authentification.AuthenticateApiDelegate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthenticateApiDelegate {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }
}

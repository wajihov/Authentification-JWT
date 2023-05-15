package fr.gopartner.authentification.domain.auth;

import fr.gopartner.authentification.core.exception.AuthenticateException;
import fr.gopartner.authentification.core.rest.Codes;
import fr.gopartner.authentification.dto.AuthenticateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthMapper {

    public Auth toEntity(AuthenticateDto authenticateDto) {
        if (authenticateDto == null) {
            throw new AuthenticateException("Error Auth To Entity ", Codes.ERR_AUTH_NOT_FOUND);
        }
        return Auth.builder()
                .id(authenticateDto.getId())
                .username(authenticateDto.getUsername())
                .email(authenticateDto.getEmail())
                .password(authenticateDto.getPassword())
                .build();
    }

    public AuthenticateDto toDto(Auth auth) {
        if (auth == null) {
            throw new AuthenticateException("Error Auth To Dto", Codes.ERR_AUTH_NOT_FOUND);
        }
        return AuthenticateDto.builder()
                .id(auth.getId())
                .username(auth.getUsername())
                .email(auth.getEmail())
                .password(auth.getPassword())
                .build();
    }

    public List<AuthenticateDto> authenticateDtoList(List<Auth> auths) {
        if (auths == null) {
            throw new AuthenticateException("Auths null", Codes.ERR_AUTHS_NOT_FOUND);
        }
        return auths.stream().map(this::toDto).collect(Collectors.toList());
    }

}
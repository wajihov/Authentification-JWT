package fr.gopartner.authentification.domain.auth;

import fr.gopartner.authentification.core.exception.AuthenticateException;
import fr.gopartner.authentification.core.rest.Codes;
import fr.gopartner.authentification.dto.AuthenticateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@Slf4j
public class AuthService {

    private final AuthMapper authMapper;
    private final AuthRepository authRepository;

    public AuthService(AuthMapper authMapper, AuthRepository authRepository) {
        this.authMapper = authMapper;
        this.authRepository = authRepository;
    }


    public AuthenticateDto createAuth(AuthenticateDto authenticateDto) {
        Auth auth = authMapper.toEntity(authenticateDto);
        auth = authRepository.save(auth);
        log.info("The authenticate is added successfully {}", auth.getUsername());
        return authMapper.toDto(auth);
    }

    private Auth rechercheAuthById(Long id) {
        return authRepository.findById(id).orElseThrow(() -> new
                AuthenticateException(Codes.ERR_AUTHS_NOT_FOUND));
    }

    public AuthenticateDto searchAuthenticateById(Long id) {
        Auth auth = rechercheAuthById(id);
        log.info("The Auth searched is {}", auth.getUsername());
        return authMapper.toDto(auth);
    }

    public List<AuthenticateDto> getAllAuth() {
        List<Auth> auths = authRepository.findAll();
        log.info("The number of All Auth is {}", auths.size());
        return authMapper.authenticateDtoList(auths);
    }

    public void deleteAuth(Long id) {
        Auth auth = rechercheAuthById(id);
        authRepository.delete(auth);
        log.info("The deletion of the Authenticated username {} is successfully", auth.getUsername());
    }

    public AuthenticateDto updateAuth(Long id, AuthenticateDto authenticateDto) {
        Auth auth = authMapper.toEntity(authenticateDto);
        auth.setId(id);
        auth = authRepository.save(auth);
        log.info("The Auth with id {} has been successfully modified", auth.getId());
        return authMapper.toDto(auth);
    }
}
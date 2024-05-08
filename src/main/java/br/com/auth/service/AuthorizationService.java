package br.com.auth.service;

import br.com.auth.domain.service.IAuthorizationService;
import br.com.auth.domain.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements IAuthorizationService {

    private final IUserRepository userRepository;

    public AuthorizationService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }
}

package br.com.auth.service;

import br.com.auth.buildingblocks.dto.AuthenticationDto;
import br.com.auth.buildingblocks.dto.RegisterDto;
import br.com.auth.domain.service.ITokenService;
import br.com.auth.domain.service.IUserService;
import br.com.auth.domain.entity.user.User;
import br.com.auth.domain.repository.IUserRepository;
import br.com.auth.infra.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final AuthenticationManager authenticationManager;
    private final IUserRepository userRepository;
    private final ITokenService tokenService;

    public UserService(AuthenticationManager authenticationManager, UserRepository userRepository, ITokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @Override
    public String login(AuthenticationDto authDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authDto.email(), authDto.password());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);
        return tokenService.generateToken((User) auth.getPrincipal());
    }

    @Override
    public void register(RegisterDto registerDto) throws Exception {
        if (userRepository.findByEmail(registerDto.email()) != null) {
            throw new Exception("Fail to create user");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
        User user = new User(registerDto.name(), registerDto.email(), encryptedPassword, registerDto.role());
        userRepository.insert(user);
    }

    @Override
    public UserDetails getUserDetailsByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

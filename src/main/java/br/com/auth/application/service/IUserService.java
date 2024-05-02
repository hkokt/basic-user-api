package br.com.auth.application.service;

import br.com.auth.application.dto.authentication.AuthenticationDto;
import br.com.auth.application.dto.authentication.RegisterDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
    public String login(AuthenticationDto authenticationDto);

    public void register(RegisterDto registerDto) throws Exception;

    public UserDetails getUserDetailsByEmail(String email);
}
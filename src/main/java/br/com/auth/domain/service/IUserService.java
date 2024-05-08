package br.com.auth.domain.service;

import br.com.auth.buildingblocks.dto.AuthenticationDto;
import br.com.auth.buildingblocks.dto.RegisterDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
    String login(AuthenticationDto authenticationDto);

    void register(RegisterDto registerDto) throws Exception;

    UserDetails getUserDetailsByEmail(String email);
}
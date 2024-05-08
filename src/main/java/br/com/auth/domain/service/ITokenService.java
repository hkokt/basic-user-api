package br.com.auth.domain.service;

import br.com.auth.domain.entity.user.User;

public interface ITokenService {

    String generateToken(User user);
    String validateToken(String token);
}

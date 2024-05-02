package br.com.auth.application.service;

import br.com.auth.domain.model.user.User;

public interface ITokenService {

    public String generateToken(User user);
    public String validateToken(String token);
}

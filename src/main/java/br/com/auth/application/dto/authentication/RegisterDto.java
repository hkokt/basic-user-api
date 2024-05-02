package br.com.auth.application.dto.authentication;

import br.com.auth.domain.model.user.UserRole;

public record RegisterDto(
        String name,
        String email,
        String password,
        UserRole role) {
}

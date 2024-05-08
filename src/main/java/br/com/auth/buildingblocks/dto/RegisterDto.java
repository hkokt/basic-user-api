package br.com.auth.buildingblocks.dto;

import br.com.auth.domain.entity.user.UserRole;

public record RegisterDto(
        String name,
        String email,
        String password,
        UserRole role) {
}

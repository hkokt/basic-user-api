package br.com.auth.application.dto.authentication;

public record LoginResponseDto(
        String email,
        String token
) {
}

package br.com.auth.buildingblocks.dto;

public record LoginResponseDto(
        String email,
        String token
) {
}

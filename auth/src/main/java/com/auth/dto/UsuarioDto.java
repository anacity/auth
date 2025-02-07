package com.auth.dto;

import com.auth.enums.RoleEnum;

public record UsuarioDto(
	String nome,
	String login,
	String senha,
	RoleEnum role
) {
}

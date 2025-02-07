package com.auth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.dto.UsuarioDto;
import com.auth.models.Usuario;
import com.auth.repositories.UsuarioRepository;
import com.auth.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UsuarioDto salvar(UsuarioDto usuarioDto) {
		
		Usuario usuarioJaExiste = usuarioRepository.findByLogin(usuarioDto.login());
				
		if(usuarioJaExiste != null) {
			throw new RuntimeException("Usuário já existe!");
		}
		
		var passwordHash = passwordEncoder.encode(usuarioDto.senha());
		
		Usuario entity = new Usuario(usuarioDto.nome(), usuarioDto.login(), passwordHash, usuarioDto.role());
		
		Usuario novoUsuario = usuarioRepository.save(entity);
		
		return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getLogin(),novoUsuario.getSenha(), novoUsuario.getRole());
	}

}

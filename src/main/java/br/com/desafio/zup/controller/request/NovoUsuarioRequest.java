package br.com.desafio.zup.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.desafio.zup.model.UniqueValue;
import br.com.desafio.zup.model.Usuario;

public class NovoUsuarioRequest {
	
	@NotEmpty
	private String nome;

	@Email
	@NotEmpty
	@UniqueValue(domainClass = Usuario.class, fieldName = "email")
	private String email;

	@CPF
	@NotNull
	@UniqueValue(domainClass = Usuario.class, fieldName = "cpf")
	private String cpf;

	@NotNull
	private LocalDate dataNascimento;

	@Deprecated
	public NovoUsuarioRequest() {
	}

	public NovoUsuarioRequest(@NotEmpty String nome, @Email @NotEmpty String email, @CPF @NotNull String cpf,
			@NotNull LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Usuario fromDtoToDomain() {
		return new Usuario(nome, email, cpf, dataNascimento);
	}
}




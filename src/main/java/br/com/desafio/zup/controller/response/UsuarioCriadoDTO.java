package br.com.desafio.zup.controller.response;

import java.time.LocalDate;

import br.com.desafio.zup.model.Usuario;

public class UsuarioCriadoDTO {

	private Long id;
	private String nome;
	private String email;

	private String cpf;

	private LocalDate dataNascimento;

	public UsuarioCriadoDTO(Usuario usuarioExistente) {
		this.id = usuarioExistente.getId();
		this.nome = usuarioExistente.getNome();
		this.email = usuarioExistente.getEmail();
		this.cpf = usuarioExistente.getCpf();
		this.dataNascimento = usuarioExistente.getDataNascimento();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}

package br.com.desafio.zup.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Long id;

	@NotEmpty
	@Column(name = "NOME")
	private String nome;

	@Email
	@NotBlank
	@Column(name = "EMAIL", unique = true)
	private String email;

	@CPF
	@NotBlank
	@Column(name = "CPF", unique = true)
	private String cpf;

	// @NotNull
	@Column(name = "DATA_NASCIMENTO")
	private LocalDate dataNascimento;

	@OneToMany(targetEntity = Veiculo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
	private List<Veiculo> veiculos;

	public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	@Deprecated
	public Usuario() {
	}

	public Long getId() {
		return id;
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

	public void comNovoVeiculo(Veiculo novoVeiculoDoUsuario) {
		novoVeiculoDoUsuario.comDono(this);
		veiculos.add(novoVeiculoDoUsuario);

	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

}



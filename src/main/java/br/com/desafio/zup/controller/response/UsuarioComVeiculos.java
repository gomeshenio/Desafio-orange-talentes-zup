package br.com.desafio.zup.controller.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.desafio.zup.model.Usuario;

public class UsuarioComVeiculos {

	private Long id;
	private String nome;
	private String email;
	private List<VeiculoCriadoDTO> veiculos;

	public UsuarioComVeiculos(Usuario usuarioExistente) {
		this.id = usuarioExistente.getId();
		this.nome = usuarioExistente.getEmail();
		this.email = usuarioExistente.getCpf();
		this.veiculos = usuarioExistente.getVeiculos().stream().map(v -> new VeiculoCriadoDTO(v)).collect(Collectors.toList());

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

	public List<VeiculoCriadoDTO> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoCriadoDTO> veiculos) {
		this.veiculos = veiculos;
	}

}


package br.com.desafio.zup.controller.request;

import javax.validation.constraints.NotBlank;

import br.com.desafio.zup.model.Veiculo;

public class NovoVeiculoRequest {

	@NotBlank
	private String marca;
	@NotBlank
	private String modelo;

	@NotBlank
	private String ano;

	public NovoVeiculoRequest(@NotBlank String marca, @NotBlank String modelo, @NotBlank String ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	public Veiculo fromDtoToDomain() {
		return new Veiculo(marca, modelo, ano);
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAno() {
		return ano;
	}

}



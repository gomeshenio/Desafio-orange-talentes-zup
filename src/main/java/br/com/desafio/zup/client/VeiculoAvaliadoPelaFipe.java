package br.com.desafio.zup.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VeiculoAvaliadoPelaFipe {

	@JsonProperty("Valor")
	private String valor;

	@Deprecated
	public VeiculoAvaliadoPelaFipe() {
	}

	public VeiculoAvaliadoPelaFipe(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}


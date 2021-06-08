package br.com.desafio.zup.controller.response;

import br.com.desafio.zup.model.Veiculo;

public class VeiculoCriadoDTO {

	private Long id;
	private String marca;
	private String modelo;
	private String ano;
	private String valorEstimado;
	private boolean ediaDoRodizio;
	private String diaDoRodizio;

	public VeiculoCriadoDTO(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno();
		this.valorEstimado = veiculo.getValorEstimado();
		this.ediaDoRodizio = veiculo.isEdiaDoRodizio();
		this.diaDoRodizio = veiculo.getDiaDoRodizio();

	}

	public Long getId() {
		return id;
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

	public String getValorEstimado() {
		return valorEstimado;
	}

	public boolean isEdiaDoRodizio() {
		return ediaDoRodizio;
	}

	public String getDiaDoRodizio() {
		return diaDoRodizio;
	}

}

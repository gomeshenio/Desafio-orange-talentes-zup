package br.com.desafio.zup.client;

public class Modelo {
	
	private Long codigo;
	private String nome;

	@Deprecated
	public Modelo() {
	}

	public Modelo(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

}

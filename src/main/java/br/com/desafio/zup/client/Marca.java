package br.com.desafio.zup.client;

public class Marca {
	
	private Long codigo;
	private String nome;

	public Marca(Long codigo, String nome) {
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

package br.com.desafio.zup.client;

import java.util.List;

public class Modelos {
	
	private List<Modelo> modelos;

	@Deprecated
	public Modelos() {
	}

	public Modelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}


}

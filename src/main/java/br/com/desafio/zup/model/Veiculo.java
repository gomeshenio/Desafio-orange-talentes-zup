package br.com.desafio.zup.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Long id;

	@NotBlank
	@Column(name = "MARCA")
	private String marca;
	@NotBlank
	@Column(name = "MODELO")
	private String modelo;

	@NotBlank
	@Column(name = "ANO")
	private String ano;

	@ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY)
	private Usuario usuario;

	@Column(name = "VALOR_ESTIMADO")
	private String valorEstimado;

	@Transient
	private boolean ediaDoRodizio;

	@Column(name = "DIA_DO_RODIZIO")
	private String diaDoRodizio;

	@Deprecated
	public Veiculo() {
	}

	public Veiculo(@NotBlank String marca, @NotBlank String modelo, @NotBlank String ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		diaDaSemanaDoRodizio();
		descobrirDiaDoRodizio();
		
	}

	private void descobrirDiaDoRodizio() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int numeroDoDiaCorrent = c.get(Calendar.DAY_OF_WEEK);

		if (numeroDoDiaCorrent == 1 || numeroDoDiaCorrent == 7) {
			ediaDoRodizio = false;
		}
		if (numeroDoDiaCorrent == 2 && diaDoRodizio.equals("segunda-feira")) {
			ediaDoRodizio = true;
		}
		if (numeroDoDiaCorrent == 3 && diaDoRodizio.equals("terça-feira")) {
			ediaDoRodizio = true;
		}
		if (numeroDoDiaCorrent == 4 && diaDoRodizio.equals("quarta-feira")) {
			ediaDoRodizio = true;
		}
		if (numeroDoDiaCorrent == 5 && diaDoRodizio.equals("quinta-feira")) {
			ediaDoRodizio = true;
		}
		if (numeroDoDiaCorrent == 6 && diaDoRodizio.equals("sexta-feira")) {
			ediaDoRodizio = true;
		}
	}

	public boolean isEdiaDoRodizio() {
		return ediaDoRodizio;
	}

	public String getDiaDoRodizio() {
		return diaDoRodizio;
	}

	private String diaDaSemanaDoRodizio() {

		String anoDoVeiculo = ano.substring(0, 4);
		String ultimoDigitoDoAno = anoDoVeiculo.substring(3);
		if (ultimoDigitoDoAno.equals("0") || ultimoDigitoDoAno.equals("1")) {
			diaDoRodizio = "segunda-feira";
		}
		if (ultimoDigitoDoAno.equals("2") || ultimoDigitoDoAno.equals("3")) {
			diaDoRodizio = "terça-feira";
		}
		if (ultimoDigitoDoAno.equals("4") || ultimoDigitoDoAno.equals("5")) {
			diaDoRodizio = "quarta-feira";
		}
		if (ultimoDigitoDoAno.equals("6") || ultimoDigitoDoAno.equals("7")) {
			diaDoRodizio = "quinta-feira";
		}
		if (ultimoDigitoDoAno.equals("8") || ultimoDigitoDoAno.equals("9")) {
			diaDoRodizio = "sexta-feira";
		}
		return diaDoRodizio;

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

	public void comDono(Usuario dono) {
		this.usuario = dono;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void comValorEstimado(String valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	public String getValorEstimado() {
		return valorEstimado;
	}

}

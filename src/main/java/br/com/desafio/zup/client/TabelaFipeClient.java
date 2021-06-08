package br.com.desafio.zup.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "parallelum", url = "https://parallelum.com.br/fipe/api/v1")
public interface TabelaFipeClient {

	@GetMapping("/veiculos/marcas")
	public List<Marca> getMarcas();
	
	@GetMapping("/veiculos/marcas/{codigoMarca}/modelos")
	public Modelos modelosPorMarca(@PathVariable("codigoMarca") Long codigoMarca);
	
	@GetMapping("/veiculos/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{anoCarro}")
	public VeiculoAvaliadoPelaFipe getValorPeloModeloEMarcaEAno(@PathVariable("codigoMarca") Long codigoMarca,
			@PathVariable("codigoModelo") Long codigoModelo, @PathVariable("anoCarro") String anoCarro);



}
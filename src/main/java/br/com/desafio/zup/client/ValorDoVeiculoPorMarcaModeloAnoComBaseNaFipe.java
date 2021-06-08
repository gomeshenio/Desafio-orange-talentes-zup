package br.com.desafio.zup.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.zup.model.Veiculo;

@Service
public class ValorDoVeiculoPorMarcaModeloAnoComBaseNaFipe {

	@Autowired
	private TabelaFipeClient tabelaFipeClient;

	public ValorDoVeiculoPorMarcaModeloAnoComBaseNaFipe(TabelaFipeClient tabelaFipeClient) {
		this.tabelaFipeClient = tabelaFipeClient;
	}

	public VeiculoAvaliadoPelaFipe obter(Veiculo paraSerAvaliado) {

		List<Marca> marcasEncontradasNaFipe = tabelaFipeClient.getMarcas();

		Optional<Marca> possivelMarca = marcasEncontradasNaFipe.stream()
				.filter(p -> p.getNome().equals(paraSerAvaliado.getMarca())).findFirst();

		Marca marcaEncontrada = possivelMarca.get();

		Modelos modelos = tabelaFipeClient.modelosPorMarca(marcaEncontrada.getCodigo());

		Optional<Modelo> modeloEncontrado = modelos.getModelos().stream()
				.filter(modelo -> modelo.getNome().equals(paraSerAvaliado.getModelo())).findFirst();

		VeiculoAvaliadoPelaFipe possivelValorAvaliadoPelaFipe = tabelaFipeClient.getValorPeloModeloEMarcaEAno(
				marcaEncontrada.getCodigo(), modeloEncontrado.get().getCodigo(), paraSerAvaliado.getAno());
		
		return possivelValorAvaliadoPelaFipe;

	}
}


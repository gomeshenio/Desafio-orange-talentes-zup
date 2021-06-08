package br.com.desafio.zup.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.zup.client.ValorDoVeiculoPorMarcaModeloAnoComBaseNaFipe;
import br.com.desafio.zup.client.VeiculoAvaliadoPelaFipe;
import br.com.desafio.zup.controller.request.NovoUsuarioRequest;
import br.com.desafio.zup.controller.request.NovoVeiculoRequest;
import br.com.desafio.zup.controller.response.UsuarioComVeiculos;
import br.com.desafio.zup.controller.response.UsuarioCriadoDTO;
import br.com.desafio.zup.controller.response.VeiculoCriadoDTO;
import br.com.desafio.zup.model.Usuario;
import br.com.desafio.zup.model.Veiculo;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private EntityManager manager;
	
	@Autowired
	private ValorDoVeiculoPorMarcaModeloAnoComBaseNaFipe valorDoVeiculoDeAcordoComAMarcaModeloAnoComBaseNaFipe;
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioCriadoDTO> novoUsuario(@RequestBody @Valid NovoUsuarioRequest request,
			UriComponentsBuilder uriBuilder) {

		Usuario novoUsuario = request.fromDtoToDomain();

		manager.persist(novoUsuario);

		return ResponseEntity.created(uriBuilder.path("/usuarios/{id}").buildAndExpand(novoUsuario.getId()).toUri())
				.body(new UsuarioCriadoDTO(novoUsuario));
	}

	@PostMapping
	@RequestMapping("/{usuarioId}/veiculos")
	@Transactional
	public ResponseEntity<VeiculoCriadoDTO> novoVeiculo(@PathVariable Long usuarioId,
			@RequestBody @Valid NovoVeiculoRequest request) {

		Usuario usuarioEncontrado = manager.find(Usuario.class, usuarioId);

		Veiculo novoVeiculoDoUsuario = request.fromDtoToDomain();
		
		VeiculoAvaliadoPelaFipe veiculoAvaliado = valorDoVeiculoDeAcordoComAMarcaModeloAnoComBaseNaFipe
				.obter(novoVeiculoDoUsuario);
		
		novoVeiculoDoUsuario.comValorEstimado(veiculoAvaliado.getValor());
        
		usuarioEncontrado.comNovoVeiculo(novoVeiculoDoUsuario);

		manager.persist(usuarioEncontrado);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new VeiculoCriadoDTO(novoVeiculoDoUsuario));
		
	}

	@GetMapping("/{usuarioId}")
	public ResponseEntity<UsuarioComVeiculos> usuarioPorId(@PathVariable Long usuarioId) {
		return ResponseEntity.ok(new UsuarioComVeiculos(manager.find(Usuario.class, usuarioId)));
		
	}
}

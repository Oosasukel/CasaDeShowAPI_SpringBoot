package com.casashow.casa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.casashow.casa.models.Casa;
import com.casashow.casa.models.modelViews.CasaRequest;
import com.casashow.casa.models.modelViews.CasaResponse;
import com.casashow.casa.repositories.CasaRepository;

@RestController
@RequestMapping("/casas")
public class CasaController {
	@Autowired
	private CasaRepository _casaRepository;

	@GetMapping
	public ResponseEntity<List<CasaResponse>> GetCasas(UriComponentsBuilder uriBuilder) {
		List<Casa> casas = _casaRepository.findAll();
		List<CasaResponse> casasResponses = new ArrayList<CasaResponse>();
		for (Casa casa : casas) {
			casasResponses.add(new CasaResponse(casa));
		}
		
		return ResponseEntity.ok().body(casasResponses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CasaResponse> GetCasa(@PathVariable String id){
		Optional<Casa> casa = _casaRepository.findById(id);
		if(casa.isPresent()){
			return ResponseEntity.ok().body(new CasaResponse(casa.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CasaResponse> PutCasa(@PathVariable String id, @RequestBody CasaRequest casaUpdate){
		Optional<Casa> casa = _casaRepository.findById(id);
		
		if(casa.isPresent()) {
			Casa casaDb = casa.get();
			
			casaDb.setNome(casaUpdate.getNome());
			casaDb.setEndereco(casaUpdate.getEndereco());
			
			return ResponseEntity.ok().body(new CasaResponse(casaDb));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> DeleteCasa(@PathVariable String id){
		Optional<Casa> casa = _casaRepository.findById(id);
		
		if(casa.isPresent()) {
			Casa casaDb = casa.get();
			
			_casaRepository.deleteById(id);
			
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<CasaResponse> PostCasa(@RequestBody CasaRequest CasaRequest){
		Casa casa = CasaRequest.toCasa();
		casa.setId(UUID.randomUUID().toString());
		_casaRepository.save(casa);
		return ResponseEntity.ok().body(new CasaResponse(casa));
	}
}

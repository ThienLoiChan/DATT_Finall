package com.poly.controller.api;

import java.util.List;

import com.poly.service.QuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.repo.QuaRepo;
import com.poly.model.Qua;

@CrossOrigin("*")
@RestController
public class QuaController {
	@Autowired
	private QuaService QuaService;

	@GetMapping("/rest/Qua")
	public ResponseEntity<List<Qua>> getAll(Model model) {
		return ResponseEntity.ok(QuaService.findAll());
	}
	@GetMapping("/rest/searchQua/{name}")
	public ResponseEntity<List<Qua>> get(@PathVariable("name") String name) {
		return ResponseEntity.ok(QuaService.findByName(name));
	}

	@GetMapping("/rest/Qua/{id}")
	public ResponseEntity<Qua> getOne(@PathVariable("id") Integer id) {
		if (!QuaService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(QuaService.findById(id));
	}

	// Insert
	@PostMapping("/rest/Qua")
	public ResponseEntity<Qua> post(@RequestBody Qua Qua) {
		if (QuaService.existsById(Qua.getMaQua())) {
			return ResponseEntity.badRequest().build();
		}
		QuaService.save(Qua);
		return ResponseEntity.ok(Qua);
	}

	// Update
	@PutMapping("/rest/Qua/{id}")
	public ResponseEntity<Qua> put(@PathVariable("id") Integer id, @RequestBody Qua Qua) {
		if (!QuaService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		QuaService.save(Qua);
		return ResponseEntity.ok(Qua);
	}

	@DeleteMapping("/rest/Qua/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		if (!QuaService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		QuaService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
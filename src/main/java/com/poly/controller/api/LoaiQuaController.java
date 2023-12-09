package com.poly.controller.api;

import java.util.List;

import com.poly.model.Qua;
import com.poly.service.LoaiQuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.poly.model.LoaiQua;


@CrossOrigin("*")
@RestController
public class LoaiQuaController {
	@Autowired
	private LoaiQuaService loaQuaDAO;

	@GetMapping("/rest/loaiQua")
	public ResponseEntity<List<LoaiQua>> getAll(Model model) {
		return ResponseEntity.ok(loaQuaDAO.findAll());
	}

	@GetMapping("/rest/loaiQua/{id}")
	public ResponseEntity<LoaiQua> getOne(@PathVariable("id") Integer id) {
		if (!loaQuaDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(loaQuaDAO.findById(id));
	}
	// Insert
	@PostMapping("/rest/loaiQua")
	public ResponseEntity<LoaiQua> post(@RequestBody LoaiQua loaiQua) {
		if (loaQuaDAO.existsById(loaiQua.getMaLoaiQua())) {
			return ResponseEntity.badRequest().build();
		}
		loaQuaDAO.save(loaiQua);
		return ResponseEntity.ok(loaiQua);
	}

	// Update
	@PutMapping("/rest/loaiQua/{id}")
	public ResponseEntity<LoaiQua> put(@PathVariable("id") Integer id, @RequestBody LoaiQua loaiQua) {
		if (!loaQuaDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		loaQuaDAO.save(loaiQua);
		return ResponseEntity.ok(loaiQua);
	}

	@DeleteMapping("/rest/loaiQua/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		if (!loaQuaDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		loaQuaDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}

package com.poly.controller.api;

import java.util.List;

import com.poly.service.DanhGiaService;
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

import com.poly.repo.DanhGiaRepo;
import com.poly.model.DanhGia;

@CrossOrigin("*")
@RestController
public class DanhGiaController {
	@Autowired
	private DanhGiaService danhGiaService;

	@GetMapping("/rest/danhgia")
	public ResponseEntity<List<DanhGia>> getAll(Model model) {
		return ResponseEntity.ok(danhGiaService.findAll());
	}

	@GetMapping("/rest/danhgia/{id}")
	public ResponseEntity<List<DanhGia>> getOne(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(danhGiaService.findAllDanhGia(id));
	}

	// Insert
	@PostMapping("/rest/danhgia")
	public ResponseEntity<DanhGia> post(@RequestBody DanhGia danhGia) {
		if (danhGiaService.existsById(danhGia.getMaDanhGia())) {
			return ResponseEntity.badRequest().build();
		}
		danhGiaService.save(danhGia);
		return ResponseEntity.ok(danhGia);
	}

	// Update
	@PutMapping("/rest/danhgia/{id}")
	public ResponseEntity<DanhGia> put(@PathVariable("id") Integer id, @RequestBody DanhGia danhGia) {
		if (!danhGiaService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		danhGiaService.save(danhGia);
		return ResponseEntity.ok(danhGia);
	}

	@DeleteMapping("/rest/danhgia/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		danhGiaService.deleteByIdQua(id);
		return ResponseEntity.ok().build();
	}
}

package com.poly.controller.api;

import java.util.List;

import com.poly.service.HangQuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poly.model.HangQua;


@CrossOrigin("*")
@RestController
public class HangQuaController {
	@Autowired
	private HangQuaService hangQuaDAO;

	@GetMapping("/rest/hangQua")
	public ResponseEntity<List<HangQua>> getAll(Model model) {
		return ResponseEntity.ok(hangQuaDAO.findAll());
	}

	@GetMapping("/rest/hangQua/{id}")
	public ResponseEntity<HangQua> getOne(@PathVariable("id") Integer id) {
		if (!hangQuaDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(hangQuaDAO.findById(id));
	}
}

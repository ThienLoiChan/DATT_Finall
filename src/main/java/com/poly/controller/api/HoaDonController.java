package com.poly.controller.api;

import java.util.List;

import com.poly.service.OrderService;
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

import com.poly.repo.OrderRepo;
import com.poly.model.DonHang;

@CrossOrigin("*")
@RestController
public class HoaDonController {
	@Autowired
	private OrderService orderDAO;

	@GetMapping("/rest/hoadon")
	public ResponseEntity<List<DonHang>> getAll(Model model) {
		return ResponseEntity.ok(orderDAO.findAll());
	}

	@GetMapping("/rest/hoadon/{id}")
	public ResponseEntity<DonHang> getOne(@PathVariable("id") Integer id) {
		if (!orderDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(orderDAO.findById(id));
	}

	// Insert
	@PostMapping("/rest/hoadon")
	public ResponseEntity<DonHang> post(@RequestBody DonHang donHang) {
		if (orderDAO.existsById(donHang.getMaDonHang())) {
			return ResponseEntity.badRequest().build();
		}
		orderDAO.save(donHang);
		return ResponseEntity.ok(donHang);
	}

	// Update
	@PutMapping("/rest/hoadon/{id}")
	public ResponseEntity<DonHang> put(@PathVariable("id") Integer id, @RequestBody DonHang donHang) {
		if (!orderDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		orderDAO.save(donHang);
		return ResponseEntity.ok(donHang);
	}

	@DeleteMapping("/rest/hoadon/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		if (!orderDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		orderDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}

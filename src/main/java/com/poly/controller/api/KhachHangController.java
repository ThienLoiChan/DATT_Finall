package com.poly.controller.api;

import java.util.List;

import com.poly.model.Quyen;
import com.poly.repo.QuyenRepo;
import com.poly.service.AccountService;
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

import com.poly.repo.AccountRepo;
import com.poly.model.KhachHang;

@CrossOrigin("*")
@RestController
public class KhachHangController {
	@Autowired
	private AccountService accountRepo;

	@Autowired
	private QuyenRepo quyenRepo;

	@GetMapping("/rest/khachhang")
	public ResponseEntity<List<KhachHang>> getAll(Model model) {
		return ResponseEntity.ok(accountRepo.findAll());
	}

	@GetMapping("/rest/khachhang/{id}")
	public ResponseEntity<KhachHang> getOne(@PathVariable("id") String id) {
		if (!accountRepo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(accountRepo.findById(id));
	}

	// Insert
	@PostMapping("/rest/khachhang")
	public ResponseEntity<KhachHang> post(@RequestBody KhachHang khachHang) {
		if (accountRepo.existsById(khachHang.getTaiKhoan())) {
			return ResponseEntity.badRequest().build();
		}
		//Tạo tài khoản user
		Quyen quyen=quyenRepo.findById(1).get();
		khachHang.setQuyen(quyen);
		accountRepo.save(khachHang);
		return ResponseEntity.ok(khachHang);
	}

	@PostMapping("/rest/khachhang-admin")
	public ResponseEntity<KhachHang> postAdmin(@RequestBody KhachHang khachHang) {
		if (accountRepo.existsById(khachHang.getTaiKhoan())) {
			return ResponseEntity.badRequest().build();
		}
		//Tạo tài khoản admin
		Quyen quyen=quyenRepo.findById(3).get();
		khachHang.setQuyen(quyen);
		accountRepo.save(khachHang);
		return ResponseEntity.ok(khachHang);
	}

	// Update
	@PutMapping("/rest/khachhang/{id}")
	public ResponseEntity<KhachHang> put(@PathVariable("id") String id, @RequestBody KhachHang khachHang) {
		if (!accountRepo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		accountRepo.save(khachHang);
		return ResponseEntity.ok(khachHang);
	}

	@DeleteMapping("/rest/khachhang/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		if (!accountRepo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		accountRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}
}

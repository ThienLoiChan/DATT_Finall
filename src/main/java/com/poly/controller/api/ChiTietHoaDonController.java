package com.poly.controller.api;

import java.util.List;

import com.poly.service.OrderDetailService;
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

import com.poly.repo.OrderDetailRepo;
import com.poly.model.ChiTietDonHang;
import com.poly.model.ChiTietDonHangPK;

@CrossOrigin("*")
@RestController
public class ChiTietHoaDonController {
	@Autowired
	private OrderDetailService orderDetailDAO;

	@GetMapping("/rest/chitiethoadon")
	public ResponseEntity<List<ChiTietDonHang>> getAll(Model model) {
		return ResponseEntity.ok(orderDetailDAO.findAll());
	}
	@GetMapping("/rest/chitiethoadon/{idHoaDon}")
	public ResponseEntity<List<ChiTietDonHang>> getByIDHoaDon(@PathVariable("idHoaDon") Integer idHoaDon) {
		return ResponseEntity.ok(orderDetailDAO.findByIdDonHang(idHoaDon));
	}

	// Insert
	@PostMapping("/rest/chitiethoadon")
	public ResponseEntity<ChiTietDonHang> post(@RequestBody ChiTietDonHang chiTietDonHang) {
		if (orderDetailDAO.existsById(chiTietDonHang.getId())) {
			return ResponseEntity.badRequest().build();
		}
		orderDetailDAO.save(chiTietDonHang);
		return ResponseEntity.ok(chiTietDonHang);
	}

	// Update
	@PutMapping("/rest/chitiethoadon/{idDonHang}/{idQua}")
	public ResponseEntity<ChiTietDonHang> put(@PathVariable("idDonHang") Integer idDonHang,
			@PathVariable("idQua") Integer idQua, @RequestBody ChiTietDonHang chiTietDonHang) {
		ChiTietDonHangPK id=new ChiTietDonHangPK();
		id.setMaDonHang(idDonHang);
		id.setMaQua(idQua);
		if (!orderDetailDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		orderDetailDAO.save(chiTietDonHang);
		return ResponseEntity.ok(chiTietDonHang);
	}

	@DeleteMapping("/rest/chitiethoadon/{idDonHang}/{idQua}")
	public ResponseEntity<Void> delete(@PathVariable("idDonHang") Integer idDonHang,
			@PathVariable("idQua") Integer idQua) {
		ChiTietDonHangPK id=new ChiTietDonHangPK();
		id.setMaDonHang(idDonHang);
		id.setMaQua(idQua);
		if (!orderDetailDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		orderDetailDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}

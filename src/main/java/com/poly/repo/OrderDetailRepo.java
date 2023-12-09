package com.poly.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.model.ChiTietDonHang;
import com.poly.model.ChiTietDonHangPK;

public interface OrderDetailRepo extends JpaRepository<ChiTietDonHang, ChiTietDonHangPK> {
	@Query("SELECT d FROM ChiTietDonHang d WHERE d.id.maDonHang=?1")
    List<ChiTietDonHang> findByIdDonHang(Integer maDonHang);
}

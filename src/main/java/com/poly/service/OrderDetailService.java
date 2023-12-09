package com.poly.service;


import com.poly.model.ChiTietDonHang;
import com.poly.model.ChiTietDonHangPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderDetailService {
    List<ChiTietDonHang> findAll();
    Page<ChiTietDonHang> findAll(Pageable pageable);
    ChiTietDonHang findById(ChiTietDonHangPK id);
    boolean existsById(ChiTietDonHangPK id);
    ChiTietDonHang save(ChiTietDonHang chiTietDonHang);
    void deleteById(ChiTietDonHangPK id);
    List<ChiTietDonHang> findByIdDonHang(Integer maDonHang);
}

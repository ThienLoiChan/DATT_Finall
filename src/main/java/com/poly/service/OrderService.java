package com.poly.service;


import com.poly.model.ChiTietDonHang;
import com.poly.model.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    List<DonHang> findAll();
    Page<DonHang> findAll(Pageable pageable);
    DonHang findById(int id);
    boolean existsById(int id);
    DonHang save(DonHang donHang);
    void deleteById(int id);
}

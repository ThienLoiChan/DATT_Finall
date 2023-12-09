package com.poly.service;


import com.poly.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    List<KhachHang> findAll();
    Page<KhachHang> findAll(Pageable pageable);
    KhachHang findById(String id);
    boolean existsById(String id);
    KhachHang save(KhachHang khachHang);
    void deleteById(String id);
}

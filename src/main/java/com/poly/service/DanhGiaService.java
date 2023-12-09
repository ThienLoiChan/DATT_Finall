package com.poly.service;


import com.poly.model.DanhGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DanhGiaService {
    List<DanhGia> findAll();
    Page<DanhGia> findAll(Pageable pageable);
    DanhGia findById(int id);
    boolean existsById(int id);
    DanhGia save(DanhGia DanhGia);
    void deleteById(int id);
    List<DanhGia> findAllDanhGia(Integer maQua);
    void deleteByIdQua(Integer maQua);
}

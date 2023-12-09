package com.poly.service;


import com.poly.model.LoaiQua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoaiQuaService {
    List<LoaiQua> findAll();
    Page<LoaiQua> findAll(Pageable pageable);
    LoaiQua findById(int id);
    boolean existsById(int id);
    LoaiQua save(LoaiQua LoaiQua);
    void deleteById(int id);
}

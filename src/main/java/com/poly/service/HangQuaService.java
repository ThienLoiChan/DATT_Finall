package com.poly.service;


import com.poly.model.HangQua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HangQuaService {
    List<HangQua> findAll();
    Page<HangQua> findAll(Pageable pageable);
    HangQua findById(int id);
    boolean existsById(int id);
    HangQua save(HangQua HangQua);
    void deleteById(int id);
}

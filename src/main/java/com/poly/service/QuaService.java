package com.poly.service;


import com.poly.model.Qua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuaService {
    List<Qua> findAll();
    Page<Qua> findAll(Pageable pageable);
    Qua findById(int id);
    List<Qua> findByName(String name);
    boolean existsById(int id);
    Qua save(Qua Qua);
    void deleteById(int id);
}

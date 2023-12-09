package com.poly.service.impl;

import com.poly.model.DanhGia;
import com.poly.repo.DanhGiaRepo;
import com.poly.service.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhGiaServiceImpl implements DanhGiaService {
    @Autowired
    DanhGiaRepo DanhGiaRepo;

    @Override
    public List<DanhGia> findAll() {
        return DanhGiaRepo.findAll();
    }

    @Override
    public Page<DanhGia> findAll(Pageable pageable) {
        return DanhGiaRepo.findAll(pageable);
    }

    @Override
    public DanhGia findById(int id) {
        return DanhGiaRepo.findById(id).get();
    }

    @Override
    public boolean existsById(int id) {
        return DanhGiaRepo.existsById(id);
    }

    @Override
    public DanhGia save(DanhGia DanhGia) {
        return DanhGiaRepo.save(DanhGia);
    }

    @Override
    public void deleteById(int id) {
        DanhGiaRepo.deleteById(id);
    }

    @Override
    public List<DanhGia> findAllDanhGia(Integer maQua) {
        return DanhGiaRepo.findAllDanhGia(maQua);
    }

    @Override
    public void deleteByIdQua(Integer maQua) {
        DanhGiaRepo.deleteByIdQua(maQua);
    }
}

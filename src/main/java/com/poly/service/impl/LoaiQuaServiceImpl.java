package com.poly.service.impl;

import com.poly.model.LoaiQua;
import com.poly.repo.LoaiQuaRepo;
import com.poly.service.LoaiQuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiQuaServiceImpl implements LoaiQuaService {
    @Autowired
    LoaiQuaRepo LoaiQuaRepo;

    @Override
    public List<LoaiQua> findAll() {
        return LoaiQuaRepo.findAll();
    }

    @Override
    public Page<LoaiQua> findAll(Pageable pageable) {
        return LoaiQuaRepo.findAll(pageable);
    }

    @Override
    public LoaiQua findById(int id) {
        return LoaiQuaRepo.findById(id).get();
    }

    @Override
    public boolean existsById(int id) {
        return LoaiQuaRepo.existsById(id);
    }

    @Override
    public LoaiQua save(LoaiQua LoaiQua) {
        return LoaiQuaRepo.save(LoaiQua);
    }

    @Override
    public void deleteById(int id) {
        LoaiQuaRepo.deleteById(id);
    }
}

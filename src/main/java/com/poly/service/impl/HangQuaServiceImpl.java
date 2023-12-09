package com.poly.service.impl;

import com.poly.model.HangQua;
import com.poly.repo.HangQuaRepo;
import com.poly.service.HangQuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangQuaServiceImpl implements HangQuaService {
    @Autowired
    HangQuaRepo HangQuaRepo;

    @Override
    public List<HangQua> findAll() {
        return HangQuaRepo.findAll();
    }

    @Override
    public Page<HangQua> findAll(Pageable pageable) {
        return HangQuaRepo.findAll(pageable);
    }

    @Override
    public HangQua findById(int id) {
        return HangQuaRepo.findById(id).get();
    }

    @Override
    public boolean existsById(int id) {
        return HangQuaRepo.existsById(id);
    }

    @Override
    public HangQua save(HangQua HangQua) {
        return HangQuaRepo.save(HangQua);
    }

    @Override
    public void deleteById(int id) {
        HangQuaRepo.deleteById(id);
    }
}

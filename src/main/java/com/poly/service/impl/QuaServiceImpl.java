package com.poly.service.impl;

import com.poly.repo.QuaRepo;
import com.poly.model.Qua;
import com.poly.service.QuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuaServiceImpl implements QuaService {
    @Autowired
    QuaRepo QuaRepo;

    @Override
    public List<Qua> findAll() {
        return QuaRepo.findAll();
    }

    @Override
    public Page<Qua> findAll(Pageable pageable) {
        return QuaRepo.findAll(pageable);
    }

    @Override
    public Qua findById(int id) {
        return QuaRepo.findById(id).get();
    }

    @Override
    public List<Qua> findByName(String name) {
        return QuaRepo.findByName(name);
    }
    @Override
    public boolean existsById(int id) {
        return QuaRepo.existsById(id);
    }

    @Override
    public Qua save(Qua Qua) {
        return QuaRepo.save(Qua);
    }

    @Override
    public void deleteById(int id) {
        QuaRepo.deleteById(id);
    }
}

package com.poly.service.impl;

import com.poly.model.KhachHang;
import com.poly.repo.AccountRepo;
import com.poly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepo accountRepo;

    @Override
    public List<KhachHang> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return accountRepo.findAll(pageable);
    }

    @Override
    public KhachHang findById(String id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public boolean existsById(String id) {
        return accountRepo.existsById(id);
    }

    @Override
    public KhachHang save(KhachHang KhachHang) {
        return accountRepo.save(KhachHang);
    }

    @Override
    public void deleteById(String id) {
        accountRepo.deleteById(id);
    }
}

package com.poly.service.impl;

import com.poly.model.ChiTietDonHang;
import com.poly.model.ChiTietDonHangPK;
import com.poly.repo.OrderDetailRepo;
import com.poly.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Override
    public List<ChiTietDonHang> findAll() {
        return orderDetailRepo.findAll();
    }

    @Override
    public Page<ChiTietDonHang> findAll(Pageable pageable) {
        return orderDetailRepo.findAll(pageable);
    }

    @Override
    public ChiTietDonHang findById(ChiTietDonHangPK id) {
        return orderDetailRepo.findById(id).get();
    }

    @Override
    public boolean existsById(ChiTietDonHangPK id) {
        return orderDetailRepo.existsById(id);
    }

    @Override
    public ChiTietDonHang save(ChiTietDonHang chiTietDonHang) {
        return orderDetailRepo.save(chiTietDonHang);
    }

    @Override
    public void deleteById(ChiTietDonHangPK id) {
        orderDetailRepo.deleteById(id);
    }

    @Override
    public List<ChiTietDonHang> findByIdDonHang(Integer maDonHang) {
        return orderDetailRepo.findByIdDonHang(maDonHang);
    }
}

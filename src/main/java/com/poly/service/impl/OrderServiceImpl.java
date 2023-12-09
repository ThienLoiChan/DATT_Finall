package com.poly.service.impl;

import com.poly.model.ChiTietDonHang;
import com.poly.model.DonHang;
import com.poly.repo.OrderRepo;
import com.poly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Override
    public List<DonHang> findAll() {
        return orderRepo.findOrderDESC();
    }

    @Override
    public Page<DonHang> findAll(Pageable pageable) {
        return orderRepo.findOrderDESC(pageable);
    }

    @Override
    public DonHang findById(int id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public boolean existsById(int id) {
        return orderRepo.existsById(id);
    }

    @Override
    public DonHang save(DonHang DonHang) {
        return orderRepo.save(DonHang);
    }

    @Override
    public void deleteById(int id) {
        orderRepo.deleteById(id);
    }
}

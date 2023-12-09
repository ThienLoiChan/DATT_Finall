package com.poly.service.impl;

import com.poly.model.Report;
import com.poly.repo.ReportRepo;
import com.poly.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepo reportRepo;

    @Override
    public Report getReport(int year) {
        return reportRepo.getReport(year);
    }
}

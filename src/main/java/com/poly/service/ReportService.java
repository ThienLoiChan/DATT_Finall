package com.poly.service;


import com.poly.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportService {
    Report getReport(int year);
}

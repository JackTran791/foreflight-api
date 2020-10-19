package com.foreflight.controller;

import com.foreflight.dto.main.Report;
import com.foreflight.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/report")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/{faaCode}")
    public Report generateReport(@PathVariable(value = "faaCode") String faaCode) {
        return reportService.generateReport(faaCode);
    }
}

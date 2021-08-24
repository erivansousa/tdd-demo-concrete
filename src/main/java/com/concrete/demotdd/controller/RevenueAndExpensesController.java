package com.concrete.demotdd.controller;

import com.concrete.demotdd.model.RevenueRequest;
import com.concrete.demotdd.service.RevenueAndExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RevenueAndExpensesController {

    @Autowired
    RevenueAndExpensesService revenueAndExpensesService;

    @PostMapping("/revenue")
    public ResponseEntity<String> cadastraNovaReceita(@RequestBody RevenueRequest revenue) {
        try {
            revenueAndExpensesService.includeRevenue(revenue);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(400).body("");
        }

        return ResponseEntity.ok("");
    }
}

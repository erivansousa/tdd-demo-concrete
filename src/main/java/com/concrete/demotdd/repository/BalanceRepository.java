package com.concrete.demotdd.repository;

import com.concrete.demotdd.model.RevenueRequest;
import com.concrete.demotdd.model.interfaces.BalanceChanger;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BalanceRepository {

    private double balance = 0.0;
    private List<BalanceChanger> history = new ArrayList();

    public void saveNewRevenue(RevenueRequest revenue) {
        history.add(revenue);
        balance += revenue.getValue();
    }

    public List<BalanceChanger> getHistory() {
        return history;
    }

    public double getBalance() {
        return balance;
    }
}

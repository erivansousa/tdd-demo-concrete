package com.concrete.demotdd.service;

import com.concrete.demotdd.exception.BlankDescriptionException;
import com.concrete.demotdd.exception.InvalidValueException;
import com.concrete.demotdd.exception.NullDescriptionException;
import com.concrete.demotdd.model.RevenueRequest;
import com.concrete.demotdd.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevenueAndExpensesService {

    @Autowired
    BalanceRepository balanceRepository;

    public void includeRevenue(RevenueRequest revenue) {
        verifyDescription(revenue.getDescription());
        verifyValue(revenue.getValue());

        balanceRepository.saveNewRevenue(revenue);
    }

    private void verifyValue(double value) {
        if (value <= 0){
            throw new InvalidValueException();
        }
    }

    private void verifyDescription(String description){
        if (description == null) {
            throw new NullDescriptionException();
        } else if (description.isBlank()) {
            throw new BlankDescriptionException();
        }
    }
}

package com.concrete.demotdd.service;

import com.concrete.demotdd.exception.BlankDescriptionException;
import com.concrete.demotdd.exception.InvalidValueException;
import com.concrete.demotdd.exception.NullDescriptionException;
import com.concrete.demotdd.model.RevenueRequest;
import org.springframework.stereotype.Service;

@Service
public class RevenueAndExpensesService {

    public void includeRevenue(RevenueRequest receita) {
        verifyDescription(receita.getDescricao());
        verifyValue(receita.getValor());
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

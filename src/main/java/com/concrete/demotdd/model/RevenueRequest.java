package com.concrete.demotdd.model;

import com.concrete.demotdd.model.interfaces.BalanceChanger;

public class RevenueRequest implements BalanceChanger {
    private String description;
    private double value;

    public RevenueRequest(String description, double value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

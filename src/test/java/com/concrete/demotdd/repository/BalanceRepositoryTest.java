package com.concrete.demotdd.repository;

import com.concrete.demotdd.model.RevenueRequest;
import com.concrete.demotdd.model.interfaces.BalanceChanger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BalanceRepositoryTest {

    BalanceRepository balanceRepository;

    @BeforeEach
    void init() {
        balanceRepository = new BalanceRepository();
    }

    @Test
    void quandoIncluirUmaNovaReceitaDeveSalvarNoHistorico() {

        RevenueRequest revenue = new RevenueRequest("salario", 200.0);

        balanceRepository.saveNewRevenue(revenue);

        List<BalanceChanger> history = balanceRepository.getHistory();

        Assertions.assertEquals(1, history.size());
    }

    @Test
    void quandoIncluirUmaNOvaReceitaDeveIncrementarSeuValorNoSaldoFinal() {

        RevenueRequest revenue = new RevenueRequest("salario", 200.0);

        balanceRepository.saveNewRevenue(revenue);

        double balance = balanceRepository.getBalance();

        Assertions.assertEquals(200, balance);
    }
}
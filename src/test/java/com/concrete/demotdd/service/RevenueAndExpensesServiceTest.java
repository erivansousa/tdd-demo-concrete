package com.concrete.demotdd.service;

import com.concrete.demotdd.exception.BlankDescriptionException;
import com.concrete.demotdd.exception.InvalidValueException;
import com.concrete.demotdd.exception.NullDescriptionException;
import com.concrete.demotdd.model.RevenueRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevenueAndExpensesServiceTest {

    RevenueAndExpensesService revenueAndExpensesService;

    @BeforeEach
    void init() {
        revenueAndExpensesService = new RevenueAndExpensesService();
    }

    @Test
    void dadaUmaSolicitacaoComDescricaoNulaDeveLancarUmaNullDescriptionException() {
        RevenueRequest revenue = new RevenueRequest(null, 10.0);

        Assertions.assertThrows(
                NullDescriptionException.class,
                () -> revenueAndExpensesService.includeRevenue(revenue)
        );
    }

    @Test
    void dadaUmaSolicitacaoComDescricaoVaziaDeveLancarUmaBlankDescriptionException() {
        RevenueRequest revenue = new RevenueRequest("", 10.0);

        Assertions.assertThrows(
                BlankDescriptionException.class,
                () -> revenueAndExpensesService.includeRevenue(revenue)
        );
    }

    @Test
    void dadaUmaSolicitacaoComValorNegativoDeveLancarUmInvalidValueException() {

        RevenueRequest revenue = new RevenueRequest("descricao", -10.0);

        Assertions.assertThrows(
                InvalidValueException.class,
                () -> revenueAndExpensesService.includeRevenue(revenue)
        );
    }

    @Test
    void dadaUmaSolicitacaoComValorZeradoDeveLancarUmInvalidValueException() {

        RevenueRequest revenue = new RevenueRequest("descricao", 0.0);

        Assertions.assertThrows(
                InvalidValueException.class,
                () -> revenueAndExpensesService.includeRevenue(revenue)
        );
    }
}

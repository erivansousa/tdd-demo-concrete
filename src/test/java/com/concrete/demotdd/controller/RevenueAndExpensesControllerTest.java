package com.concrete.demotdd.controller;

import com.concrete.demotdd.model.RevenueRequest;
import com.concrete.demotdd.service.RevenueAndExpensesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class RevenueAndExpensesControllerTest {

    @Mock
    RevenueAndExpensesService revenueAndExpensesService;

    @InjectMocks
    RevenueAndExpensesController revenueAndExpensesController;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void dadaUmaInclusaoNovaReceitaDeveChamarOServiceResponsavelPeloProcessamento() {

        RevenueRequest receita = new RevenueRequest("descricao", 10.0);

        revenueAndExpensesController.cadastraNovaReceita(receita);

        Mockito.verify(revenueAndExpensesService).includeRevenue(receita);
    }

    @Test
    void quandoOServiceLancarAlgumaExcessaooControlerDeveDevolverUmCodigo400() {

        RevenueRequest receita = new RevenueRequest("descricao", 10.0);

        Mockito.doThrow(RuntimeException.class).when(revenueAndExpensesService).includeRevenue(receita);

        ResponseEntity<String> response = revenueAndExpensesController.cadastraNovaReceita(receita);

        Assertions.assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    void quandoOServiceExecutarSemProblemasOControlerDeveDevolverUmCodigo200() {

        RevenueRequest receita = new RevenueRequest("descricao", 10.0);

        Mockito.doNothing().when(revenueAndExpensesService).includeRevenue(receita);

        ResponseEntity<String> response = revenueAndExpensesController.cadastraNovaReceita(receita);

        Assertions.assertEquals(200, response.getStatusCodeValue());
    }
}

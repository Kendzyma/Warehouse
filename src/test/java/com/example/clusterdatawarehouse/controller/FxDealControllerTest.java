package com.example.clusterdatawarehouse.controller;

import com.example.clusterdatawarehouse.dto.request.FxDealRequest;
import com.example.clusterdatawarehouse.dto.response.ApiResponse;
import com.example.clusterdatawarehouse.dto.response.FxDealResponse;
import com.example.clusterdatawarehouse.exception.BadRequestException;
import com.example.clusterdatawarehouse.service.FxDealService;
import com.example.clusterdatawarehouse.service.impl.FxDealServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FxDealControllerTest {
    @MockBean
    private FxDealServiceImpl fxDealService;
    @InjectMocks
    private FxDealController fxDealController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private FxDealRequest fxDealRequest;
    private FxDealResponse fxDealResponse;
    @BeforeEach
    public void setup() {
        fxDealRequest = new FxDealRequest();
        fxDealRequest.setDealAmount(BigDecimal.valueOf(50));
        fxDealRequest.setDealUniqueId("FXDEAL123");
        fxDealRequest.setFromCurrencyISOCode("EUR");
        fxDealRequest.setToCurrencyISOCode("USD");

        fxDealResponse = new FxDealResponse();
        fxDealRequest.setDealAmount(BigDecimal.valueOf(50));
        fxDealRequest.setDealUniqueId("FXDEAL123");
        fxDealRequest.setFromCurrencyISOCode("EUR");
        fxDealRequest.setToCurrencyISOCode("USD");
    }

    @Test
    public void createFxDeal_ValidRequest_ReturnsOkResponse() throws Exception {

        // Set values for fxDealResponse
        Mockito.when(fxDealService.createFxDeal(fxDealRequest)).thenReturn(fxDealResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fxDeal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(fxDealRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
              //  .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(fxDealRequest)));fxDealRequest
    }

    @Test
    public void createFxDeal_InvalidRequest_ReturnsBadRequest() throws Exception {
        // Arrange
        fxDealRequest.setDealUniqueId(null);

        Mockito.when(fxDealService.createFxDeal(fxDealRequest)).thenThrow(new BadRequestException("invalid"));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fxDeal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(fxDealRequest)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
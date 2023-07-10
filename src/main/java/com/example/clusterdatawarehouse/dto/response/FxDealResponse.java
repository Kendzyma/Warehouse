package com.example.clusterdatawarehouse.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class FxDealResponse {
    private String dealUniqueId;
    private String fromCurrencyISOCode;
    private String toCurrencyISOCode;
    private BigDecimal dealAmount;
}

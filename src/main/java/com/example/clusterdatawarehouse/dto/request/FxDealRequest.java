package com.example.clusterdatawarehouse.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FxDealRequest {

    private String dealUniqueId;
    private String fromCurrencyISOCode;
    private String toCurrencyISOCode;
    private BigDecimal dealAmount;
}

package com.example.clusterdatawarehouse.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "FxDeal")
@Getter
@Setter
public class FxDeal extends DbEntity{
    private String dealUniqueId;
    private String fromCurrencyISOCode;
    private String toCurrencyISOCode;
    private BigDecimal dealAmount;

    private FxDeal(String generatedId){
        super.setId(generatedId);
    }

    public FxDeal() {
    }
}

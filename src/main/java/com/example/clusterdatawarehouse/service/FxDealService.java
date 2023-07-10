package com.example.clusterdatawarehouse.service;

import com.example.clusterdatawarehouse.dto.request.FxDealRequest;
import com.example.clusterdatawarehouse.dto.response.ApiResponse;
import com.example.clusterdatawarehouse.dto.response.FxDealResponse;

public interface FxDealService {
    FxDealResponse createFxDeal(FxDealRequest fxDealRequest);
}

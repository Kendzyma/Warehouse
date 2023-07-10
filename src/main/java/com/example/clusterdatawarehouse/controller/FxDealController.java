package com.example.clusterdatawarehouse.controller;

import com.example.clusterdatawarehouse.constants.CommonConstants;
import com.example.clusterdatawarehouse.dto.request.FxDealRequest;
import com.example.clusterdatawarehouse.dto.response.ApiResponse;
import com.example.clusterdatawarehouse.dto.response.FxDealResponse;
import com.example.clusterdatawarehouse.service.impl.FxDealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/fxDeal")
public class FxDealController {

    @Autowired
    private FxDealServiceImpl fxDealService;

    /**
     * Creates fx deals
     * @param fxDealRequest
     * @return FxDealResponse
     */
    @PostMapping()
    public ApiResponse<FxDealResponse> createFxDeal(@RequestBody FxDealRequest fxDealRequest){
       return new ApiResponse<>(CommonConstants.SUCCESS_MESSAGE,CommonConstants.TRUE,fxDealService.createFxDeal(fxDealRequest), HttpStatus.OK);
    }
}

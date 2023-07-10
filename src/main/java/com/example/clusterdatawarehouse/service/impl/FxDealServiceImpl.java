package com.example.clusterdatawarehouse.service.impl;

import com.example.clusterdatawarehouse.constants.CommonConstants;
import com.example.clusterdatawarehouse.dto.request.FxDealRequest;
import com.example.clusterdatawarehouse.dto.response.ApiResponse;
import com.example.clusterdatawarehouse.dto.response.FxDealResponse;
import com.example.clusterdatawarehouse.exception.BadRequestException;
import com.example.clusterdatawarehouse.exception.DuplicateEntityException;
import com.example.clusterdatawarehouse.model.FxDeal;
import com.example.clusterdatawarehouse.service.FxDealService;
import com.example.clusterdatawarehouse.utils.IDGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FxDealServiceImpl implements FxDealService {
    private static final String UNIQUE_ID_CRITERIA = "dealUniqueId";
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IDGenerator idGenerator;
    @Override
    public FxDealResponse createFxDeal(FxDealRequest fxDealRequest) {
        validateFields(fxDealRequest);
        Query query = new Query(Criteria.where(UNIQUE_ID_CRITERIA).is(fxDealRequest.getDealUniqueId()));
        if(mongoTemplate.exists(query, FxDeal.class)){
            throw new DuplicateEntityException(CommonConstants.DUPLICATE_UNIQUE_ID_MESSAGE);
        }
        try {
            FxDeal response = mongoTemplate.save(FxDealMapper(fxDealRequest), CommonConstants.FXDEAL_COLLECTION_NAME);
            return FxDealResponseMapper(response);
        }
        catch (Exception e){
            //todo:change this exception
            throw new DuplicateEntityException(e.getMessage());
        }
    }

    private void validateFields(FxDealRequest request) {
        if(Objects.isNull(request.getDealUniqueId()) || request.getDealUniqueId().isEmpty()){
            throw new BadRequestException("Deal Unique Id " + CommonConstants.NULL_EMPTY_MESSAGE);
        }
        if(Objects.isNull(request.getFromCurrencyISOCode()) || request.getFromCurrencyISOCode().isEmpty()){
            throw new BadRequestException("From Currency Iso Code " + CommonConstants.NULL_EMPTY_MESSAGE);
        }
        if(Objects.isNull(request.getToCurrencyISOCode()) || request.getToCurrencyISOCode().isEmpty()){
            throw new BadRequestException("To Currency Iso Code " + CommonConstants.NULL_EMPTY_MESSAGE);
        }
        if(Objects.isNull(request.getDealAmount())){
            throw new BadRequestException("Deal Amount "+ CommonConstants.NULL_EMPTY_MESSAGE);
        }
    }

    private FxDeal FxDealMapper(FxDealRequest request){
        FxDeal fxDeal = modelMapper.map(request,FxDeal.class);
        fxDeal.setId(idGenerator.generateUniqueId(FxDeal.class));
        return fxDeal;
    }
    private FxDealResponse FxDealResponseMapper(FxDeal response){
        return modelMapper.map(response,FxDealResponse.class);
    }
}

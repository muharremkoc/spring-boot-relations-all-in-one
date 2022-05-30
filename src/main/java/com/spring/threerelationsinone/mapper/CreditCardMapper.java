package com.spring.threerelationsinone.mapper;

import com.spring.threerelationsinone.domain.CreditCard;
import com.spring.threerelationsinone.dtos.request.CreditCardRequestDto;
import com.spring.threerelationsinone.dtos.response.CreditCardResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface CreditCardMapper {

    @Mappings({
            @Mapping(target = "bankName",source = "bankName")
    })
    CreditCard creditCardToCreditCardRequestDto(CreditCardRequestDto creditCardRequestDto);

    @Mappings({
            @Mapping(target = "creditID",source = "creditID"),
            @Mapping(target = "bankName",source = "bankName")
    })
    CreditCardResponseDto creditCardResponseDtoToCreditCard(CreditCard creditCard);

    List<CreditCard> creditCardsToCreditCardRequestDtoList(List<CreditCardRequestDto> creditCardRequestDtos);
}

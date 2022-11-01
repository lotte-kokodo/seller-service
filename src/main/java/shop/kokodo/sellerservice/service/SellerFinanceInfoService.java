package shop.kokodo.sellerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.dto.FinanceInfoDto;
import shop.kokodo.sellerservice.entity.SellerFinanceInfo;
import shop.kokodo.sellerservice.exception.UniqueSellerFinanceException;
import shop.kokodo.sellerservice.repository.SellerFinanceInfoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerFinanceInfoService {

    private final SellerFinanceInfoRepository sellerFinanceInfoRepository;

    public FinanceInfoDto getUniqueSellerFinanceById(Long sellerId) {
        List<SellerFinanceInfo> uniqueSellerFinance = sellerFinanceInfoRepository.findUniqueSellerFinanceById(sellerId);

        if(uniqueSellerFinance.size() > 1 || uniqueSellerFinance.isEmpty()){
            throw new UniqueSellerFinanceException("SellerService - 판매자의 금융 대표 정보가 없거나 2개 이상입니다.");
        }
        return FinanceInfoDto.toDto(uniqueSellerFinance.get(0));
    }

}

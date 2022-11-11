package shop.kokodo.sellerservice.service;

import java.util.List;
import java.util.Map;
import shop.kokodo.sellerservice.entity.Seller;

import java.util.Optional;
import shop.kokodo.sellerservice.dto.SignupRequest;

public interface SellerService {

    Optional<Seller> findBySellerId(Long sellerId);

    Seller createSeller(SignupRequest req);

    String getSellerName(Long sellerId);

    Map<Long, String> getSellerNames(List<Long> sellerIds);
}

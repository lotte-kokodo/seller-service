package shop.kokodo.sellerservice.service;

import java.util.List;
import java.util.Map;
import shop.kokodo.sellerservice.entity.Seller;

import java.util.Optional;

public interface SellerService {

    public Optional<Seller> findBySellerId(Long sellerId);

    public Map<Long, String> getSellerNames(List<Long> sellerIds);
}

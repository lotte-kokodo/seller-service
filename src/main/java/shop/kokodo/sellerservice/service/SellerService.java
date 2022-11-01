package shop.kokodo.sellerservice.service;

import shop.kokodo.sellerservice.entity.Seller;

import java.util.Optional;

public interface SellerService {

    public Optional<Seller> findBySellerId(Long sellerId);
}

package shop.kokodo.sellerservice.service;

import java.util.Optional;
import shop.kokodo.sellerservice.dto.SignupRequest;
import shop.kokodo.sellerservice.entity.Seller;

public interface SellerService {

    Optional<Seller> findBySellerId(Long sellerId);

    Seller createSeller(SignupRequest req);
}

package shop.kokodo.sellerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.entity.Seller;
import shop.kokodo.sellerservice.repository.SellerRepository;

import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService{

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Optional<Seller> findBySellerId(Long sellerId) {
        return sellerRepository.findById(sellerId);
    }
}

package shop.kokodo.sellerservice.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.entity.Seller;
import shop.kokodo.sellerservice.repository.SellerRepository;
import shop.kokodo.sellerservice.repository.interfaces.SellerName;

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

    @Override
    public Map<Long, String> getSellerNames(List<Long> sellerIds) {
        List<SellerName> sellerNames = sellerRepository.findByIdIn(sellerIds, SellerName.class);
        return sellerNames.stream().collect(Collectors.toMap(SellerName::getId, SellerName::getName));
    }
}

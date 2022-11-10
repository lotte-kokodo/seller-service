package shop.kokodo.sellerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.dto.SignupRequest;
import shop.kokodo.sellerservice.entity.Seller;
import shop.kokodo.sellerservice.repository.SellerRepository;

import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService{

    private final SellerRepository sellerRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository,
        BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.sellerRepository = sellerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<Seller> findBySellerId(Long sellerId) {
        return sellerRepository.findById(sellerId);
    }

    @Override
    public Seller createSeller(SignupRequest req) {
        // 이미 등록된 로그인 아이디인 경우
        Optional<Seller> seller = sellerRepository.findByUserLoginId(req.getUserLoginId());
        if (seller.isPresent()) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        String encryptedPassword = bCryptPasswordEncoder.encode(req.getUserPassWord());
        Seller newSeller = new Seller(req, encryptedPassword);
        sellerRepository.save(newSeller);
        return newSeller;
    }

    @Override
    public String getSellerName(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 판매자입니다."));
        return seller.getName();
    }
}

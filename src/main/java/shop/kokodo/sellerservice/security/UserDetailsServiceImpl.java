package shop.kokodo.sellerservice.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.entity.Seller;
import shop.kokodo.sellerservice.repository.SellerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SellerRepository sellerRepository;

    public UserDetailsServiceImpl(
        SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Seller seller = sellerRepository.findByUserLoginId(loginId)
            .orElseThrow(() ->  new IllegalArgumentException("등록되지 않은 사용자입니다."));

        return new UserDetailsImpl(seller);
    }

}

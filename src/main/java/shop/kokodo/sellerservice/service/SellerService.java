package shop.kokodo.sellerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.repository.SellerRepository;

/**
 * packageName    : shop.kokodo.sellerservice.controller
 * fileName       : SellerService
 * author         : namhyeop
 * date           : 2022/11/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/01        namhyeop       최초 생성
 */
@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;
}

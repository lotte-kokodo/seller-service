package shop.kokodo.sellerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.kokodo.sellerservice.entity.Seller;

/**
 * packageName    : shop.kokodo.sellerservice.repository
 * fileName       : SellerRepository
 * author         : namhyeop
 * date           : 2022/10/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/17        namhyeop       최초 생성
 */
public interface SellerRepository extends JpaRepository<Seller, Long> {


}

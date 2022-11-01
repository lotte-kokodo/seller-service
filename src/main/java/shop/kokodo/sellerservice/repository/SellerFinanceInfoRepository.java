package shop.kokodo.sellerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.kokodo.sellerservice.entity.SellerFinanceInfo;

import java.util.List;

public interface SellerFinanceInfoRepository extends JpaRepository<SellerFinanceInfo,Long> {

    @Query("select f from SellerFinanceInfo f where f.id = :sellerId and f.delegateAccount = true")
    List<SellerFinanceInfo> findUniqueSellerFinanceById(Long sellerId);
}

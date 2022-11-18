package shop.kokodo.sellerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.kokodo.sellerservice.dto.CommissionPolicyDto;
import shop.kokodo.sellerservice.entity.CommissionPolicy;

import java.util.List;

/**
 * packageName    : shop.kokodo.sellerservice.repository
 * fileName       : CommissionRepository
 * author         : namhyeop
 * date           : 2022/10/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/17        namhyeop       최초 생성
 */
public interface CommissionPolicyRepository extends JpaRepository<CommissionPolicy, Long> {

    @Query("select c " +
            "from CommissionPolicy c join c.seller " +
            "where c.id in :sellerId")
    List<CommissionPolicyDto> findCommissionPolicyBySellerId(List<Long> sellerId);
}

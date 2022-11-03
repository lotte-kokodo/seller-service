package shop.kokodo.sellerservice.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SellerFinanceInfo extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_finance_info_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private String bankName;
    private String accountNumber;
    private String accountHolder;
    private Boolean delegateAccount;

    public SellerFinanceInfo(String bankName, String accountNumber, String accountHolder, Boolean delegateAccount) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.delegateAccount = delegateAccount;
    }
}

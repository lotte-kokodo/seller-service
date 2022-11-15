package shop.kokodo.sellerservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import shop.kokodo.sellerservice.dto.SignupRequest;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Seller extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;

//    @OneToOne(mappedBy = ""fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "commission_policy")
//    private CommissionPolicy commissionPolicy;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<SellerFinanceInfo> sellerFinanceInfo;
    private String userLoginId;

    private String userPassWord;

    private String phone;

    private String email;

    private Boolean phoneAgree;

    private Boolean emailAgree;

    private String birthday;

    private String name;

    private Long balance;

    private String rePos;

    private String releasePos;

    private String reCourier;

    private String retailCourier;

    private Boolean returnAgree;

    private Boolean retailAgree;

    private String grade;

    public Seller(List<SellerFinanceInfo> sellerFinanceInfo, String userLongId, String userPassWord, String phone, String email, Boolean phoneAgree, Boolean emailAgree, String birthday, String name, Long balance, String rePos, String releasePos, String reCourier, String retailCourier, Boolean returnAgree, Boolean retailAgree, String grade) {
        this.sellerFinanceInfo = sellerFinanceInfo;
        this.userLoginId = userLongId;
        this.userPassWord = userPassWord;
        this.phone = phone;
        this.email = email;
        this.phoneAgree = phoneAgree;
        this.emailAgree = emailAgree;
        this.birthday = birthday;
        this.name = name;
        this.balance = balance;
        this.rePos = rePos;
        this.releasePos = releasePos;
        this.reCourier = reCourier;
        this.retailCourier = retailCourier;
        this.returnAgree = returnAgree;
        this.retailAgree = retailAgree;
        this.grade = grade;
    }

    public Seller (SignupRequest dto, String encryptedPassword) {
        this.userLoginId = dto.getUserLoginId();
        this.userPassWord = encryptedPassword;
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.phoneAgree = dto.getPhoneAgree();
        this.emailAgree = dto.getEmailAgree();
        this.birthday = dto.getBirthday();
        this.name = dto.getName();
        this.balance = dto.getBalance();
        this.rePos = dto.getRePos();
        this.releasePos = dto.getReleasePos();
        this.reCourier = dto.getReCourier();
        this.retailCourier = dto.getRetailCourier();
        this.returnAgree = dto.getReturnAgree();
        this.retailAgree = dto.getRetailAgree();
        this.grade = dto.getGrade();
    }
}

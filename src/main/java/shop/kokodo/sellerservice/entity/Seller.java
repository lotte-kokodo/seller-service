package shop.kokodo.sellerservice.entity;

import lombok.*;

import javax.persistence.*;

/**
 * packageName    : shop.kokodo.sellerservice.entity
 * fileName       : seller
 * author         : namhyeop
 * date           : 2022/10/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/17        namhyeop       최초 생성
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class Seller extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;

//    @OneToOne(mappedBy = ""fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "commission_policy")
//    private CommissionPolicy commissionPolicy;

    private String userLongId;

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


}

package shop.kokodo.sellerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

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

}

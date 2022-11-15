package shop.kokodo.sellerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Long sellerId;
    private String accessToken;
    private String refreshToken;
}

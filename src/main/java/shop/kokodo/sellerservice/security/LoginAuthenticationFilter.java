package shop.kokodo.sellerservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import shop.kokodo.sellerservice.dto.LoginRequest;
import shop.kokodo.sellerservice.dto.LoginResponse;

@Component
@Slf4j
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final JwtTokenCreator jwtTokenCreator;

    private final ObjectMapper objectMapper;


    public LoginAuthenticationFilter(AuthenticationManager authenticationManager,
        JwtTokenCreator jwtTokenCreator,
        ObjectMapper objectMapper) {
        super.setAuthenticationManager(authenticationManager);
        this.objectMapper = objectMapper;
        this.jwtTokenCreator = jwtTokenCreator;
    }

    //인증수행 로직
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try{
            LoginRequest creds = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getLoginId(),
                            creds.getPassword()
                    )
            );
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    //인증 성공 로직
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {

        UserDetailsImpl userDetails = ( ((UserDetailsImpl) authResult.getPrincipal()));
        Long sellerId = userDetails.getId();

        //JWT Token 생성
        String accessToken = jwtTokenCreator.generateAccessToken(sellerId);
        String refreshToken = jwtTokenCreator.generateRefreshToken(sellerId);

        // 바디에 토큰 및 회원 ID 저장.
        LoginResponse respLogin = new LoginResponse(sellerId, accessToken, refreshToken);
        response.getWriter().write(objectMapper.writeValueAsString(respLogin));
    }
}

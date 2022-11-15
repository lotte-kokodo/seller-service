package shop.kokodo.sellerservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * packageName : shop.kokodo.sellerservice.security
 * fileName : WebConfig
 * author : BTC-N24
 * date : 2022-11-15
 * description :
 * ======================================================
 * DATE                AUTHOR                NOTE
 * ======================================================
 * 2022-11-15           BTC-N24              최초 생성
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // TODO: 테스트용 CORS 설정, 배포시 변경 필요
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
//                .allowCredentials(true);
    }
}

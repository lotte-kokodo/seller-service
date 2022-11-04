package shop.kokodo.sellerservice.service;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import shop.kokodo.sellerservice.dto.TemplateArticle;
import shop.kokodo.sellerservice.dto.product.request.RequestProduct;

import java.util.List;

public interface ProductService {

    public void saveProductAndProductDetail(List<MultipartFile> photo,
                                            MultipartFile thumbnail,
                                            RequestProduct requestProduct);

    public void saveProductAndProductTemplate(List<MultipartFile> photo,
                                              TemplateArticle templateArticle,
                                              RequestProduct requestProduct, MultipartFile thumbnail);
}

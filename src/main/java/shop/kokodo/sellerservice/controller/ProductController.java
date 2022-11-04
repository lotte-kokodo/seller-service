package shop.kokodo.sellerservice.controller;


import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import shop.kokodo.sellerservice.client.SellerServiceClient;
import shop.kokodo.sellerservice.dto.KafkaProduct;
import shop.kokodo.sellerservice.dto.TemplateArticle;
import shop.kokodo.sellerservice.dto.product.request.RequestProduct;
import shop.kokodo.sellerservice.dto.product.response.ResponseProduct;
import shop.kokodo.sellerservice.dto.response.Response;
import shop.kokodo.sellerservice.messagequeue.ProductSaveProducer;
import shop.kokodo.sellerservice.s3.AwsS3Service;
import shop.kokodo.sellerservice.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final SellerServiceClient sellerServiceClient;
    private final ProductService productService;

    @Autowired
    public ProductController(SellerServiceClient sellerServiceClient, ProductService productService) {
        this.sellerServiceClient = sellerServiceClient;
        this.productService = productService;
    }

    @PostMapping
    public Response saveProduct(@RequestPart(value = "files") List<MultipartFile> photo,
                                @RequestPart(value = "thumbnail") MultipartFile thumbnail,
                                @RequestPart(value = "data") RequestProduct requestProduct) {

        productService.saveProductAndProductDetail(photo,thumbnail,requestProduct);

        return Response.success();
    }

    @PostMapping("/template")
    public Response saveProductTemplate(@RequestPart(value = "files") List<MultipartFile> photo,
                                        @RequestPart(value = "thumbnail") MultipartFile thumbnail,
                                @RequestPart(value = "templateArticle") TemplateArticle templateArticle,
                                @RequestPart(value = "data") RequestProduct requestProduct) {

        productService.saveProductAndProductTemplate(photo,templateArticle,requestProduct,thumbnail);
        return Response.success();
    }

    @GetMapping
    public ResponseEntity findByProductNameAndStatusAndDate(@Param String productName, @Param Integer status
            , @Param String startDate, @Param String endDate, @Param Long sellerId) {
        Map<String, Object> params = new HashMap<>();
        params.put("productName",productName);
        params.put("status",status);
        params.put("startDate",startDate);
        params.put("endDate",endDate);
        params.put("sellerId",sellerId);

        List<ResponseProduct> list = sellerServiceClient.findByProductNameAndStatusAndDate(params);

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}

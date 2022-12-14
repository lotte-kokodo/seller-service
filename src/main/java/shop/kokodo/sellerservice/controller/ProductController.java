package shop.kokodo.sellerservice.controller;


import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import shop.kokodo.sellerservice.client.SellerServiceClient;
import shop.kokodo.sellerservice.dto.CategoryDto;
import shop.kokodo.sellerservice.dto.KafkaProduct;
import shop.kokodo.sellerservice.dto.PagingProductDto;
import shop.kokodo.sellerservice.dto.TemplateArticle;
import shop.kokodo.sellerservice.dto.product.request.RequestProduct;
import shop.kokodo.sellerservice.dto.product.request.RequestReview;
import shop.kokodo.sellerservice.dto.product.response.ResponseProduct;
import shop.kokodo.sellerservice.dto.response.Response;
import shop.kokodo.sellerservice.messagequeue.ProductSaveProducer;
import shop.kokodo.sellerservice.s3.AwsS3Service;
import shop.kokodo.sellerservice.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final SellerServiceClient sellerServiceClient;
    private final ProductService productService;
    private final CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    public ProductController(SellerServiceClient sellerServiceClient, ProductService productService, CircuitBreakerFactory circuitBreakerFactory) {
        this.sellerServiceClient = sellerServiceClient;
        this.productService = productService;
        this.circuitBreakerFactory = circuitBreakerFactory;
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

    @PostMapping("/stock")
    public Response updateStock(@RequestBody RequestReview requestReview){
        productService.updateStock(requestReview);
        return Response.success();
    }
    @GetMapping
    public ResponseEntity findByProductNameAndStatusAndDate(@Param String productName, @Param Integer status
            , @Param String startDate, @Param String endDate, @Param Long sellerId, @Param Integer page) {
        Map<String, Object> params = new HashMap<>();
        params.put("productName",productName);
        params.put("status",status);
        params.put("startDate",startDate);
        params.put("endDate",endDate);
        params.put("sellerId",sellerId);
        params.put("page",page);

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("sellerCircuit");
        PagingProductDto pagingProductDto = circuitBreaker.run(() -> sellerServiceClient.findByProductNameAndStatusAndDate(params),
                throwable -> new PagingProductDto(new ArrayList<>(),0));
        return ResponseEntity.status(HttpStatus.OK).body(pagingProductDto);
    }

    @GetMapping("/stock/{sellerId}/{page}")
    public ResponseEntity findByProductStockLack(@PathVariable long sellerId, @PathVariable int page) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("sellerProductStcok");
        PagingProductDto pagingProductDto = circuitBreaker.run(() -> sellerServiceClient.findByProductStockLack(sellerId,page),
                throwable -> new PagingProductDto(new ArrayList<>(),0));
        return ResponseEntity.status(HttpStatus.OK).body(pagingProductDto);
    }

    @GetMapping("/category/all")
    public Response categoryAll() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("categoryAll");
        List<CategoryDto> categoryList = circuitBreaker.run(() -> sellerServiceClient.categoryAll(),
                throwable -> new ArrayList<>());
        return Response.success(categoryList);
    }

    @GetMapping("/count/{sellerId}")
    public Response sellerProductCount(@PathVariable long sellerId) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("sellerProductCount");
        long count = circuitBreaker.run(() -> sellerServiceClient.sellerProductCount(sellerId), throwable -> 0L);

        return Response.success(count);
    }
}

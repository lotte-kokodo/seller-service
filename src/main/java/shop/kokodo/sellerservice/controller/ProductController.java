package shop.kokodo.sellerservice.controller;

import com.netflix.discovery.converters.Auto;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.kokodo.sellerservice.client.SellerServiceClient;
import shop.kokodo.sellerservice.controller.response.RestResponse;
import shop.kokodo.sellerservice.dto.product.request.RequestProduct;
import shop.kokodo.sellerservice.dto.product.response.ResponseProduct;
import shop.kokodo.sellerservice.dto.response.Response;
import shop.kokodo.sellerservice.messagequeue.ProductSaveProducer;
import shop.kokodo.sellerservice.s3.AwsS3Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    private SellerServiceClient sellerServiceClient;
    private ProductSaveProducer productSaveProducer;
    private final AwsS3Service awsS3Service;

    @Autowired
    public ProductController(SellerServiceClient sellerServiceClient, ProductSaveProducer productSaveProducer, AwsS3Service awsS3Service) {
        this.sellerServiceClient = sellerServiceClient;
        this.productSaveProducer = productSaveProducer;
        this.awsS3Service = awsS3Service;
    }

    @PostMapping
    public Response saveProduct(@RequestPart(value = "data") RequestProduct requestProduct,
                                @RequestPart(value = "file") MultipartFile multipartFile){
        System.out.println(requestProduct.toString());
        if(multipartFile != null) {
            /* s3 */
            requestProduct.setThumbnail(uploadFile(requestProduct.getName(), multipartFile));
        }

        /* kafka save product*/
        RequestProduct requestProduct1 = productSaveProducer.send("product-save",requestProduct);
        if(requestProduct1 == null) {
            return Response.failure(-1000,"상품 등록에 실패했습니다.");
        }

        return Response.success();
    }

    @GetMapping
    public ResponseEntity findByProductNameAndStatusAndDate(@Param String productName, @Param Integer status
            , @Param String startDate, @Param String endDate, @Param Long sellerId){
        Map<String, Object> params = new HashMap<>();
        params.put("productName",productName);
        params.put("status",status);
        params.put("startDate",startDate);
        params.put("endDate",endDate);
        params.put("sellerId",sellerId);

        List<ResponseProduct> list = sellerServiceClient.findByProductNameAndStatusAndDate(params);

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    public String uploadFile(String productName, MultipartFile multipartFile) {
        return awsS3Service.uploadFileV1(productName, multipartFile);
    }
}

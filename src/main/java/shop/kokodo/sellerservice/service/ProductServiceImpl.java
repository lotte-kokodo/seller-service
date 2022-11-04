package shop.kokodo.sellerservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import shop.kokodo.sellerservice.client.SellerServiceClient;
import shop.kokodo.sellerservice.dto.KafkaProduct;
import shop.kokodo.sellerservice.dto.KafkaProductTemplate;
import shop.kokodo.sellerservice.dto.TemplateArticle;
import shop.kokodo.sellerservice.dto.TemplateDto;
import shop.kokodo.sellerservice.dto.product.request.RequestProduct;
import shop.kokodo.sellerservice.messagequeue.ProductSaveProducer;
import shop.kokodo.sellerservice.s3.AwsS3Service;

import java.util.ArrayList;
import java.util.List;

import static shop.kokodo.sellerservice.dto.TemplateDto.createTemplateDto;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private final SellerServiceClient sellerServiceClient;
    private final ProductSaveProducer productSaveProducer;
    private final AwsS3Service awsS3Service;

    public ProductServiceImpl(SellerServiceClient sellerServiceClient, ProductSaveProducer productSaveProducer, AwsS3Service awsS3Service) {
        this.sellerServiceClient = sellerServiceClient;
        this.productSaveProducer = productSaveProducer;
        this.awsS3Service = awsS3Service;
    }

    @Override
    public void saveProductAndProductDetail(List<MultipartFile> photo, MultipartFile thumbnail, RequestProduct requestProduct) {

        List<String> detailUploadList = uploadList(photo);
        String thumbnailStr = uploadFile(thumbnail);

        KafkaProduct kafkaProduct = KafkaProduct.createKafkaProduct(requestProduct,detailUploadList,thumbnailStr);

        /* kafka save product*/
        productSaveProducer.send("product-save",kafkaProduct);

    }

    @Override
    public void saveProductAndProductTemplate(List<MultipartFile> photo, TemplateArticle templateArticle,
                                              RequestProduct requestProduct, MultipartFile thumbnail) {
        List<String> detailTemplateList = uploadList(photo);
        String thumbnailStr = uploadFile(thumbnail);

        TemplateDto templateDto = createTemplateDto(detailTemplateList, templateArticle);

        KafkaProductTemplate kafkaProductTemplate = KafkaProductTemplate.createKafkaProductTemplate(requestProduct,templateDto,thumbnailStr);

        /* kafka save template product*/
        productSaveProducer.send("product-save-template",kafkaProductTemplate);
    }

    private List<String> uploadList(List<MultipartFile> photo){
        List<String> list = new ArrayList<>();
        for (MultipartFile multipartFile : photo) {
            list.add(uploadFile(multipartFile));
        }

        return list;
    }


    public String uploadFile(MultipartFile multipartFile) {
        return awsS3Service.uploadFileV1(multipartFile).replace("%2F%2F","/");
    }
}

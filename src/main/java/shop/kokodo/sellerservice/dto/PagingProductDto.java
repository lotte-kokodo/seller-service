package shop.kokodo.sellerservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.kokodo.sellerservice.dto.product.response.ResponseProduct;

import java.util.List;

@Data
@NoArgsConstructor
public class PagingProductDto {
    List<ResponseProduct> productDtoList;
    long totalCount;

    @Builder
    public PagingProductDto(List<ResponseProduct> productDtoList, long totalCount) {
        this.productDtoList = productDtoList;
        this.totalCount = totalCount;
    }
}


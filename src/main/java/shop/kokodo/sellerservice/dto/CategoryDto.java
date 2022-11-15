package shop.kokodo.sellerservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CategoryDto implements Serializable {

    long id;
    String name;

    @Builder
    public CategoryDto(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

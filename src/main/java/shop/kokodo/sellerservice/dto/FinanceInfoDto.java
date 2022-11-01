package shop.kokodo.sellerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.kokodo.sellerservice.entity.SellerFinanceInfo;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FinanceInfoDto {

    private String bankName;
    private String accountNumber;
    private String accountHolder;

    public static FinanceInfoDto toDto(SellerFinanceInfo uniqueSellerFinance) {
        return new FinanceInfoDto(
                uniqueSellerFinance.getBankName(),
                uniqueSellerFinance.getAccountNumber(),
                uniqueSellerFinance.getAccountHolder()
        );
    }
}
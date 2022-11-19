package shop.kokodo.sellerservice.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DashboardOrderCountDto {

    private Integer todayOrderCount;
    private Boolean upDownFlag;
    private Integer changeNumberInfo;
    private String changeNumberPercent;

    private static String upMsg = " 건 증가";
    private static String downMsg = " 건 감소";

    public DashboardOrderCountDto(Integer todayOrderCount, Integer yesterdayOrderCount) {
        int changeNumber = todayOrderCount - yesterdayOrderCount;
        this.todayOrderCount = todayOrderCount;
        this.upDownFlag = changeNumber >= 0;
        this.changeNumberInfo = Math.abs(changeNumber);
        this.changeNumberPercent = upDownFlag ? upMsg : downMsg;
    }

}

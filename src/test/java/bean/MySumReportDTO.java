package bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MySumReportDTO {
    @JcBigDecConvert(name = UnitConvertType.B)
    private BigDecimal payTotalAmount;

    //jc金额百分比
    @JcBigDecConvert(name = UnitConvertType.PERCENTAGE)
    private BigDecimal jcAmountPercentage;

    //jc计数千分比
    @JcBigDecConvert(name = UnitConvertType.PERMIL)
    private BigDecimal jcCountPermillage;

    //保留2位
    @JcBigDecConvert(name = UnitConvertType.R)
    private BigDecimal length;

    //保留2位
    @JcBigDecConvert(name = UnitConvertType.R)
    private BigDecimal width;
}

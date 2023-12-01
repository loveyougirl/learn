package bean;

import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

@Log4j
public class UnitConvertUtil {

    private static Logger logger = LoggerFactory.getLogger(UnitConvertUtil.class);

    public static <T> void unitMapConvert(List<T> list, Map<String, UnitConvertType> propertyMap) {//propertyMap是需要处理的
        for (T t : list) {//遍历list集合
            Field[] declaredFields = t.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (propertyMap.keySet().stream().anyMatch(x -> x.equals(declaredField.getName()))) {
                    try {
                        declaredField.setAccessible(true);
                        Object o = declaredField.get(t);
                        UnitConvertType unitConvertType = propertyMap.get(declaredField.getName());
                        if (o != null) {
                            if (unitConvertType.equals(UnitConvertType.PERCENTAGE)) {
                                BigDecimal bigDecimal = ((BigDecimal) o).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                declaredField.set(t, bigDecimal);
                            }
                            if (unitConvertType.equals(UnitConvertType.PERMIL)) {
                                BigDecimal bigDecimal = ((BigDecimal) o).multiply(new BigDecimal(1000)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                declaredField.set(t, bigDecimal);
                            }
                            if (unitConvertType.equals(UnitConvertType.B)) {
                                BigDecimal bigDecimal = ((BigDecimal) o).divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                declaredField.set(t, bigDecimal);
                            }
                            if (unitConvertType.equals(UnitConvertType.R)) {
                                BigDecimal bigDecimal = ((BigDecimal) o).setScale(2, BigDecimal.ROUND_HALF_UP);
                                declaredField.set(t, bigDecimal);
                            }
                        }
                    } catch (Exception ex) {
                        log.error(ex.getMessage());
                    }
                }
            }
        }
    }

    public static <T> void unitAnnotateConvert(List<T> list) {
        for (T t : list) {
            Field[] declaredFields = t.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                try {
                    if (declaredField.getName().equals("serialVersionUID")) {
                        continue;
                    }
                    JcBigDecConvert myFieldAnn = declaredField.getAnnotation(JcBigDecConvert.class);
                    if (Objects.isNull(myFieldAnn)) {
                        continue;
                    }
                    UnitConvertType unitConvertType = myFieldAnn.name();
                    declaredField.setAccessible(true);
                    Object o = declaredField.get(t);
                    if (Objects.nonNull(o)) {
                        if (unitConvertType.equals(UnitConvertType.PERCENTAGE)) {
                            BigDecimal bigDecimal = ((BigDecimal) o).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                            declaredField.set(t, bigDecimal);
                        }
                        if (unitConvertType.equals(UnitConvertType.PERMIL)) {
                            BigDecimal bigDecimal = ((BigDecimal) o).multiply(new BigDecimal(1000)).setScale(2, BigDecimal.ROUND_HALF_UP);
                            declaredField.set(t, bigDecimal);
                        }
                        if (unitConvertType.equals(UnitConvertType.B)) {
                            BigDecimal bigDecimal = ((BigDecimal) o).divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);
                            declaredField.set(t, bigDecimal);
                        }
                        if (unitConvertType.equals(UnitConvertType.R)) {
                            BigDecimal bigDecimal = ((BigDecimal) o).setScale(2, BigDecimal.ROUND_HALF_UP);
                            declaredField.set(t, bigDecimal);
                        }
                    }
                } catch (Exception ex) {
                    log.error("处理失败");
                }
            }
        }
    }

    public static void main(String[] args) {
        //获取模拟数据
        List<MySumReportDTO> list = getMySumReportList();

        //标记字段需要进行的操作
        Map<String, UnitConvertType> map = new HashMap<>();
        map.put("payTotalAmount", UnitConvertType.B);
        map.put("jcAmountPercentage", UnitConvertType.PERCENTAGE);
        map.put("jcCountPermillage", UnitConvertType.PERMIL);
        map.put("length", UnitConvertType.R);
        map.put("width", UnitConvertType.R);

        unitMapConvert(list, map);
        System.out.println("convert result --> " + list);

    }

    private static List<MyYearSumReportDTO> getMyYearSumReportList() {
        MyYearSumReportDTO mySumReportDTO = new MyYearSumReportDTO();
        mySumReportDTO.setPayTotalAmount(new BigDecimal(1100000));
        mySumReportDTO.setJcAmountPercentage(BigDecimal.valueOf(0.695));
        mySumReportDTO.setJcCountPermillage(BigDecimal.valueOf(0.7894));
        mySumReportDTO.setLength(BigDecimal.valueOf(1300.65112));
        mySumReportDTO.setWidth(BigDecimal.valueOf(6522.12344));
        MyYearSumReportDTO mySumReportDTO1 = new MyYearSumReportDTO();
        mySumReportDTO1.setPayTotalAmount(new BigDecimal(2390000));
        mySumReportDTO1.setJcAmountPercentage(BigDecimal.valueOf(0.885));
        mySumReportDTO1.setJcCountPermillage(BigDecimal.valueOf(0.2394));
        mySumReportDTO1.setLength(BigDecimal.valueOf(1700.64003));
        mySumReportDTO1.setWidth(BigDecimal.valueOf(7522.12344));

        List<MyYearSumReportDTO> list = new ArrayList<>();
        list.add(mySumReportDTO);
        list.add(mySumReportDTO1);
        return list;
    }

    private static List<MySumReportDTO> getMySumReportList() {
        MySumReportDTO mySumReportDTO = new MySumReportDTO();
        mySumReportDTO.setPayTotalAmount(new BigDecimal(1100000));
        mySumReportDTO.setJcAmountPercentage(BigDecimal.valueOf(0.695));
        mySumReportDTO.setJcCountPermillage(BigDecimal.valueOf(0.7894));
        mySumReportDTO.setLength(BigDecimal.valueOf(1300.65112));
        mySumReportDTO.setWidth(BigDecimal.valueOf(6522.12344));

        MySumReportDTO mySumReportDTO1 = new MySumReportDTO();
        mySumReportDTO1.setPayTotalAmount(new BigDecimal(2390000));
        mySumReportDTO1.setJcAmountPercentage(BigDecimal.valueOf(0.885));
        mySumReportDTO1.setJcCountPermillage(BigDecimal.valueOf(0.2394));
        mySumReportDTO1.setLength(BigDecimal.valueOf(1700.64003));
        mySumReportDTO1.setWidth(BigDecimal.valueOf(7522.12344));

        List<MySumReportDTO> list = new ArrayList<>();

        list.add(mySumReportDTO);
        list.add(mySumReportDTO1);
        return list;
    }
}
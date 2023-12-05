package logic;

import java.util.HashMap;
import java.util.Map;

public class DistinctDemo {
    public static void main(String[] args) {
        System.out.println(compareString("1234", "123"));
        System.out.println(arraySearch(new int[]{1, 2, 1, 10}, 10));
    }

    /**
     * 比较两个字符串大小
     *
     * @param first
     * @param second
     * @return
     */
    public static int compareString(String first, String second) {
        int result = 0;

        try {
            //null转空
            first = first == null ? "" : first;
            second = second == null ? "" : second;

            //预先记录字符串长度，避免反复读取
            int firstLength = first.length();
            int secondLength = second.length();

            //处理含有空串的特殊情况
            if ("".equals(first) || "".equals(second)) {
                //谁长谁小
                result = secondLength - firstLength;
            } else {
                //临时空间，用来存放ascii码总和
                int firstCount = 0;
                int secondCount = 0;
                //用纯运算得出两个数中较小的数，实在是bt
                int minLength = (secondLength * (firstLength / secondLength) + firstLength * (secondLength / firstLength)) / (firstLength / secondLength + secondLength / firstLength);
                //按两个字符串中较短的位数去逐位截取,防止越界
                for (int i = 0; i < minLength; i++) {
                    //求ascii码和
                    firstCount += first.substring(i, i + 1).getBytes()[0];
                    secondCount += second.substring(i, i + 1).getBytes()[0];
                    //和不相等，说明已经比较出了大小
                    if (firstCount != secondCount) {
                        break;
                    }
                }

                if (firstCount == secondCount) {
                    //长度长的大
                    result = firstLength - secondLength;
                } else {
                    //总和大的大
                    result = firstCount - secondCount;
                }
            }
        } catch (Exception e) {
        }

        return result;
    }

    /**
     * 求数组中元素重复次数最多的数和重复次数
     *
     * @param array 目标数组
     * @param max   数组中数据的最大值，这里填写必需要大于等于上边array中最大的int值
     * @return
     */
    public static Map<String, Integer> arraySearch(int[] array, int max) {
        //结果集合
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        //重复的次数
        int maxCount = 0;
        //重复次数对多的数
        int value = 0;

        try {
            //初始化数据数组,用来存放每个元素出现的次数
            int[] dataArray = new int[max + 1];

            //遍历要查找的数组，以每个元素为下标，直接定位数据数组，进行+1操作，表示出现了一次
            for (int i : array) {
                dataArray[i]++;
            }

            //找到数据数组中最大值
            for (int i = 0; i < dataArray.length; i++) {
                if (dataArray[i] > maxCount) {
                    maxCount = dataArray[i];
                    value = i;
                }
            }
        } catch (Exception e) {
        }
        resultMap.put("maxCount", maxCount);
        resultMap.put("value", value);
        return resultMap;
    }
}

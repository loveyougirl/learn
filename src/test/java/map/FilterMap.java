package map;

import java.util.Map;
import java.util.stream.Collectors;

public class FilterMap {
    public static Map<String, Object> parseMapForFilter(Map<String, Object> map) {
        if (map == null) {
            return null;
        } else {
            map = map.entrySet().stream()
                    .filter((e) -> checkValue(e.getValue()))
                    .collect(Collectors.toMap(
                            (e) -> (String) e.getKey(),
                            (e) -> e.getValue()
                    ));
        }
        return map;
    }

    private static boolean checkValue(Object object) {
        if (object instanceof String && "".equals(object)) {
            return false;
        }
        if (null == object) {
            return false;
        }
        return true;
    }

}

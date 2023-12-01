package map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapInit {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "外包");
        map.put("key2", "真的");
        map.put("keyN", "没法");
    }

    @Test
    public void mapInit() {
        Map<String, String> map = new HashMap<String, String>() {{
            put("key1", "外包");
            put("key2", "真的");
            put("keyN", "没法");
        }};

    }
}

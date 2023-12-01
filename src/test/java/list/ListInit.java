package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListInit {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("外包");
        list.add("真的");
        list.add("没法");
    }

    @Test
    public void listInit() {
        List<String> list = new ArrayList<String>() {{
            add("外包");
            add("真的");
            add("没法");
        }};
    }

    @Test
    public void arraysToList(){
        ArrayList<String> list = new ArrayList(Arrays.asList("外包", "真的", "没法"));
    }
}

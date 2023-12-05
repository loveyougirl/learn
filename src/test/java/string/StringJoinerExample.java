package string;

import org.junit.Test;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter

        joinNames.add("外包");
        joinNames.add("真的");
        joinNames.add("有点");
        joinNames.add("坑");

        System.out.println(joinNames);
    }
    @Test
    public void stringJoiner(){
        StringJoiner joinNames = new StringJoiner(",","{","}"); // passing comma(,) as delimiter

        joinNames.add("waibao");
        joinNames.add("true");

        System.out.println(joinNames);//{waibao,true}
    }
}

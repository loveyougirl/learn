package reflect.field;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldTest {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("reflect.field.Boy");
        Field[] fields = clazz.getFields();//共有字段
        Arrays.asList(fields).forEach(field -> System.out.println(field));
        Field[] declaredFields = clazz.getDeclaredFields();//获取所有的
        Arrays.asList(declaredFields).forEach(field -> System.out.println(field));

        Field name = clazz.getField("name");
        System.out.println(name);
        //产生一个Boy对象
        Object o = clazz.getConstructor().newInstance();
        //给字段设置值
        name.set(o, "boy");
        System.out.println((Boy) o);//Boy{name='boy', age=0, sex= , phone='null'}

        name = clazz.getDeclaredField("phone");
        System.out.println(name);
        name.setAccessible(true);
        name.set(o, "13838389438");
        System.out.println((Boy) o);//Boy{name='boy', age=0, sex= , phone='13838389438'}

    }


}

package reflect.method;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("reflect.method.MD");
        //所有共有方法
//        Arrays.asList(clazz.getMethods()).forEach(method -> System.out.println(method));
        //所有方法
//        Arrays.asList(clazz.getDeclaredMethods()).forEach(method -> System.out.println(method));
        Method show1 = clazz.getMethod("show1", String.class);
        System.out.println(show1);

        Object o = clazz.getConstructor().newInstance();
        show1.invoke(o,"method");

        Method show4=clazz.getDeclaredMethod("show4", int.class);
        System.out.println(show4);
        show4.setAccessible(true);
        Object invoke = show4.invoke(o, 18);
        System.out.println(invoke);













    }
}

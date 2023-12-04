package reflect.construct;

import reflect.bean.Student;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public class ConstructorRefelect {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("reflect.bean.Student");
        //获取构造方法，这里获取的是共有的构造方法
        Constructor<?>[] constructors = clazz.getConstructors();
        List<Constructor<?>> constructors1 = Arrays.asList(constructors);
        constructors1.forEach(cc -> System.out.println(cc));
        //获取所有的构造方法
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        constructors1 = Arrays.asList(declaredConstructors);
        constructors1.forEach(cc -> System.out.println(cc));
        //获取共有午餐的构造方法
        //这里可以传递null，也可以啥都不写，返回的是午餐构造函数的Student对象
        Constructor<?> constructor = clazz.getConstructor(null);
        System.out.println(constructor);//public reflect.bean.Student()
        //开始使用午餐构造方法
        Object o = constructor.newInstance();
        System.out.println((Student) o);

        //获取私有构造方法
        constructor = clazz.getDeclaredConstructor(char.class);
        System.out.println(constructor);//public reflect.bean.Student(char)
        constructor.setAccessible(true);
        o = constructor.newInstance('\u0094');
        System.out.println(o);
    }









}

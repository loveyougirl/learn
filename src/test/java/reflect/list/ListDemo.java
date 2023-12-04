package reflect.list;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

//通过反射越过泛型检查
public class ListDemo {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class listClass = strList.getClass(); //得到 strList 对象的字节码 对象
        //获取add()方法
        Method m = listClass.getMethod("add", Object.class);
        //调用add()方法
        m.invoke(strList, 100.0D);
        Arrays.asList(strList).forEach(list -> System.out.println(list));
        Method remove = listClass.getMethod("remove", Object.class);
        remove.invoke(strList,100.0D);
        /**
         * Method remove = listClass.getMethod("remove", int.class);
         * remove.invoke(strList,100.0D);//argument type mismatch
         */
        Arrays.asList(strList).forEach(list -> System.out.println(list));
    }
}

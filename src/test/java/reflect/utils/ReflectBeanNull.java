package reflect.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReflectBeanNull {
    public static void reflectClassValueToNull(Object model) throws Exception {
        //获取此类的所有父类
        List<Class<?>> listSuperClass = new ArrayList<>();
        Class<?> superclass = model.getClass().getSuperclass();
        while (superclass != null) {
            if (superclass.getName().equals("java.lang.Object")) {
                break;
            }
            listSuperClass.add(superclass);
            superclass = superclass.getSuperclass();
        }
        //遍历处理所有父类的字段
        for (Class<?> clazz : listSuperClass) {
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                Class type = fields[i].getType();
                Method method = clazz.getMethod("set" + name.replaceFirst(name.substring(0, 1),
                        name.substring(0, 1).toUpperCase()), type);
                method.invoke(model, new Object[]{null});
            }
        }
        //处理此类自己的字段
        Field[] fields = model.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            Class type = fields[i].getType();
            //获取属性的set方法
            Method method = model.getClass().getMethod("set" + name.replaceFirst(name.substring(0, 1),
                    name.substring(0, 1).toUpperCase()), type);
            //将值设为null
            method.invoke(model, new Object[]{null});
        }
    }

//    public static <T> T byMethod(T t) {
//        ReflectionUtils.getAllMethods(t.getClass(), method -> Objects.requireNonNull(method).getName().indexOf("set") == 0).forEach(method -> {
//            try {
//                method.invoke(t, new Object[]{null});
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        return t;
//    }
//
//    public static <T> T byField(T t) {
//        ReflectionUtils.getAllFields(t.getClass()).forEach(field -> {
//            try {
//                field.setAccessible(true);
//                field.set(t, null);
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        return t;
//    }

}

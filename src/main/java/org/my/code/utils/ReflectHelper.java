package org.my.code.utils;

public class ReflectHelper {

    /**
     * 加载类：把指定的类加载到系统中
     *
     * @param name 类名称
     * @return 类对象
     * @throws ClassNotFoundException
     */
    public static Class<?> classForName(String name) throws ClassNotFoundException {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("类[" + name + "]加载出错");
        } catch (SecurityException e) {
            e.printStackTrace();
            System.err.println("类[" + name + "]加载出错");
        }
        return Class.forName(name);
    }

    /**
     * 根据名称生成指定的对象
     *
     * @param name 类名称
     * @return 具体的对象, 若发生异常，则返回null
     */
    public static Object objectForName(String name) {
        try {
            //newInstance生成对象
            return Class.forName(name).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("类[" + name + "]获取对象实例出错");
        }
        return null;
    }
}


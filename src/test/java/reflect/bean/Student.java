package reflect.bean;

public class Student {

    //---------------构造方法-------------------
    //（默认的构造方法）
    //Constructor<?> constructor = clazz.getConstructor(String.class);
    //public Student(String str) {
    //如果这里没有使用修饰符修饰Student，那么这个方法直接报错称找不到clazz.getConstructor(String.class)构造，因为getConstructor获取的是共有的
    //然后中间参数是代表类的类型
   Student(String str) {
        System.out.println("(默认)的构造方法 s = " + str);
    }

    //无参构造方法
    public Student() {
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    //有一个参数的构造方法
    public Student(char name) {
        System.out.println("姓名：" + name);
    }

    //有多个参数的构造方法
    public Student(String name, int age) {
        System.out.println("姓名：" + name + "年龄：" + age);//这的执行效率有问题，以后解决。
    }

    //受保护的构造方法
    protected Student(boolean n) {
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private Student(int age) {
        System.out.println("私有的构造方法   年龄：" + age);
    }

}

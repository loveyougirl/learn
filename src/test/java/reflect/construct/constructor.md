# Constructor
通过Class对象可以获取类中的所有信息
1. 获取构造方法：
    public Constructor[] getConstructors()          获取public修饰的
    public Constructor[] getDeclaredConstructors()  获取所有的
    public Constroctor getConstructor(Class... paramterType) 这个是参数类型，比如String.class,byte.class。。。
    public Constroctor getDecaredConstructor(Class... paramterType) 这个是参数类型，比如String.class,byte.class。。。
2. 直接调用构造方法
constructor = clazz.getConstructor()
constructor.newInstance();
这个Constructor对象表示的构造方法来创建构造方法的声明类新实例，并用指定的初始化参数初始化这个实例
返回类型是泛型，
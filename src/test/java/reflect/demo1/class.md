# 获取Class对象
1. Object -》 getClass 方法
2. 所有类都有class属性
3. 通过Class类的方法：forName（）

    public static void main(String[] args) {
        //1。获取class对象
        Student student = new Student();
        Class<? extends Student> clazz = student.getClass();
        System.out.println(clazz.getName());//reflect.bean.Student
        //2.
        Class<Student> studentClass = Student.class;
        System.out.println(clazz == studentClass);//true
        //3.
        try {
            Class<?> aClass = Class.forName("reflect.bean.Student");
            System.out.println(studentClass == aClass);//true
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
表明在运行期间，一个类在JVM层面只有一个Class对象产生，也就是只有一个类的模板，常用方法 3

Class.java:
   @CallerSensitive
   public static Class<?> forName(String className)
                throws ClassNotFoundException {
        Class<?> caller = Reflection.getCallerClass();
        return forName0(className, true, ClassLoader.getClassLoader(caller), caller);
   }
    /** Called after security check for system loader access checks have been made. */
    private static native Class<?> forName0(String name, boolean initialize,
                                                ClassLoader loader,
                                                Class<?> caller)
    throws ClassNotFoundException;
这里的forName0，就需要打开openjdk代码来看了

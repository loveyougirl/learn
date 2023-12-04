package reflect.demo1;

import reflect.bean.Student;

public class RefelectClass {
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
}

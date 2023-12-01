package lamdba;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Random;

public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println("Hi, " + s + ", I'm ClassA");
        }
    }

    static class ClassB {
        public void println(String s) {
            System.out.println("Hi, " + s + ", I'm ClassB");
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = new Random().nextInt(100) % 2 == 0 ? new ClassA()
                : new ClassB();
        getPrintlnMH(obj).invokeExact("MethodHandle");
    }

    private static MethodHandle getPrintlnMH(Object obj) throws Throwable {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(obj.getClass(), "println", mt).bindTo(obj);
    }
}

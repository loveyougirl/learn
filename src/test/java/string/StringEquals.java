package string;

public class StringEquals {
    public static void equal1(String i, String j) {
        try {
            if (i.equals(j)) {
                System.out.println("equal1相等");
            }
        } catch (Exception ex) {
            System.out.println("equal1 异常：");
            ex.printStackTrace();
        } finally {
            System.out.println("equal1结束");
        }
    }

    public static void equal2(String i, String j) {
        try {
            if (j.equals(i)) {
                System.out.println("equal2相等");
            }
        } catch (Exception ex) {
            System.out.println("equal2异常：");
            ex.printStackTrace();
        } finally {
            System.out.println("equal2结束");
        }
    }

    public static void main(String[] args) {
        equal1(null, "abc");
        equal2(null, "abc");
    }
}

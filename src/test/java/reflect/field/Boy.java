package reflect.field;

public class Boy {
    public Boy() {
    }

    public String name;
    protected int age;
    char sex;
    private String phone;

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                '}';
    }
}

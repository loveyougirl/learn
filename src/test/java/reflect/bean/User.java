package reflect.bean;

public class User {
    private static final long serialVersionUID = 930878416859194735L;
    private String username;
    private String password;
    private String age;
    private ParamsList paramsList;
    public User() {
    }

    public User(String username, String password, String age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public User(String username, String password, String age, ParamsList paramsList) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.paramsList = paramsList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ParamsList getParamsList() {
        return paramsList;
    }

    public void setParamsList(ParamsList paramsList) {
        this.paramsList = paramsList;
    }
}

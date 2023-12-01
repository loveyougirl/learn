package lamdba.stream.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToMap {
    @Test
    public void streamToMapError() {
        //??Users??????List??
        List<Users> list = new ArrayList<>();
        list.add(Users.builder().userName("11").userId(1).build());
        list.add(Users.builder().userName("11").userId(2).build());
        list.add(Users.builder().userName("33").userId(3).build());
        //?list?map????stream???map???????key?????????????map??????key??????? Duplicate key
        Map<String, Users> usersMap = list.stream().collect(Collectors.toMap(Users::getUserName, user -> user));
        System.out.println(usersMap.get("11"));
    }

    @Test
    public void streamToMapOK() {//key??????????
        //??Users??????List??
        List<Users> list = new ArrayList<>();
        list.add(Users.builder().userName("11").userId(1).build());
        list.add(Users.builder().userName("11").userId(2).build());
        list.add(Users.builder().userName("33").userId(3).build());
        //?list?map????stream???map???????key?????????????map??????key??????? Duplicate key
        Map<String, Users> usersMap = list.stream()
                .collect(Collectors.toMap(Users::getUserName, Function.identity(), (user1, user2) -> user2));
        System.out.println(usersMap.get("11"));
    }
}

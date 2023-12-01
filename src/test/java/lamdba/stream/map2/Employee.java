package lamdba.stream.map2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private Integer id;
    private String firstName;
    private Integer age;
}

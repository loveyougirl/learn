package lamdba.stream.map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Users {
    private String userName;
    private Integer userId;

}

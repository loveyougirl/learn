package spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SpringA {
    @Autowired
    private SpringB springB;
    @Transactional
    public void addA(){
        springB.addB();
    }
}

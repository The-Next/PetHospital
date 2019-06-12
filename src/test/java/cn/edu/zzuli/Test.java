package cn.edu.zzuli;

import cn.edu.zzuli.jpa.EmployJPA;
import cn.edu.zzuli.jpa.OwnerJPA;
import cn.edu.zzuli.jpa.PetJPA;
import cn.edu.zzuli.jpa.TypeJPA;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private EmployJPA employJPA;

    @Autowired
    private PetJPA petJPA;

    @Autowired
    private TypeJPA typeJPA;

    @Autowired
    private OwnerJPA ownerJPA;
    @org.junit.Test
    public void savepet(){

    }
}

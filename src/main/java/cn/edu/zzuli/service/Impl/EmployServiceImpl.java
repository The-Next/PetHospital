package cn.edu.zzuli.service.Impl;

import cn.edu.zzuli.domain.Employ;
import cn.edu.zzuli.jpa.EmployJPA;
import cn.edu.zzuli.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * @author 程佩
 * @datatime 2019/5/14 16:36
 */
@Service("Employ")
public class EmployServiceImpl implements EmployService {

    @Autowired
    private EmployJPA employJPA;

    /**
    *@Author:程佩
    *@Description:寻找该账号
    *@Date:2019/5/14_16:49
    */
    @Override
    public Employ SearchEmploy(Employ employ) {
        return employJPA.findByName(employ.getName());
    }

    /**
    *@Author:程佩
    *@Description:验证密码
    *@Date:2019/5/14_16:49
    */
    @Override
    public boolean Verify(Employ employ) {
        Employ e = this.SearchEmploy(employ);
        if (e!=null){
            if (employ.getPassword().equals(e.getPassword())){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
    *@Author:程佩
    *@Description:注册
    *@Date:2019/5/14_16:49
    */
    @Override
    public Employ Logon(Employ employ) {
        employJPA.save(employ);
        return employ;
    }
}

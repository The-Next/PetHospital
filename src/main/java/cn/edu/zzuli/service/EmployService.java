package cn.edu.zzuli.service;

import cn.edu.zzuli.entity.Employ;

/**
 * @author 程佩
 * @datatime 2019/5/14 16:28
 */
public interface EmployService {
    public Employ SearchEmploy(Employ employ);
    public boolean Verify(Employ employ);
    public Employ Logon(Employ employ);
}

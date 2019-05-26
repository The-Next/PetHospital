package cn.edu.zzuli.service;

import cn.edu.zzuli.domain.Type;

import java.util.ArrayList;

/**
 * @author 程佩
 * @datatime 2019/5/14 20:19
 */
public interface TypeService {
    public Type add(Type type);
    public void delete(Integer id);
    public Type updata(Type type);
    public ArrayList<Type> getlist();
}

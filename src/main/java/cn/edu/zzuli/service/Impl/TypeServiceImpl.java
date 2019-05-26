package cn.edu.zzuli.service.Impl;

import cn.edu.zzuli.domain.Type;
import cn.edu.zzuli.jpa.TypeJPA;
import cn.edu.zzuli.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 程佩
 * @datatime 2019/5/14 20:23
 */
@Service("Type")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeJPA typeJPA;

    @Override
    public Type add(Type type) {
        typeJPA.save(type);
        return type;
    }

    @Override
    public void delete(Integer id) {
        typeJPA.deleteById(id);
    }

    @Override
    public Type updata(Type type) {
        typeJPA.save(type);
        return type;
    }

    @Override
    public ArrayList<Type> getlist() {
        return (ArrayList<Type>) typeJPA.findAll();
    }
}

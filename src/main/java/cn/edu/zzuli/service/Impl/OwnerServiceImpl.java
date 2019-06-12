package cn.edu.zzuli.service.Impl;

import cn.edu.zzuli.entity.Owner;
import cn.edu.zzuli.jpa.OwnerJPA;
import cn.edu.zzuli.jpa.PetJPA;
import cn.edu.zzuli.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author 程佩
 * @datatime 2019/5/14 18:40
 */
@Service("Owner")
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerJPA ownerJPA;


    @Autowired
    private PetJPA petJPA;

    @Override
    public ArrayList<Owner> ownerList() {
        return (ArrayList<Owner>) ownerJPA.findAll();
    }

    @Override
    public ArrayList<Owner> searchByName(String name) {//模糊查询
        return ownerJPA.selectByNamelike(name);
    }

    @Override
    public Optional<Owner> searchById(Integer id) {
        return ownerJPA.findById(id);
    }

    @Override
    public Owner addOwner(Owner owner) {
        ownerJPA.save(owner);
        return owner;
    }


    @Override
    public Owner updataOwner(Owner owner) {
        petJPA.updatePetByOwner(owner.getName(),owner.getId());
        ownerJPA.save(owner);
        return owner;
    }


    @Override
    public Owner deleteOwner(Owner owner) {
        ownerJPA.deleteById(owner.getId());
        return owner;
    }


    @Override
    public void deleteOwnerById(Integer id) {
        ownerJPA.deleteById(id);
    }
}

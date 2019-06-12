package cn.edu.zzuli.service.Impl;

import cn.edu.zzuli.entity.SPSet;
import cn.edu.zzuli.entity.Specialties;
import cn.edu.zzuli.entity.Vets;
import cn.edu.zzuli.jpa.SpecialtiesJPA;
import cn.edu.zzuli.jpa.VetsJPA;
import cn.edu.zzuli.service.Vets_SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 程佩
 * @datatime 2019/5/15 11:10
 */
@Service("Vets_Sp")
public class Vets_SpServiceImpl implements Vets_SpService {

    @Autowired
    private VetsJPA vetsJPA;

    @Autowired
    private SpecialtiesJPA specialtiesJPA;

    @Override
    public ArrayList<Vets> getVetsList() {
        return (ArrayList<Vets>) vetsJPA.findAll();
    }

    @Override
    public ArrayList<Specialties> getSpecialtiesList() {
        return (ArrayList<Specialties>) specialtiesJPA.findAll();
    }

    @Override
    public void insert(SPSet set) throws Exception{
        if (vetsJPA.findByName(set.getVname())!=null&&specialtiesJPA.findByName(set.getSname())!=null){
            Vets vets = vetsJPA.findByName(set.getVname());
            vets.setName(set.getVname());
            Specialties specialties = specialtiesJPA.findByName(set.getSname());
            List<Specialties> list = vets.getSpecialtiesList();
            list.add(specialties);
            vetsJPA.save(vets);
        }else if (vetsJPA.findByName(set.getVname())==null&&specialtiesJPA.findByName(set.getSname())!=null){
            Vets vets = new Vets();
            vets.setName(set.getVname());
            Specialties specialties = specialtiesJPA.findByName(set.getSname());
            List<Specialties> list = new ArrayList<>();
            list.add(specialties);
            vets.setSpecialtiesList(list);
            vetsJPA.save(vets);
        }else if (vetsJPA.findByName(set.getVname())!=null&&specialtiesJPA.findByName(set.getSname())==null){
            Specialties specialties = new Specialties();
            specialties.setName(set.getSname());
            specialtiesJPA.save(specialties);
            Vets vets = vetsJPA.findByName(set.getVname());
            List<Specialties> list = vets.getSpecialtiesList();
            list.add(specialties);
            vetsJPA.save(vets);
        }else {
            Specialties specialties = new Specialties();
            specialties.setName(set.getSname());
            specialtiesJPA.save(specialties);

            Vets vets = new Vets();
            vets.setName(set.getVname());
            List<Specialties> list = new ArrayList<>();
            list.add(specialties);
            vets.setSpecialtiesList(list);
            vetsJPA.save(vets);
        }
    }

    @Override
    public Optional<Vets> getVets(Integer id) {
        return vetsJPA.findById(id);
    }

    @Override
    public Optional<Specialties> getSpecialties(Integer id) {
        return specialtiesJPA.findById(id);
    }
}

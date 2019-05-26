package cn.edu.zzuli.service.Impl;

import cn.edu.zzuli.domain.Pet;
import cn.edu.zzuli.jpa.PetJPA;
import cn.edu.zzuli.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author 程佩
 * @datatime 2019/5/14 21:01
 */
@Service("Pet")
public class PetServiceImpl implements PetService {

    @Autowired
    private PetJPA petJPA;

    @Override
    public Pet addPet(Pet pet) {
        petJPA.save(pet);
        return pet;
    }

    @Override
    public void deletePet(Integer id) {
        petJPA.deleteById(id);
    }

    @Override
    public Pet uptataPet(Pet pet) {
        petJPA.save(pet);
        return pet;
    }

    @Override
    public ArrayList<Pet> getPetList() {
        return (ArrayList<Pet>)petJPA.findAll();
    }

    @Override
    public Optional<Pet> getPetById(Integer id) {
        return petJPA.findById(id);
    }

    @Override
    public ArrayList<Pet> getPetByType(Integer id) {
        return petJPA.getPetByType(id);
    }

    @Override
    public ArrayList<Pet> getPetByOwner(Integer id) {
        return petJPA.getPetByOwner(id);
    }
}

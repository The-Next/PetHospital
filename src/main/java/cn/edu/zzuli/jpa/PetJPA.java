package cn.edu.zzuli.jpa;

import cn.edu.zzuli.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:47
 */
public interface PetJPA extends JpaRepository<Pet,Integer> {
    @Query("select pet from Pet pet where pet.typeId = ?1")
    public ArrayList<Pet> getPetByType(Integer id);

    @Query("select pet from Pet pet where pet.ownerId = ?1")
    public ArrayList<Pet> getPetByOwner(Integer id);

    @Transactional
    @Modifying
    @Query("update Pet pet set pet.ownerName = ?1 where pet.ownerId = ?2")
    public void updatePetByOwner(String name, Integer id);
}

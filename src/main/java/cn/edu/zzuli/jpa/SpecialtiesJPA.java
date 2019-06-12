package cn.edu.zzuli.jpa;

import cn.edu.zzuli.entity.Specialties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:48
 */
public interface SpecialtiesJPA extends JpaRepository<Specialties,Integer> {
    Specialties findByName(String name);
    ArrayList<Specialties> findByNameContaining(String name);
}

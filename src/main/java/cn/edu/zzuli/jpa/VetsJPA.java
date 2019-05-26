package cn.edu.zzuli.jpa;

import cn.edu.zzuli.domain.Vets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:48
 */
public interface VetsJPA extends JpaRepository<Vets,Integer> {
    Vets findByName(String name);
    ArrayList<Vets> findByNameContaining(String name);
}

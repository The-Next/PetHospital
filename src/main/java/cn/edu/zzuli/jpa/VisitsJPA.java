package cn.edu.zzuli.jpa;

import cn.edu.zzuli.domain.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:49
 */
public interface VisitsJPA extends JpaRepository<Visits,Integer> {
    @Query("select v from Visits v where v.petId = ?1")
    public ArrayList<Visits> getListByPet(Integer id);
}

package cn.edu.zzuli.jpa;

import cn.edu.zzuli.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:45
 */
public interface OwnerJPA extends JpaRepository<Owner,Integer> {
    @Query(value = "select o from Owner o where o.name LIKE CONCAT('%',?1,'%') ")
    public ArrayList<Owner> selectByNamelike(String name);
}

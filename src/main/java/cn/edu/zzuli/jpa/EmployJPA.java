package cn.edu.zzuli.jpa;

import cn.edu.zzuli.domain.Employ;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:44
 */
public interface EmployJPA extends JpaRepository<Employ,Integer> {
    Employ findByName(String name);
}

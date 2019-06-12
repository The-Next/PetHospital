package cn.edu.zzuli.jpa;

import cn.edu.zzuli.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 程佩
 * @datatime 2019/5/14 14:43
 */
public interface TypeJPA extends JpaRepository<Type,Integer> {
}

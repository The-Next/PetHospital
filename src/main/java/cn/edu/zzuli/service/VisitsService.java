package cn.edu.zzuli.service;

import cn.edu.zzuli.domain.Visits;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author 程佩
 * @datatime 2019/5/15 9:22
 */
public interface VisitsService {
    public Visits add(Visits visits);
    public void delete(Integer id);
    public Visits updata(Visits visits);
    public ArrayList<Visits> getlist();
    public ArrayList<Visits> getListByPet(Integer id);
    public Optional<Visits> getVisitById(Integer id);
}

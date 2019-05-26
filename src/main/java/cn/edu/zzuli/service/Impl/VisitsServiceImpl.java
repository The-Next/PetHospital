package cn.edu.zzuli.service.Impl;

import cn.edu.zzuli.domain.Visits;
import cn.edu.zzuli.jpa.VisitsJPA;
import cn.edu.zzuli.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author 程佩
 * @datatime 2019/5/15 9:25
 */
@Service("Visits")
public class VisitsServiceImpl implements VisitsService {

    @Autowired
    private VisitsJPA visitsJPA;

    @Override
    public Visits add(Visits visits) {
        visitsJPA.save(visits);
        return visits;
    }

    @Override
    public void delete(Integer id) {
        visitsJPA.deleteById(id);
    }

    @Override
    public Visits updata(Visits visits) {
        visitsJPA.save(visits);
        return visits;
    }

    @Override
    public ArrayList<Visits> getlist() {
        return (ArrayList<Visits>) visitsJPA.findAll();
    }

    @Override
    public ArrayList<Visits> getListByPet(Integer id) {
        return visitsJPA.getListByPet(id);
    }

    @Override
    public Optional<Visits> getVisitById(Integer id) {
        return visitsJPA.findById(id);
    }
}

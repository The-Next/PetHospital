package cn.edu.zzuli.service;

import cn.edu.zzuli.domain.SPSet;
import cn.edu.zzuli.domain.Specialties;
import cn.edu.zzuli.domain.Vets;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author 程佩
 * @datatime 2019/5/15 11:02
 */
public interface Vets_SpService {
    public ArrayList<Vets> getVetsList();
    public ArrayList<Specialties> getSpecialtiesList();
    public void insert(SPSet set) throws Exception;
    public Optional<Vets> getVets(Integer id);
    public Optional<Specialties> getSpecialties(Integer id);
}

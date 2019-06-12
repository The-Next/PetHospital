package cn.edu.zzuli.service;

import cn.edu.zzuli.entity.Owner;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author 程佩
 * @datatime 2019/5/14 18:30
 */
public interface OwnerService {
   public ArrayList<Owner> ownerList();
   public ArrayList<Owner> searchByName(String name);//模糊查询
   public Optional<Owner> searchById(Integer id);
   public Owner addOwner(Owner owner);
   public Owner updataOwner(Owner owner);
   public Owner deleteOwner(Owner owner);
   public void deleteOwnerById(Integer id);
}

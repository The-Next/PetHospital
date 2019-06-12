package cn.edu.zzuli.controller;

import cn.edu.zzuli.entity.SPSet;
import cn.edu.zzuli.entity.Specialties;
import cn.edu.zzuli.entity.Vets;
import cn.edu.zzuli.service.Vets_SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author 程佩
 * @datatime 2019/5/15 11:39
 */
@RestController
@RequestMapping(value = "/vetsp")
public class Vets_SpController {

    @Autowired
    private Vets_SpService service;
    @CrossOrigin
    @RequestMapping(value = "getvetslist",method = RequestMethod.GET)
    public ArrayList<Vets> getVetsList(){
        return service.getVetsList();
    }

    @RequestMapping(value = "getsplist",method = RequestMethod.GET)
    public ArrayList<Specialties> getSpecialtiesList(){
        return service.getSpecialtiesList();
    }

    @RequestMapping(value = "getvetbyid/{id}",method = RequestMethod.GET)
    public Optional<Vets> getVetsById(@PathVariable("id") Integer id){
        return service.getVets(id);
    }

    @RequestMapping(value = "getspbyid/{id}",method = RequestMethod.GET)
    public Optional<Specialties> getSpById(@PathVariable("id") Integer id){
        return service.getSpecialties(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> insert(@RequestBody SPSet set){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            System.out.println(set.getVname()+" "+set.getSname());
            service.insert(set);
            map.put("state","1");
            map.put("message","添加成功!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state","0");
            map.put("message","添加失败!");
        }finally {
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }
    }

}

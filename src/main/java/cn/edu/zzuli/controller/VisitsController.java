package cn.edu.zzuli.controller;

import cn.edu.zzuli.entity.Visits;
import cn.edu.zzuli.service.VisitsService;
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
 * @datatime 2019/5/15 9:32
 */
@RestController
@RequestMapping(value = "/visits")
public class VisitsController {
    @Autowired
    private VisitsService visitsService;
    @CrossOrigin
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> add(@RequestBody Visits visits){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            visitsService.add(visits);
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

    @CrossOrigin
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,Object>> delete(@PathVariable("id") Integer id){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            visitsService.delete(id);
            map.put("state","1");
            map.put("message","删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state","0");
            map.put("message","删除失败!");
        }finally {
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/updata",method = RequestMethod.PATCH)
    public ResponseEntity<Map<String,Object>> updata(@RequestBody Visits visits){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            visitsService.updata(visits);
            map.put("state","1");
            map.put("message","更新成功!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state","0");
            map.put("message","更新失败!");
        }finally {
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public ArrayList<Visits> getlist(){
        return visitsService.getlist();
    }

    @CrossOrigin
    @RequestMapping(value = "/getlistbypet/{id}",method = RequestMethod.GET)
    public ArrayList<Visits> getlist(@PathVariable("id") Integer id){
        return visitsService.getListByPet(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/getbyid/{id}",method = RequestMethod.GET)
    public Optional<Visits> getbyid(@PathVariable("id") Integer id){
        return visitsService.getVisitById(id);
    }
}

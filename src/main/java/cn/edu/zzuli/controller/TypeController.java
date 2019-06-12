package cn.edu.zzuli.controller;

import cn.edu.zzuli.entity.Type;
import cn.edu.zzuli.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 程佩
 * @datatime 2019/5/14 20:29
 */
@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/type",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> add(@RequestBody Type type){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            typeService.add(type);
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

    @RequestMapping(value = "/type/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,Object>> delete(@PathVariable("id") Integer id){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            typeService.delete(id);
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

    @RequestMapping(value = "/type",method = RequestMethod.PATCH)
    public ResponseEntity<Map<String,Object>> updata(@RequestBody Type type){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            typeService.updata(type);
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
    @RequestMapping(value = "/type",method = RequestMethod.GET)
    public ArrayList<Type> get(){
        return typeService.getlist();
    }
}

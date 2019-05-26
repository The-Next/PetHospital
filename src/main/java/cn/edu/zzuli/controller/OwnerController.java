package cn.edu.zzuli.controller;

import cn.edu.zzuli.domain.Employ;
import cn.edu.zzuli.domain.Owner;
import cn.edu.zzuli.service.OwnerService;
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
 * @datatime 2019/5/14 19:06
 */

@RestController
@RequestMapping(value = "/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @CrossOrigin
    @RequestMapping(value = "getlist",method = RequestMethod.GET)
    public ArrayList<Owner> getOwnerList(){
        return ownerService.ownerList();
    }

    @RequestMapping(value = "getlistbyname",method = RequestMethod.GET)
    public ArrayList<Owner> getOwnerListByName(String name){
        return ownerService.searchByName(name);
    }

    @CrossOrigin
    @RequestMapping(value = "getbyid/{id}" ,method = RequestMethod.GET)
    public Optional<Owner> getOwnerById(@PathVariable("id") Integer id){
        return ownerService.searchById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> addOwner(@RequestBody Owner owner){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            ownerService.addOwner(owner);
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
    @RequestMapping(value = "updata",method = RequestMethod.PATCH)
    public ResponseEntity<Map<String,Object>> updateOwner(@RequestBody Owner owner){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            ownerService.updataOwner(owner);
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


    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,Object>> deleteOwner(@RequestBody Owner owner){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            ownerService.deleteOwner(owner);
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

    @RequestMapping(value = "deletebyid/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,Object>> deleteOwnerById(@PathVariable("id") Integer id){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            ownerService.deleteOwnerById(id);
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
}

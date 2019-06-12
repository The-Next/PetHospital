package cn.edu.zzuli.controller;

import cn.edu.zzuli.entity.Pet;
import cn.edu.zzuli.service.PetService;
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
 * @datatime 2019/5/15 8:39
 */
@RestController
@RequestMapping(value = "/pet")
public class PetController {

    @Autowired
    private PetService petService;
    @CrossOrigin
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> addPet(@RequestBody Pet pet){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            petService.addPet(pet);
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

    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,Object>> deletePet(@PathVariable("id") Integer id){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            petService.deletePet(id);
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
    @RequestMapping(value = "updata",method = RequestMethod.PATCH)
    public ResponseEntity<Map<String,Object>> updataPet(@RequestBody Pet pet){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            petService.uptataPet(pet);
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
    @RequestMapping(value = "getlist" ,method = RequestMethod.GET)
    public ArrayList<Pet> getPetList(){
        return petService.getPetList();
    }

    @CrossOrigin
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public Optional<Pet> getPetListById(@PathVariable("id") Integer id){
        return petService.getPetById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "getbyowner/{id}",method = RequestMethod.GET)
    public ArrayList<Pet> getPetListByOwner(@PathVariable("id") Integer  id){
        return petService.getPetByOwner(id);
    }

    @CrossOrigin
    @RequestMapping(value = "getbytype/{id}")
    public ArrayList<Pet> getPetListByType(@PathVariable("id") Integer id){
        return petService.getPetByType(id);
    }
}

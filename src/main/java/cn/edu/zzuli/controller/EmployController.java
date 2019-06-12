package cn.edu.zzuli.controller;

import cn.edu.zzuli.entity.Employ;
import cn.edu.zzuli.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 程佩
 * @datatime 2019/5/14 16:51
 */
@RestController
@RequestMapping(value = "/employ")
public class EmployController {
    @Autowired
    private EmployService employService;
    /**
    *@Author:程佩
    *@Description:
    *@Date:2019/5/14_17:19
    */
    @CrossOrigin
    @RequestMapping(value = "verify",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> Verify(@RequestBody Employ employ){
        Map<String,Object> map = new HashMap<String, Object>();
        boolean flag = employService.Verify(employ);
        if (flag){
            map.put("state","1");
            map.put("message","登陆成功！");
        }else {
            map.put("state","0");
            map.put("message","密码或账号不正确！");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
    /**
    *@Author:程佩
    *@Description:注册账号
    *@Date:2019/5/14_17:23
    */
    @CrossOrigin
    @RequestMapping(value = "logon",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> LogOn(@RequestBody Employ employ){
        Map<String,Object> map = new HashMap<String, Object>();
        Employ searchEmploy = employService.SearchEmploy(employ);
        if (searchEmploy == null){
            employService.Logon(employ);
            map.put("state","1");
            map.put("message","注册成功！");
        }else {
            map.put("state","0");
            map.put("message","账号已存在！");
        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
}

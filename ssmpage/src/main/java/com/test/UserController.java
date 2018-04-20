package com.test;

import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService us;
    @RequestMapping("readTotal")
    @ResponseBody
    public String readTotal(){
     return  ""+us.readTotal();
    }
    @RequestMapping("fenye/{page}/{size}")
    @ResponseBody
    public List<User> fenye(@PathVariable int page,@PathVariable int size){
          return us.fenye(page,size);
    }
}
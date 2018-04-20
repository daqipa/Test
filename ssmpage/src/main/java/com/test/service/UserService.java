package com.test.service;

import com.test.dao.UserDao;
import com.test.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Resource
    private UserDao ud;

    public List<User> fenye(int page, int size) {
        Map<String,Object> params=new HashMap<String, Object>();
        params.put("start",(page-1)*size);
        params.put("size",size);
       return ud.fenye(params);
    }

    public int readTotal() {
        return ud.readTotal();
    }
}

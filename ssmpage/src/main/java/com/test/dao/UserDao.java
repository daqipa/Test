package com.test.dao;

import com.test.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserDao {
    List<User> fenye(Map<String,Object> params);

    int readTotal();
}

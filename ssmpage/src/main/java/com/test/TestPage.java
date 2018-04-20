package com.test;

import com.test.dao.UserDao;
import com.test.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPage {
   static SqlSessionFactory factory;
    static {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    //分页查询
    public static void fenye(){
        SqlSession session = factory.openSession();
        //创建实现了UserDao接口的类的一个对象
        UserDao userDao = session.getMapper(UserDao.class);
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("start",2);
        params.put("size",2);
        List<User> users = userDao.fenye(params);
        for(User u:users){
            System.out.println(u.getName());
        }
        session.close();//不关闭就会产生内存泄漏
    }

    public static void main(String[] args) {
        fenye();
    }
}

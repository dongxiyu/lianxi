package com.x.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author dxy
 * @date 2021/3/30 - 22:28
 */
public  class Mybatis {
   static  SqlSessionFactory factory=null;
    static {
        try {
            //获取sqlsessionfactory对象
            InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return factory.openSession(true);
    }
}

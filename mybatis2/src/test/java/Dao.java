import com.x.dao.Mapper;
import com.x.pojo.Account;
import com.x.utils.Mybatis;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author dxy
 * @date 2021/3/30 - 22:55
 */
public class Dao {
    @Test
    public void test(){
         SqlSession sqlSession = Mybatis.getSqlSession();
        //List<Account> all = sqlSession.getMapper(Mapper.class).findAll();
        List<Account> all = sqlSession.selectList("com.x.dao.Mapper.findAll",null,new RowBounds(0,2));
        for (Account account : all) {
            System.out.println(account);
        }
        sqlSession.close();
    }
    @Test
    public void testFindAll(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("startindex",0);
        map.put("pagesize",2);
        List<Account> all = sqlSession.getMapper(Mapper.class).findAll2(map);
        for (Account account : all) {
            System.out.println(account);
        }
        sqlSession.close();
    }
    @Test
    public void add(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        mapper.add(new Account(5,"a",123));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void update(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        mapper.update(new Account(5,"a",12345));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void delete(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        mapper.delete(5);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void like(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        List<Account> a = sqlSession.getMapper(Mapper.class).like("a");
        for (Account account : a) {
            System.out.println(account);
        }
    }
}

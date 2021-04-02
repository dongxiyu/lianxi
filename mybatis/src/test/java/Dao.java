import com.x.dao.DAO;
import com.x.pojo.Account;
import com.x.utils.Mybatis;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author dxy
 * @date 2021/3/30 - 22:55
 */
public class Dao {
    @Test
    public void test(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        //List<Account> all = sqlSession.getMapper(DAO.class).findAll();
        List<Account> all = sqlSession.selectList("com.x.dao.DAO.findAll",101,new RowBounds(1,2));
        for (Account account : all) {
            System.out.println(account);
        }
        sqlSession.close();
    }
    @Test
    public void add(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        DAO mapper = sqlSession.getMapper(DAO.class);
        mapper.add(new Account(5,"a",123));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void update(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        DAO mapper = sqlSession.getMapper(DAO.class);
        mapper.update(new Account(5,"a",12345));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void delete(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        DAO mapper = sqlSession.getMapper(DAO.class);
        mapper.delete(5);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void like(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        List<Account> a = sqlSession.getMapper(DAO.class).like("a");
        for (Account account : a) {
            System.out.println(account);
        }
    }
}

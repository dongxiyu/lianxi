
import com.x.dao.BlogMapper;
import com.x.pojo.Blog;
import com.x.utils.GetUUID;
import com.x.utils.Mybatis;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author dxy
 * @date 2021/3/31 - 22:42
 */
public class TeacherTest {
    @Test
    public void test0(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogs = mapper.find();
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
    @Test
    public void test(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
       //mapper.insert(new Blog(GetUUID.getId(),"测试","dxy",new Date(),12));
       mapper.insert(new Blog(GetUUID.getId(),"java","dxy",new Date(),21));
       mapper.insert(new Blog(GetUUID.getId(),"spring","dxy",new Date(),31));
       mapper.insert(new Blog(GetUUID.getId(),"cloud","dxy",new Date(),50));
       mapper.insert(new Blog(GetUUID.getId(),"boot","dxy",new Date(),100));

        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("title","o");
        map.put("author","x");
        List<Blog> query = mapper.findQuery(map);
        for (Blog blog : query) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void test3(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        //map.put("title","java");
        map.put("views",50);
        List<Blog> query = mapper.findQuery2(map);
        for (Blog blog : query) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void test4(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        map.put("ids",list);
        List<Blog> query = mapper.findQuery3(map);
        for (Blog blog : query) {
            System.out.println(blog);
        }
        sqlSession.close();
    }


}

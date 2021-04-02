
import com.x.dao.StudentMapper;
import com.x.dao.TeacherMapper;
import com.x.pojo.Student;
import com.x.pojo.Teacher;
import com.x.utils.Mybatis;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author dxy
 * @date 2021/3/31 - 22:42
 */
public class TeacherTest {
    @Test
    public void test(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        List<Student> teachers = sqlSession.getMapper(StudentMapper.class).findAll();
        for (Student teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        Teacher teachers = sqlSession.getMapper(TeacherMapper.class).find(1);
        System.out.println(teachers);
        sqlSession.close();
    }
}

package com.x.dao;

import com.x.pojo.Blog;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author dxy
 * @date 2021/4/2 - 17:02
 */
public interface BlogMapper {
    @Select("select * from blog")
    List<Blog> find();
    int insert(Blog blog);
    List<Blog> findQuery(Map map);
    List<Blog> findQuery2(Map map);
    List<Blog> findQuery3(Map map);
}

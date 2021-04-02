package com.x.dao;

import com.x.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dxy
 * @date 2021/3/31 - 22:34
 */
public interface StudentMapper {
    List<Student> findAll();
}

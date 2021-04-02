package com.x.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author dxy
 * @date 2021/3/31 - 22:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class Student implements Serializable {
    private int id;
    private String name;
    //private int tid;
    private Teacher teacher;
}

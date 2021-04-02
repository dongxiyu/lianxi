package com.x.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dxy
 * @date 2021/4/2 - 16:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}

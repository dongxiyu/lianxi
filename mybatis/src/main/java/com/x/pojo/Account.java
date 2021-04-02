package com.x.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dxy
 * @date 2021/3/30 - 22:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private int id;
    private String name;
    private int money;

}

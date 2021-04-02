package com.x.utils;

import java.util.UUID;

/**
 * @author dxy
 * @date 2021/4/2 - 17:11
 */
public class GetUUID {
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }
}

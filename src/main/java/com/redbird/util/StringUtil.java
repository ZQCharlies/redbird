package com.redbird.util;

import java.util.UUID;

public class  StringUtil {

    public static String getUUID(){
        return (UUID.randomUUID()+"").replace("-","");
    }

    public static boolean isNullOrEmpty(String str){
        if (str == null){
            return true;
        }else if ("".equals(str)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        System.out.println(getUUID());
    }
}

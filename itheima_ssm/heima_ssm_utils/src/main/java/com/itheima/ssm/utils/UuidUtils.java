package com.itheima.ssm.utils;



import java.util.UUID;


public class UuidUtils {

    //生成一个uuid
    public static String makeUuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}

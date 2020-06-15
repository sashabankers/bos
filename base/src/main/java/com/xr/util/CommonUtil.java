package com.xr.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;

public class CommonUtil {
    /*产生盐值*/
    public static String getSalt(){
        //生成盐需要存入数据库中的
        String salt=new SecureRandomNumberGenerator().nextBytes().toHex();
        return salt;
    }
    /*根据颜值和原始密码MD5加密n次*/
    public static String getMD5Password(String originalPassword,String salt,Integer n){
        String md5Password=new Md5Hash(originalPassword,salt,n).toString();
        return md5Password;
    }
    //测试
    public static void main(String[] args) {
        String salt=getSalt();
        System.out.println(salt);
        String pwd=getMD5Password("123456",salt,2);
        System.out.println(pwd);
    }
}

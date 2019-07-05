package com.util;


import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;
@Repository
public class Md5 {
    /**
     * MD5方法
     *
     * @param text 明文
//     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public String md5(String text){
        //加密后的字符串
        String encodeStr= DigestUtils.md5DigestAsHex(text.getBytes());
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }
    /**
     * MD5验证方法
     *
     * @param text 明文
//     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public boolean verify(String text, String md5){
        //根据传入的密钥进行验证
        String md5Text = md5(text);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }

        return false;
    }
}

package pers.justep.crawlerbilibili.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author JustEP
 * @version 1.0
 * @classname MD5Util
 * @description 将字符串转化为MD5
 * @createtime 2019/10/27 18:36:00
 */
public class Md5Util {
    public static String getMd5(String text){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}

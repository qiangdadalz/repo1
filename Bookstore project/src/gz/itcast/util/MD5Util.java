package gz.itcast.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * @author APPle
 *
 */
public class MD5Util {

    /**
     * 传入原始密码，返回加密之后的密码字符串
     * @param password
     * @return
     */
    public static String md5(String password){
        try {
            //1)创建加密类对象
            MessageDigest md = MessageDigest.getInstance("md5");
            //2）将传入的密码进行加密,
            byte[] byteArray = md.digest(password.getBytes());

            //得到16个10进制数组成的字节数组byte[] byteArray，类似-127 -36 -101 -37 82 -48 77 -62 0 54  -37 -40 49 62 -48 85
            //3）把每个10进制的字节数值转换为2位字符的十六进制的字符串，并将其拼接
            StringBuffer sb = new StringBuffer();
            for (byte b:byteArray) {
                sb.append(numToHex(b));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 传入一个10进制的字节数值，返回2位的十六进制的字符串
     * @param num
     * @return
     */
    private static String numToHex(byte num){
        /**
         * byte类型：
         * 		无符号位 ： 取值范围：   0 ~ 255
         *      有符号为： 取值范围：   -128 ~ 127
         */
        int targetNum = 0;
        //如果是负数，则先转为正数，即加256，再进行计算；否则，直接使用
        if (num<0){
            targetNum = 256+num;
        }else {
            targetNum = num;
        }
        //第一位字符的值
        int first = targetNum/16;
        //第二位字符的值
        int second = targetNum%16;

        return strArray[first]+strArray[second];
    }

    private static String[] strArray = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    public static void main(String[] args) {
        String result = md5("1234"); // 81dc9bdb52d04dc20036dbd8313ed055
        System.out.println(result);  // 81dc9bdb52d04dc20036dbd8313ed055

        ///System.out.println(Integer.toHexString(-36));
    }
}

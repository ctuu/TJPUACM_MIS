package cn.ningxy.util;

import java.security.MessageDigest;

/**
 * @Author: ningxy
 * @Description: MD5加密工具类
 * @Date: 2018-04-25 17:16
 **/
public class MD5Util {

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
    * @Author: ningxy
    * @Description: 返回大写MD5
    * @params: [origin, charsetname]
     * 要转化的md5字符串, 转化过程中使用的字符集
    * @return: java.lang.String
    * @Date: 2018/4/25 下午5:24
    */
    private static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString.toUpperCase();
    }

    /**
    * @Author: ningxy
    * @Description: 调用这个函数进行md5非对称加密
     * 调用MD5Encode，返回大写MD5字符串
    * @params: [originString] 要加密的字符串
    * @return: java.lang.String
    * @Date: 2018/4/25 下午5:20
    */
    public static String MD5EncodeUtf8(String originString) {
//        加盐操作，防止通过MD5字典进行解密
        originString = "~#&^*@#[|}P3-4o;ox0a" + originString + "geelys*&^ningXYxxxx_)(+24|SA9834!@~fucklj;D../<><L";
        return MD5Encode(originString, "utf-8");
    }
}

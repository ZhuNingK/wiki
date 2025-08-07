package com.wiki.utils;

import cn.hutool.crypto.symmetric.SymmetricCrypto;

import static cn.hutool.core.text.CharSequenceUtil.isBlank;

/**
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.utils
 * @Author: zhuningkang
 * @CreateTime: 2025-08-07  22:31:59
 * @Description: 国密SM4加密工具类
 * @Version: 1.0
 */
public class SM4Util {

    //key必须是16字节，即128位
    final static String key = "aquaticwiki1234";

    //指明加密算法和秘钥
    static SymmetricCrypto sm4 = new SymmetricCrypto("SM4/ECB/PKCS5Padding", key.getBytes());

    /**
     * 加密为16进制，也可以加密成base64/字节数组
     *
     * @param plaintext 明文
     * @return 密文
     */
    public static String encryptSm4(String plaintext) {
        if (isBlank(plaintext)) {
            return "";
        }
        return sm4.encryptHex(plaintext);
    }

    /**
     * 解密
     *
     * @param ciphertext 密文
     * @return 明文
     */
    public static String decryptSm4(String ciphertext) {
        if (isBlank(ciphertext)) {
            return "";
        }
        return sm4.decryptStr(ciphertext);
    }

}

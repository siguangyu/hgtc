package com.yys.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

/**
 * 加密工具类
 */
public class CryptoUtils {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public static void main(String[] args) {
//        String pass = encode("2234jlsdkjf");
//        System.out.println(pass);
//        System.out.println(pass.length());
        
//        System.out.println(encodeByMurmur("https://item.jd.com/12367368.html"));
//        
//        String rsaModulus = "d3bcef1f00424f3261c89323fa8cdfa12bbac400d9fe8bb627e8d27a44bd5d59dce559135d678a8143beb5b8d7056c4e1f89c4e1f152470625b7b41944a97f02da6f605a49a93ec6eb9cbaf2e7ac2b26a354ce69eb265953d2c29e395d6d8c1cdb688978551aa0f7521f290035fad381178da0bea8f9e6adce39020f513133fb";
//        String rsaExponent ="10001";
//        System.out.println(encryptWithRSA("987456321_fox", rsaModulus, rsaExponent));

        String base64str = encodeByBase64("art2017中汶quqiMADE");
        
        System.out.println(base64str);
        System.out.println(decodeByBase64(base64str));
        
    }

    public static String encodeByBase64(String rawStr) {
        String encodedStr = "";
        
        if (rawStr == null) {
            return "";
        }
        
        try {
            encodedStr = Base64Utils.encodeToString(rawStr.getBytes("utf-8"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return encodedStr;
    }
    
    public static String decodeByBase64(String encodedStr) {
        String rawStr = "";
        
        if (encodedStr == null) {
            return "";
        }
        
        try {
            rawStr = new String(Base64Utils.decodeFromString(encodedStr), "utf-8");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return rawStr;
    }
    
    /**
     * 使用murmurhash算法计算hash值
     * @param rawSeq
     * @return
     */
    public static String encodeByMurmur(CharSequence rawSeq) {
        
        HashFunction murmur3 = Hashing.murmur3_32();
        return murmur3.hashString(rawSeq, Charsets.UTF_8).toString();
        
    }
    
    /**
     * 原始密码加密
     *
     * @param rawPassword
     * @return 密文
     */
    public static String encode(CharSequence rawPassword) {
        return encoder.encode(rawPassword);
    }

    /**
     * 检查密码与密文是否匹配
     *
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
    
    /**
     * RSA算法加密
     * @param rawText
     * @param rsaModulus
     * @param rsaExponent
     * @return
     */
    public static String encryptWithRSA(String rawText, String rsaModulus, String rsaExponent) {
        String result = "";
                
        Cipher cipher = null;
        try {
            PublicKey publicKey = getPublicKey(rsaModulus, rsaExponent);
            // 使用默认RSA
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(rawText.getBytes());
            return bytesToHexString(output);
        } catch (Exception e) {
            
        }
        
        return result;
    }
    
    /**
     * 根据modulus和exponent算出公钥
     * 
     * @param rsaModulus
     * @param rsaExponent
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static PublicKey getPublicKey(String rsaModulus, String rsaExponent)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        BigInteger bigIntModulus = new BigInteger(rsaModulus, 16);

        BigInteger bigIntPrivateExponent = new BigInteger(rsaExponent, 16);

        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigIntModulus, bigIntPrivateExponent);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        return publicKey;

    }
    
    /**
     * 转换为16进制字符串
     * 
     * @param bArr
     * @return
     */
    private static String bytesToHexString(byte[] bArr) {
        StringBuffer sb = new StringBuffer(bArr.length);
        String sTmp;

        for (int i = 0; i < bArr.length; i++) {
            sTmp = Integer.toHexString(0xFF & bArr[i]);
            if (sTmp.length() < 2)
                sb.append(0);
            sb.append(sTmp);
        }

        return sb.toString();
    }
}
